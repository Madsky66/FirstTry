import javafx.scene.text.Text
import kotlinx.serialization.json.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

private lateinit var assistantMessage: String
private var flagged = false

fun chat(chatController: ChatController) {
    flagged = APIManager().postModeration()
    if (!flagged) {
        assistantMessage = APIManager().postCompletion()
        chatController.chatAnswerArea.children.add(Text(assistantMessage))
        println("Assistant: $assistantMessage")
    }
    else {chatAnswer = "Vous ne respectez pas les conditions d'utilisation d'OpenAI. Veuillez réessayer."}
}
class APIManager {
    fun postModeration(): Boolean {
        val content = requestAPI("https://api.openai.com/v1/moderations", "{\"input\":\"$input\"}")
        val moderationJson = Json.parseToJsonElement(content) as JsonObject
        return moderationJson["results"]!!.jsonArray[0].jsonObject["flagged"]!!.jsonPrimitive.boolean
    }
    fun postCompletion(): String {
        val content = requestAPI("https://api.openai.com/v1/completions", "{\"model\":\"text-davinci-003\", \"prompt\":\"$input\", \"max_tokens\": 150}")
        val completionJson = Json.parseToJsonElement(content) as JsonObject
        return completionJson["choices"]!!.jsonArray[0].jsonObject["text"]!!.jsonPrimitive.content
    }
    private fun requestAPI(url: String, data: String): String {
        val http = (URL(url).openConnection() as HttpURLConnection).apply {
            requestMethod = "POST"
            doOutput = true
            setRequestProperty("Content-Type", "application/json")
            setRequestProperty("Authorization", "Bearer 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")
            outputStream.write(data.toByteArray(StandardCharsets.UTF_8))
        }
        val responseCode = http.responseCode
        return if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {http.inputStream.bufferedReader().use {it.readText()}}
        else {
            println("Failed to call API. Response status: $responseCode ${http.responseMessage}")
            http.disconnect()
            ""
        }
    }
}