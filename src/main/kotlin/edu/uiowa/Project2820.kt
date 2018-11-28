package edu.uiowa


// this is where you will begin the first version of your project
// but you will also need to connect this project with your github.uiowa.edu
// repository, as explained in the discussion section 9th November

//
//Second version with GUI: 3x3 board, 2 human players. First player hold "x" symbol.
//"Engine" part
interface Board{
    var board: Array<CharArray>
    var curSymbol: Char
    val isBoardFull : Boolean
    fun initBoard()

}

interface Player{
    fun placeSymbol(row: Int, col: Int, boardObject: ThreeByThree): Boolean
    fun changeSymbol(boardObject: ThreeByThree)
}

interface CheckForWin{
    fun Win(boardObject: ThreeByThree): Boolean
    fun RowsWin(boardObject: ThreeByThree): Boolean
    fun ColumnsWin(boardObject: ThreeByThree): Boolean
    fun DiagonalsWin(boardObject: ThreeByThree): Boolean
    fun RowCol(c1: Char, c2: Char, c3: Char): Boolean
}

class ThreeByThree : Board {

    override var board = arrayOf<CharArray>()
    override var curSymbol = ' '

    // if find "?" return false, otherwise full.
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

    init {
        board = Array(3) { CharArray(3) }
        curSymbol = 'x'
        initBoard()
    }


    // Set/Reset the board back to empty.
    override fun initBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                board[i][j] = '?'
            }
        }
    }
}

class TwoHumanPlayer : Player {

    // Change player symbol back and forth.
    override fun changeSymbol(boardObject: ThreeByThree) {
        if (boardObject.curSymbol == 'x') {
            boardObject.curSymbol = 'o'
        } else {
            boardObject.curSymbol = 'x'
        }
    }

    // Places a mark at the cell specified by row and col with the symbol of the current player.
    override fun placeSymbol(row: Int, col: Int,boardObject: ThreeByThree): Boolean {
        // bound in 3x3 board.
        if (row >= 0 && row < 3) {
            if (col >= 0 && col < 3) {
                if (boardObject.board[row][col] == '?') {
                    boardObject.board[row][col] = boardObject.curSymbol
                    return true
                }
            }
        }
        return false
    }
}

class Check :CheckForWin {
    //var board = arrayOf<CharArray>()
    // Return true if there is a win in Rows, Columns or Diagonals, false otherwise.
    override fun Win(boardObject: ThreeByThree): Boolean {
        return RowsWin(boardObject) || ColumnsWin(boardObject) || DiagonalsWin(boardObject)
    }

    // Check win for Rows
    override fun RowsWin(boardObject: ThreeByThree): Boolean {
        for (i in 0..2) {
            if (RowCol(boardObject.board[i][0], boardObject.board[i][1], boardObject.board[i][2])) {
                return true
            }
        }
        return false
    }

    // Check win for Columns.
    override fun ColumnsWin(boardObject: ThreeByThree): Boolean {
        for (i in 0..2) {
            if (RowCol(boardObject.board[0][i], boardObject.board[1][i], boardObject.board[2][i]) == true) {
                return true
            }
        }
        return false
    }

    // Check win for Diagonals.
    override fun DiagonalsWin(boardObject: ThreeByThree): Boolean {
        return RowCol(boardObject.board[0][0], boardObject.board[1][1], boardObject.board[2][2]) == true || RowCol(boardObject.board[0][2], boardObject.board[1][1], boardObject.board[2][0]) == true
    }

    // if there inputs are the same, win.
    override fun RowCol(c1: Char, c2: Char, c3: Char): Boolean {
        return c1 != '?' && c1 == c2 && c2 == c3
    }

}

//GUI part
//test
