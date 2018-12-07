package edu.uiowa

import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Stage
import java.util.*


//GUI part for one person vs a computer
//
class TicTacToeVsComputerController {

    var bool = true
    val B:ThreeByThree = ThreeByThree()
    val P = TwoPlayers()
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

    //computer places symbol by random.
    fun computerMove() {
        while (true) {
            if (bool == false) break
            val x = Random().nextInt(3)
            val y = Random().nextInt(3)

            if (x == 0 && y == 0 && P.placeSymbol(0, 0, B)) {
                board00.text = "${B.curPlayer}"
                commButtonAction()
                break
            } else if (x == 0 && y == 1 && P.placeSymbol(0, 1, B)) {
                board01.text = "${B.curPlayer}"
                commButtonAction()
                break
            } else if (x == 0 && y == 2 && P.placeSymbol(0, 2, B)) {
                board02.text = "${B.curPlayer}"
                commButtonAction()
                break
            } else if (x == 1 && y == 0 && P.placeSymbol(1, 0, B)) {
                board10.text = "${B.curPlayer}"
                commButtonAction()
                break
            } else if (x == 1 && y == 1 && P.placeSymbol(1, 1, B)) {
                board11.text = "${B.curPlayer}"
                commButtonAction()
                break
            } else if (x == 1 && y == 2 && P.placeSymbol(1, 2, B)) {
                board12.text = "${B.curPlayer}"
                commButtonAction()
                break
            } else if (x == 2 && y == 0 && P.placeSymbol(2, 0, B)) {
                board20.text = "${B.curPlayer}"
                commButtonAction()
                break
            } else if (x == 2 && y == 1 && P.placeSymbol(2, 1, B)) {
                board21.text = "${B.curPlayer}"
                commButtonAction()
                break
            } else if (x == 2 && y == 2 && P.placeSymbol(2, 2, B)) {
                board22.text = "${B.curPlayer}"
                commButtonAction()
                break
            }
        }
    }

    // a person vs computer version, the human goes first, then computer places randomly.
    @FXML
    fun changePlayerBoard00() {
        if (P.placeSymbol(0, 0, B)) {
            board00.text = "${B.curPlayer}"
//            TimeUnit.SECONDS.sleep(2)
            commButtonAction()
            computerMove()
        }
    }
    @FXML
    fun changePlayerBoard01() {
        if (P.placeSymbol(0, 1, B)) {
            board01.text = "${B.curPlayer}"
            commButtonAction()
            computerMove()
        }
    }
    @FXML
    fun changePlayerBoard02() {
        if (P.placeSymbol(0, 2, B)) {
            board02.text = "${B.curPlayer}"
            commButtonAction()
            computerMove()
        }
    }
    @FXML
    fun changePlayerBoard10() {
        if (P.placeSymbol(1, 0, B)) {
            board10.text = "${B.curPlayer}"
            commButtonAction()
            computerMove()
        }
    }
    @FXML
    fun changePlayerBoard11() {
        if (P.placeSymbol(1, 1, B)) {
            board11.text = "${B.curPlayer}"
            commButtonAction()
            computerMove()
        }
    }
    @FXML
    fun changePlayerBoard12() {
        if (P.placeSymbol(1, 2, B)) {
            board12.text = "${B.curPlayer}"
            commButtonAction()
            computerMove()
        }
    }
    @FXML
    fun changePlayerBoard20() {
        if (P.placeSymbol(2, 0, B)) {
            board20.text = "${B.curPlayer}"
            commButtonAction()
            computerMove()
        }
    }
    @FXML
    fun changePlayerBoard21() {
        if (P.placeSymbol(2, 1, B)) {
            board21.text = "${B.curPlayer}"
            commButtonAction()
            computerMove()
        }

    }
    @FXML
    fun changePlayerBoard22() {
        if (P.placeSymbol(2, 2, B)) {
            board22.text = "${B.curPlayer}"
            commButtonAction()
            computerMove()
        }
    }

    //each button shows the current player with "X" or "O", check for win or draw.
    fun commButtonAction() {
        curPlayer.text = "Current Player is ${B.curPlayer}"
        if (W.Win(B)) {
            winnerForThisGame = "${B.curPlayer} is the winner!"
            bool = false
            InitBoard().start(Stage())
            (curPlayer.scene.window as Stage).close()
        } else if (B.isBoardFull) {
            winnerForThisGame = "The game is draw!"
            bool = false
            InitBoard().start(Stage())
            (curPlayer.scene.window as Stage).close()
        }
        P.changePlayer(B)
    }
}

//load an FXML file, "BoardComputer.fxml". Show the board.
class TicTacToeVsComputer: Application() {
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(
                javaClass.getClassLoader()
                        .getResource("BoardComputer.fxml"))
        primaryStage.title = "Tic Tac Toe (3x3)"
        primaryStage.scene = Scene(root)
        primaryStage.show()
    }

}
