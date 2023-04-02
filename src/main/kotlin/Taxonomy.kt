import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import javax.xml.parsers.DocumentBuilderFactory

data class Organism(val nomScientifique: String, val sequenceARN: String)

class Taxonomy {
    suspend fun searchARN(requete: String): List<Organism> {
        println("Création du client HTTP...")
        val client = HttpClient(CIO) {
            install(ContentNegotiation) { json(Json { prettyPrint = true; isLenient = true }) }
            install(HttpTimeout) { requestTimeoutMillis = 5_000 }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
        println("Client HTTP créé avec succès.")
        val organisms = mutableListOf<Organism>()
        val baseUrl = "https://eutils.ncbi.nlm.nih.gov/entrez/eutils"
        val esearchUrl = "$baseUrl/esearch.fcgi?db=taxonomy&term=$requete&usehistory=y"
        val esearchResponse: HttpResponse = client.get(esearchUrl)
        val esearchXml = esearchResponse.bodyAsText()
        println(esearchXml)
        val esearchDocBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        val esearchDoc = withContext(Dispatchers.IO) {esearchDocBuilder.parse(esearchXml.byteInputStream())}
        val queryKey = esearchDoc.getElementsByTagName("QueryKey").item(0).textContent
        val webEnv = esearchDoc.getElementsByTagName("WebEnv").item(0).textContent
        val efetchUrl = "$baseUrl/efetch.fcgi?db=taxonomy&query_key=$queryKey&WebEnv=$webEnv&rettype=fasta&retmode=text"
        println("efetchUrl is OK")
        val efetchResponse: HttpResponse = client.get(efetchUrl)
        println(efetchResponse)
        val sequences = efetchResponse.bodyAsText().trim().split(">")
        println(sequences)
        for (sequence in sequences) {
            if (sequence.isNotEmpty()) {
                val lines = sequence.trim().split("\n")
                val scientificName = lines[0].trim()
                val arnSequence = lines.subList(1, lines.size).joinToString("").trim()
                organisms.add(Organism(scientificName, arnSequence))
            }
        }
        return organisms
    }
}
fun taxonSearch(requete: String?) = runBlocking {
    val taxonomy = Taxonomy()
    requete?.let {taxonomy.searchARN(it)}?.forEach { organism -> item = "Nom scientifique: ${organism.nomScientifique}\n----------------------------------------------------"}
    val message = "$requete :\n\n$item"
    crash(message)
}