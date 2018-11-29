package edu.uiowa

import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage


//GUI part
//
class TempController {
    @FXML
    var regame: Button = Button()

    fun regame() {
        TicTacToe().start(Stage())
    }
}

class TicTacToeController {

    val B:ThreeByThree = ThreeByThree()
    val P:Player = TwoHumanPlayer()
    val W:CheckForWin = Check()

    @FXML
    var winner: Label = Label()
    @FXML
    var board00: Button = Button()
    @FXML
    var board01: Button = Button()
    @FXML
    var board02: Button = Button()
    @FXML
    var board10: Button = Button()
    @FXML
    var board11: Button = Button()
    @FXML
    var board12: Button = Button()
    @FXML
    var board20: Button = Button()
    @FXML
    var board21: Button = Button()
    @FXML
    var board22: Button = Button()

    @FXML
    fun changePlayerBoard00() {
        if (P.placeSymbol(0, 0, B)) {
            board00.text = "${B.curPlayer}"
            commButtonFeature()
        }
    }
    @FXML
    fun changePlayerBoard01() {
        if (P.placeSymbol(0, 1, B)) {
            board01.text = "${B.curPlayer}"
            commButtonFeature()
        }
    }
    @FXML
    fun changePlayerBoard02() {
        if (P.placeSymbol(0, 2, B)) {
            board02.text = "${B.curPlayer}"
            commButtonFeature()
        }
    }
    @FXML
    fun changePlayerBoard10() {
        if (P.placeSymbol(1, 0, B)) {
            board10.text = "${B.curPlayer}"
            commButtonFeature()
        }
    }
    @FXML
    fun changePlayerBoard11() {
        if (P.placeSymbol(1, 1, B)) {
            board11.text = "${B.curPlayer}"
            commButtonFeature()
        }
    }
    @FXML
    fun changePlayerBoard12() {
        if (P.placeSymbol(1, 2, B)) {
            board12.text = "${B.curPlayer}"
            commButtonFeature()
        }
    }
    @FXML
    fun changePlayerBoard20() {
        if (P.placeSymbol(2, 0, B)) {
            board20.text = "${B.curPlayer}"
            commButtonFeature()
        }
    }
    @FXML
    fun changePlayerBoard21() {
        if (P.placeSymbol(2, 1, B)) {
            board21.text = "${B.curPlayer}"
            commButtonFeature()
        }

    }
    @FXML
    fun changePlayerBoard22() {
        if (P.placeSymbol(2, 2, B)) {
            board22.text = "${B.curPlayer}"
            commButtonFeature()

        }
    }

    fun commButtonFeature() {
        winner.text = "Current Player is ${B.curPlayer}"
        if (W.Win(B)) {  winner.text = "${B.curPlayer} won the game"; Temp().start(Stage()) }
        else if (B.isBoardFull) { winner.text = "The game is draw"; Temp().start(Stage()) }
        P.changePlayer(B)
    }
}

//winner.text = "Current Player is ${B.curPlayer}"
//board22.text = "${B.curPlayer}"
//if (W.Win(B)) {  winner.text = "${B.curPlayer} won the game"; Temp().start(Stage()) }
//else if (B.isBoardFull) { winner.text = "The game is draw"; Temp().start(Stage()) }
//P.changePlayer(B)

class TicTacToe: Application() {
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getClassLoader().getResource("Board.fxml"))
        primaryStage.title = "Tic Tac Toe (3x3)"
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }

}

class Temp: Application() {
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getClassLoader().getResource("Temp.fxml"))
        primaryStage.title = "TicTacToe"
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }
}


fun main(args: Array<String>) {
    Application.launch(TicTacToe::class.java)
}