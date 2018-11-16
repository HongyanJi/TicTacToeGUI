package edu.uiowa

// this is where you will begin the first version of your project
// but you will also need to connect this project with your github.uiowa.edu
// repository, as explained in the discussion section 9th November


//First version: 3x3 board, 2 players. First player hold "x" symbol.
interface Game{

    var board: Array<CharArray>
    var curSymbol: Char
    val isBoardFull : Boolean
    fun initBoard()
    fun placeSymbol(row: Int, col: Int): Boolean
    fun changeSymbol()
    fun Win(): Boolean
}

class TicTacToe : Game {

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

    // Return true if there is a win in Rows, Columns or Diagonals, false otherwise.
    override fun Win(): Boolean {
        return RowsWin() || ColumnsWin() || DiagonalsWin()
    }

    // Check win for Rows
    fun RowsWin(): Boolean {
        for (i in 0..2) {
            if (RowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true
            }
        }
        return false
    }

    // Check win for Columns.
    fun ColumnsWin(): Boolean {
        for (i in 0..2) {
            if (RowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true
            }
        }
        return false
    }

    // Check win for Diagonals.
    fun DiagonalsWin(): Boolean {
        return RowCol(board[0][0], board[1][1], board[2][2]) == true || RowCol(board[0][2], board[1][1], board[2][0]) == true
    }

    // if there inputs are the same, win.
    fun RowCol(c1: Char, c2: Char, c3: Char): Boolean {
        return c1 != '?' && c1 == c2 && c2 == c3
    }


    // Change player symbol back and forth.
    override fun changeSymbol() {
        if (curSymbol == 'x') {
            curSymbol = 'o'
        } else {
            curSymbol = 'x'
        }
    }

    // Places a mark at the cell specified by row and col with the symbol of the current player.
    override fun placeSymbol(row: Int, col: Int): Boolean {
        // bound in 3x3 board.
        if (row >= 0 && row < 3) {
            if (col >= 0 && col < 3) {
                if (board[row][col] == '?') {
                    board[row][col] = curSymbol
                    return true
                }
            }
        }
        return false
    }
}


