import tornadofx.*

class MainMenu : App(MainMenuView::class)

fun main(args: Array<String>) {
    launch<MainMenu>(args)
}
