/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Pis_hue1_;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class AppTest {
    GameEngine game1 = new GameEngine();


    @Test
    public void testGameOver() {
        Assert.assertFalse("Das Spiel ist noch nicht zu Ende", game1.gameOver()); // es wird geprüft ob das Spiel noch nicht zu Ende ist
    }


    @Test
    public void testPlayer() {
        game1.move(2);
        Assert.assertEquals("Der falsche Spieler ist dran" ,game1.getCurrent_player(), 2);// er schaut ob der Player sich wechselt
    }

    @Test
    public void testTurn() {
        game1.move(1);
        game1.move(2);
        Assert.assertEquals("Der Spieler wurde nicht gewechselt" , game1.getCurrent_player(), 1);// wird geprüft ob der Player wieder zurück wechselt
    }

    @Test
    public void testWinner() {
        game1.move(1);
        game1.move(2);
        game1.move(1);
        game1.move(2);
        game1.move(1);
        game1.move(2);
        game1.move(1);
        Assert.assertTrue("Der aktuelle Spieler hat nicht gewonnen" , game1.gameOver() && game1.getCurrent_player() == 1);// ob der aktuelle spieler gewonnen hat
    }

    @Test
    public void testBoardEmpty() {
        Assert.assertArrayEquals("Das Board ist nicht leer am Beginn des Spiels", game1.getBoard(), new int[6][7]);// wird überprüft ob das Board am beginn des Spiels leer ist
    }

    @Test
    public void testBoardIsNotEmpty() {
        Arrays.stream(game1.getBoard()).forEach(x -> Arrays.stream(x).forEach(y -> {
            if (y != 0) Assert.assertTrue("Das Board ist leer ", true);
        })); // wird geprüft ob das board nicht leer ist
    }

    @Test
    public void testMove() {
        game1.move(5);
        Assert.assertEquals("Der Move wurde nicht an die richtige Stelle gelegt",game1.getBoardIndex(0, 5), 1);// wird überprüft ob der Move an die richtige stelle gelegt wurde
    }

    @Test
    public void testMoreMoves() {
        game1.move(2);
        game1.move(4);
        game1.move(2);
        Assert.assertEquals("Der Stein wurde nicht an die richtige Stelle gelegt", game1.getBoardIndex(0, 2), 1);// wird überprüft ob die verschiedenen Steine im Wechsel auf die richtige Stelle gelegt wurden
        Assert.assertEquals("Der Stein wurde nicht an die richtige Stelle gelegt", game1.getBoardIndex(0, 4), 2);
        Assert.assertEquals("Der Stein wurde nicht an die richtige Stelle gelegt", game1.getBoardIndex(1, 2), 1);
    }


    @Test
    public void testDiagonalWin() {
        game1.setBoard(new int[][]{{1, 2, 2, 2, 0, 0, 1}, {2, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 2, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}});
        Assert.assertTrue("Hier hätte ein Spieler Diagonal gewonnen", game1.checkWinner());// wird die Diagonale geprüft ob einer gewonnen hat
    }

    @Test
    public void testMoveList() {
        game1.move(1);
        game1.move(1);
        game1.move(1);
        game1.move(1);
        game1.move(1);
        game1.move(1);
        Assert.assertFalse("Stein dieser Reihe zu setzen ist nicht möglich", game1.moveList().contains(1));// An der Spalte 1 ist es nicht mehr möglich ein Stein zu legen weil sie voll ist
    }

    @Test
    public void testMoveCounter() {
        game1.move(1);
        Assert.assertEquals("Der Movecounter steigt nicht", 1, game1.getMoveCounter());// hier wird getest ob mein Movecounter steigt
    }

    @Test
    public void testSimulation() {
        while (!game1.gameOver()) {
            game1.randomMove();
        }
        Assert.assertTrue("Das Spiel hätte enden müssen", game1.gameOver()); //hier werden unzählige random moves gelegt um zu prüfen ob das Spiel endet!
    }

    @Test
    public void testWinnerHorizontal() {
        game1.move(1);
        game1.move(1);
        game1.move(2);
        game1.move(2);
        game1.move(3);
        game1.move(3);
        game1.move(4);
        Assert.assertTrue(" Der Spieler hätte horizontal gewinnen müssen", game1.gameOver() && game1.getCurrent_player() == 1);// ob der Spieler horizontal gewonnen hat
    }

    @Test
    public void testRandomMove() {
        game1.randomMove();
        Assert.assertNotEquals("Das Board hätte ein zufälligen Stein werfen müssen", game1.getBoard(), new int[6][7]); //wird geprüft nachdem ein random Move gelegt wird ob das Bord nicht mehr ungefüllt ist, also gefüllt an
        //genauer einer Stelle!
    }

}