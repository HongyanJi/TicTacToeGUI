package edu.uiowa

import org.junit.Test
import org.junit.Assert.*

class Project2820Test{

    @Test
    fun testForRowWin1(){
        val B = ThreeByThree()
        val P = TwoHumanPlayer()
        val W = Check()
        P.placeSymbol(0, 0, B)
        P.changeSymbol(B)
        P.placeSymbol(2,1, B)
        P.changeSymbol(B)
        P.placeSymbol(0,1, B)
        P.changeSymbol(B)
        P.placeSymbol(2,2, B)
        P.changeSymbol(B)
        P.placeSymbol(0,2, B)
        assertEquals(true,W.Win(B))
    }

    @Test
    fun testForRowWin2(){
        val B = ThreeByThree()
        val G = TwoHumanPlayer()
        val T = Check()
        G.placeSymbol(0, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,1, B)
        G.changeSymbol(B)
        G.placeSymbol(0,1, B)
        G.changeSymbol(B)
        G.placeSymbol(0,2, B)
        G.changeSymbol(B)
        G.placeSymbol(1,2, B)
        assertEquals(false,T.Win(B))
    }

    @Test
    fun testForColWin1(){
        val B = ThreeByThree()
        val G = TwoHumanPlayer()
        val T = Check()
        G.placeSymbol(0, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,1, B)
        G.changeSymbol(B)
        G.placeSymbol(1,0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,2, B)
        G.changeSymbol(B)
        G.placeSymbol(2,0, B)
        assertEquals(true,T.Win(B))
    }

    @Test
    fun testForColWin2(){
        val B = ThreeByThree()
        val G = TwoHumanPlayer()
        val T = Check()
        G.placeSymbol(0, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,1, B)
        G.changeSymbol(B)
        G.placeSymbol(1,0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,2, B)
        assertEquals(false,T.Win(B))
    }

    @Test
    fun testForDiagonalWin1(){
        val B = ThreeByThree()
        val G = TwoHumanPlayer()
        val T = Check()
        G.placeSymbol(0, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,1, B)
        G.changeSymbol(B)
        G.placeSymbol(1,1, B)
        G.changeSymbol(B)
        G.placeSymbol(2,0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,2, B)
        assertEquals(true,T.Win(B))
    }

    @Test
    fun testForDiagonalWin2(){
        val B = ThreeByThree()
        val G = TwoHumanPlayer()
        val T = Check()
        G.placeSymbol(0, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,0, B)
        G.changeSymbol(B)
        G.placeSymbol(1,1, B)
        G.changeSymbol(B)
        G.placeSymbol(2,0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,1, B)
        assertEquals(false,T.Win(B))
    }

    @Test
    fun testForDiagonalWin3(){
        val B = ThreeByThree()
        val G = TwoHumanPlayer()
        val T = Check()
        G.placeSymbol(0, 2, B)
        G.changeSymbol(B)
        G.placeSymbol(2,1, B)
        G.changeSymbol(B)
        G.placeSymbol(1,1, B)
        G.changeSymbol(B)
        G.placeSymbol(0, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,0, B)
        assertEquals(true,T.Win(B))
    }

    @Test
    fun testForDiagonalWin4(){
        val B = ThreeByThree()
        val G = TwoHumanPlayer()
        val T = Check()
        G.placeSymbol(0, 2, B)
        G.changeSymbol(B)
        G.placeSymbol(1,1, B)
        G.changeSymbol(B)
        G.placeSymbol(2,1, B)
        G.changeSymbol(B)
        G.placeSymbol(0, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(2,0, B)
        assertEquals(false,T.Win(B))
    }

    @Test
    fun testForDraw1(){
        val B = ThreeByThree()
        val G = TwoHumanPlayer()
        G.placeSymbol(0, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(1,1, B)
        G.changeSymbol(B)
        G.placeSymbol(2,2, B)
        G.changeSymbol(B)
        G.placeSymbol(0, 1, B)
        G.changeSymbol(B)
        G.placeSymbol(2,0, B)
        G.changeSymbol(B)
        G.placeSymbol(1,2, B)
        G.changeSymbol(B)
        G.placeSymbol(0, 2, B)
        assertEquals(false,B.isBoardFull)
    }
    @Test
    fun testForDraw2(){
        val B = ThreeByThree()
        val G = TwoHumanPlayer()
        G.placeSymbol(0, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(1,1, B)
        G.changeSymbol(B)
        G.placeSymbol(2,2, B)
        G.changeSymbol(B)
        G.placeSymbol(0, 1, B)
        G.changeSymbol(B)
        G.placeSymbol(2,0, B)
        G.changeSymbol(B)
        G.placeSymbol(1,2, B)
        G.changeSymbol(B)
        G.placeSymbol(0, 2, B)
        G.changeSymbol(B)
        G.placeSymbol(1, 0, B)
        G.changeSymbol(B)
        G.placeSymbol(2, 1, B)
        assertEquals(true,B.isBoardFull)
    }
}

