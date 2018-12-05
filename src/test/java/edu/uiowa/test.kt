package edu.uiowa

import org.junit.Test
import org.junit.Assert.*

class Project2820Test{

    @Test
    fun testForRowWin1(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        val W = Check()
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(2,1, B)
        P.changePlayer(B)
        P.placeSymbol(0,1, B)
        P.changePlayer(B)
        P.placeSymbol(2,2, B)
        P.changePlayer(B)
        P.placeSymbol(0,2, B)
        assertEquals(true,W.Win(B))
    }

    @Test
    fun testForRowWin2(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        val W = Check()
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(2,1, B)
        P.changePlayer(B)
        P.placeSymbol(0,1, B)
        P.changePlayer(B)
        P.placeSymbol(0,2, B)
        P.changePlayer(B)
        P.placeSymbol(1,2, B)
        assertEquals(false,W.Win(B))
    }

    @Test
    fun testForColWin1(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        val W = Check()
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(2,1, B)
        P.changePlayer(B)
        P.placeSymbol(1,0, B)
        P.changePlayer(B)
        P.placeSymbol(2,2, B)
        P.changePlayer(B)
        P.placeSymbol(2,0, B)
        assertEquals(true,W.Win(B))
    }

    @Test
    fun testForColWin2(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        val W = Check()
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(2,1, B)
        P.changePlayer(B)
        P.placeSymbol(1,0, B)
        P.changePlayer(B)
        P.placeSymbol(2,0, B)
        P.changePlayer(B)
        P.placeSymbol(2,2, B)
        assertEquals(false,W.Win(B))
    }

    @Test
    fun testForDiagonalWin1(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        val W = Check()
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(2,1, B)
        P.changePlayer(B)
        P.placeSymbol(1,1, B)
        P.changePlayer(B)
        P.placeSymbol(2,0, B)
        P.changePlayer(B)
        P.placeSymbol(2,2, B)
        assertEquals(true,W.Win(B))
    }

    @Test
    fun testForDiagonalWin2(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        val W = Check()
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(2,0, B)
        P.changePlayer(B)
        P.placeSymbol(1,1, B)
        P.changePlayer(B)
        P.placeSymbol(2,0, B)
        P.changePlayer(B)
        P.placeSymbol(2,1, B)
        assertEquals(false,W.Win(B))
    }

    @Test
    fun testForDiagonalWin3(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        val W = Check()
        P.placeSymbol(0, 2, B)
        P.changePlayer(B)
        P.placeSymbol(2,1, B)
        P.changePlayer(B)
        P.placeSymbol(1,1, B)
        P.changePlayer(B)
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(2,0, B)
        assertEquals(true,W.Win(B))
    }

    @Test
    fun testForDiagonalWin4(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        val W = Check()
        P.placeSymbol(0, 2, B)
        P.changePlayer(B)
        P.placeSymbol(1,1, B)
        P.changePlayer(B)
        P.placeSymbol(2,1, B)
        P.changePlayer(B)
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(2,0, B)
        assertEquals(false,W.Win(B))
    }

    @Test
    fun testForDraw1(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(1,1, B)
        P.changePlayer(B)
        P.placeSymbol(2,2, B)
        P.changePlayer(B)
        P.placeSymbol(0, 1, B)
        P.changePlayer(B)
        P.placeSymbol(2,0, B)
        P.changePlayer(B)
        P.placeSymbol(1,2, B)
        P.changePlayer(B)
        P.placeSymbol(0, 2, B)
        assertEquals(false,B.isBoardFull)
    }
    @Test
    fun testForDraw2(){
        val B = ThreeByThree()
        val P = TwoPlayers()
        P.placeSymbol(0, 0, B)
        P.changePlayer(B)
        P.placeSymbol(1,1, B)
        P.changePlayer(B)
        P.placeSymbol(2,2, B)
        P.changePlayer(B)
        P.placeSymbol(0, 1, B)
        P.changePlayer(B)
        P.placeSymbol(2,0, B)
        P.changePlayer(B)
        P.placeSymbol(1,2, B)
        P.changePlayer(B)
        P.placeSymbol(0, 2, B)
        P.changePlayer(B)
        P.placeSymbol(1, 0, B)
        P.changePlayer(B)
        P.placeSymbol(2, 1, B)
        assertEquals(true,B.isBoardFull)
    }
}

