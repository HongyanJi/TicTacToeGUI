package edu.uiowa
//Final Project with GUI: 3x3 board, 2 human players or 1 human player vs computer.
//"Engine" part

//TicTacToe has three interface parts, one is board, one is player, the other one is checking for win.
//create board
interface Board{
    var board: Array<CharArray>
    var curPlayer: Char
    val isBoardFull : Boolean
    fun initBoard()

}
//players hold "X" or "O" symbol.
interface Player{
    fun placeSymbol(row: Int, col: Int, boardObject: ThreeByThree): Boolean
    fun changePlayer(boardObject: ThreeByThree)
}

//Check for win if there are three same symbols in the same line: row, column or diagonals.
interface CheckForWin{
    fun Win(boardObject: ThreeByThree): Boolean
    fun RowsWin(boardObject: ThreeByThree): Boolean
    fun ColumnsWin(boardObject: ThreeByThree): Boolean
    fun DiagonalsWin(boardObject: ThreeByThree): Boolean
    fun RowCol(c1: Char, c2: Char, c3: Char): Boolean
}

//Create a 3x3 board with "?" values for each cells, and the first player holds "X".
class ThreeByThree : Board {

    override var board = arrayOf<CharArray>()
    override var curPlayer = ' '

    //Loop through all the cells in the board. if find "?" symbol, the board is not full, otherwise full.
    override val isBoardFull: Boolean
        get() {
            var isFull = true
            for (i in 0..2) {
                for (j in 0..2) {
                    if (board[i][j] == '?') {
                        isFull = false
                    }
                }
            }
            return isFull
        }
    //the first player holds "X".
    init {
        board = Array(3) { CharArray(3) }
        curPlayer = 'X'
        initBoard()
    }


    // Set/Reset the board back to empty with "?" symbol.
    override fun initBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                board[i][j] = '?'
            }
        }
    }
}
//Two players, One holds "X" and the other one holds "O". if there is "?", player can place symbol.
class TwoPlayers : Player {

    // Change player symbol back and forth.
    override fun changePlayer(boardObject: ThreeByThree) {
        if (boardObject.curPlayer == 'X') {
            boardObject.curPlayer = 'O'
        } else {
            boardObject.curPlayer = 'X'
        }
    }

    // Places a symbol at the cell specified by row and col with the symbol of the current player.
    override fun placeSymbol(row: Int, col: Int,boardObject: ThreeByThree): Boolean {
        // bound in 3x3 board.
        if (row >= 0 && row < 3) {
            if (col >= 0 && col < 3) {
                if (boardObject.board[row][col] == '?') {
                    boardObject.board[row][col] = boardObject.curPlayer
                    return true
                }
            }
        }
        return false
    }
}

//if one player has three symbol in the same line, no matter row, column or diagonals, win.
class Check :CheckForWin {
    // Check the entire board, this calls the other check functions.
    // Return true if there is a win in Rows, Columns or Diagonals, false otherwise.
    override fun Win(boardObject: ThreeByThree): Boolean {
        return RowsWin(boardObject) || ColumnsWin(boardObject) || DiagonalsWin(boardObject)
    }

    // Check win by looping through Rows
    override fun RowsWin(boardObject: ThreeByThree): Boolean {
        for (i in 0..2) {
            if (RowCol(boardObject.board[i][0], boardObject.board[i][1], boardObject.board[i][2])) {
                return true
            }
        }
        return false
    }

    // Check win by looping through Columns.
    override fun ColumnsWin(boardObject: ThreeByThree): Boolean {
        for (i in 0..2) {
            if (RowCol(boardObject.board[0][i], boardObject.board[1][i], boardObject.board[2][i]) == true) {
                return true
            }
        }
        return false
    }

    // Check win by looping through Diagonals.
    override fun DiagonalsWin(boardObject: ThreeByThree): Boolean {
        return RowCol(boardObject.board[0][0], boardObject.board[1][1], boardObject.board[2][2]) == true || RowCol(boardObject.board[0][2], boardObject.board[1][1], boardObject.board[2][0]) == true
    }

    // if there inputs are the same and not "?" symbol, win.
    override fun RowCol(c1: Char, c2: Char, c3: Char): Boolean {
        return c1 != '?' && c1 == c2 && c2 == c3
    }

}

