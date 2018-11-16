package edu.uiowa

import org.junit.Test
import org.junit.Assert.*

class Project2820Test{
    @Test
    fun testForRowWin1(){
        var G = TicTacToe()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(2,1)
        G.changeSymbol()
        G.placeSymbol(0,1)
        G.changeSymbol()
        G.placeSymbol(2,2)
        G.changeSymbol()
        G.placeSymbol(0,2)
        assertEquals(true,G.Win())
    }

    @Test
    fun testForRowWin2(){
        var G = TicTacToe()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(2,1)
        G.changeSymbol()
        G.placeSymbol(0,1)
        G.changeSymbol()
        G.placeSymbol(0,2)
        G.changeSymbol()
        G.placeSymbol(1,2)
        assertEquals(false,G.Win())
    }

    @Test
    fun testForColWin1(){
        var G = TicTacToe()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(2,1)
        G.changeSymbol()
        G.placeSymbol(1,0)
        G.changeSymbol()
        G.placeSymbol(2,2)
        G.changeSymbol()
        G.placeSymbol(2,0)
        assertEquals(true,G.Win())
    }

    @Test
    fun testForColWin2(){
        var G = TicTacToe()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(2,1)
        G.changeSymbol()
        G.placeSymbol(1,0)
        G.changeSymbol()
        G.placeSymbol(2,0)
        G.changeSymbol()
        G.placeSymbol(2,2)
        assertEquals(false,G.Win())
    }

    @Test
    fun testForDiagonalWin1(){
        var G = TicTacToe()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(2,1)
        G.changeSymbol()
        G.placeSymbol(1,1)
        G.changeSymbol()
        G.placeSymbol(2,0)
        G.changeSymbol()
        G.placeSymbol(2,2)
        assertEquals(true,G.Win())
    }

    @Test
    fun testForDiagonalWin2(){
        var G = TicTacToe()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(2,0)
        G.changeSymbol()
        G.placeSymbol(1,1)
        G.changeSymbol()
        G.placeSymbol(2,0)
        G.changeSymbol()
        G.placeSymbol(2,1)
        assertEquals(false,G.Win())
    }

    @Test
    fun testForDiagonalWin3(){
        var G = TicTacToe()
        G.placeSymbol(0, 2)
        G.changeSymbol()
        G.placeSymbol(2,1)
        G.changeSymbol()
        G.placeSymbol(1,1)
        G.changeSymbol()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(2,0)
        assertEquals(true,G.Win())
    }

    @Test
    fun testForDiagonalWin4(){
        var G = TicTacToe()
        G.placeSymbol(0, 2)
        G.changeSymbol()
        G.placeSymbol(1,1)
        G.changeSymbol()
        G.placeSymbol(2,1)
        G.changeSymbol()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(2,0)
        assertEquals(false,G.Win())
    }
//hi
    @Test
    fun testForDraw1(){
        var G = TicTacToe()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(1,1)
        G.changeSymbol()
        G.placeSymbol(2,2)
        G.changeSymbol()
        G.placeSymbol(0, 1)
        G.changeSymbol()
        G.placeSymbol(2,0)
        G.changeSymbol()
        G.placeSymbol(1,2)
        G.changeSymbol()
        G.placeSymbol(0, 2)
        assertEquals(false,G.isBoardFull)
    }
    @Test
    fun testForDraw2(){
        var G = TicTacToe()
        G.placeSymbol(0, 0)
        G.changeSymbol()
        G.placeSymbol(1,1)
        G.changeSymbol()
        G.placeSymbol(2,2)
        G.changeSymbol()
        G.placeSymbol(0, 1)
        G.changeSymbol()
        G.placeSymbol(2,0)
        G.changeSymbol()
        G.placeSymbol(1,2)
        G.changeSymbol()
        G.placeSymbol(0, 2)
        G.changeSymbol()
        G.placeSymbol(1, 0)
        G.changeSymbol()
        G.placeSymbol(2, 1)
        assertEquals(true,G.isBoardFull)
    }




}
