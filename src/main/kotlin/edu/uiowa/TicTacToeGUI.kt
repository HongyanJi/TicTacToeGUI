package edu.uiowa

import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage


//GUI part for Two human or One person vs Computer.

var winnerForThisGame = ""
//Init Board has three choices for the player, one if "Two Human", play the game with two humans.
//one is "With computer", one person plays with the computer.
//one is "Close", just close the window, stop the game.
class InitBoardController {
    @FXML
    var winner: Label = Label()
    @FXML
    var regame: Button = Button()
    @FXML
    var close: Button = Button()
    @FXML
    var regameWithComputer = Button()


    @Override
    //made a label to show the winner.
    fun initialize() {
        winner.text = winnerForThisGame
    }
    //play with computer.
    fun WithComputer() {
        TicTacToeVsComputer().start(Stage())
        (winner.scene.window as Stage).close()
    }
    //play with two human.
    fun TwoHuman() {
        TicTacToe().start(Stage())
        (winner.scene.window as Stage).close()
    }
    //close the window and exit the window.
    fun close() {
        (winner.scene.window as Stage).close()
    }

}
//the same action the buttons have. no matter is two human or one person plays with computer.
//Each button holds the current player information, check for win or draw by calling the functions in the engine part.
//Check if the board is full by calling the function in the engine part.
class TicTacToeController {

    val B:ThreeByThree = ThreeByThree()
    val P:Player = TwoPlayers()
    val W:CheckForWin = Check()

    @FXML
    var curPlayer: Label = Label()
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

    //each button holds the information of the current player and the same features as the common function shows.
    @FXML
    fun changePlayerBoard00() {
        if (P.placeSymbol(0, 0, B)) {
            board00.text = "${B.curPlayer}"
            commButtonAction()
        }
    }
    @FXML
    fun changePlayerBoard01() {
        if (P.placeSymbol(0, 1, B)) {
            board01.text = "${B.curPlayer}"
            commButtonAction()
        }
    }
    @FXML
    fun changePlayerBoard02() {
        if (P.placeSymbol(0, 2, B)) {
            board02.text = "${B.curPlayer}"
            commButtonAction()
        }
    }
    @FXML
    fun changePlayerBoard10() {
        if (P.placeSymbol(1, 0, B)) {
            board10.text = "${B.curPlayer}"
            commButtonAction()
        }
    }
    @FXML
    fun changePlayerBoard11() {
        if (P.placeSymbol(1, 1, B)) {
            board11.text = "${B.curPlayer}"
            commButtonAction()
        }
    }
    @FXML
    fun changePlayerBoard12() {
        if (P.placeSymbol(1, 2, B)) {
            board12.text = "${B.curPlayer}"
            commButtonAction()
        }
    }
    @FXML
    fun changePlayerBoard20() {
        if (P.placeSymbol(2, 0, B)) {
            board20.text = "${B.curPlayer}"
            commButtonAction()
        }
    }
    @FXML
    fun changePlayerBoard21() {
        if (P.placeSymbol(2, 1, B)) {
            board21.text = "${B.curPlayer}"
            commButtonAction()
        }

    }
    @FXML
    fun changePlayerBoard22() {
        if (P.placeSymbol(2, 2, B)) {
            board22.text = "${B.curPlayer}"
            commButtonAction()
        }
    }

    // each button has the same features: holds the information for the current player, check for win or draw
    // by calling the functions in the engine part. Or initialize board if the board is full.
    fun commButtonAction() {
        curPlayer.text = "Current Player is ${B.curPlayer}"
        if (W.Win(B)) {
            winnerForThisGame = "${B.curPlayer} is the winner!"
            InitBoard().start(Stage())
            (curPlayer.scene.window as Stage).close()
        } else if (B.isBoardFull) {
            winnerForThisGame = "The game is draw!"
            InitBoard().start(Stage())
            (curPlayer.scene.window as Stage).close()
        }
        P.changePlayer(B)
    }
}

//load FXML file, "ThreeByThreeBoard.fxml", show the board.
class TicTacToe: Application() {
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(
                javaClass.getClassLoader()
                        .getResource("ThreeByThreeBoard.fxml"))
        primaryStage.title = "Tic Tac Toe (3x3)"
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }

}

//load FXML file, "InitBoard,fxml", show the board.
class InitBoard: Application() {
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(
                javaClass.getClassLoader()
                        .getResource("InitBoard.fxml"))
        primaryStage.title = "Tic Tac Toe (3x3)"
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }
}


fun main(args: Array<String>) {
    Application.launch(InitBoard::class.java)
}

