package linea;
import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class LineaTest {
    public static final String IT_S_NOT_YOUR_TURN_Error = "It's not your turn!";
    public static final String POSITION_OUT_OF_BOUNDS_ERROR = "Position out of bounds";
    public static final String COLUMN_IS_FULL_ERROR = "Column is full";
    Linea game4x4C;
    Linea game5x5C;
    Linea game6x9C;
    Linea game4x4B;
    Linea game4x4A;
    @BeforeEach
    //set up
    public void setUp() {
        game4x4C = new Linea(4, 4, 'C');
        game5x5C = new Linea(5, 5, 'C');
        game6x9C = new Linea(6, 9, 'C');
        game4x4B = new Linea(4, 4, 'B');
        game4x4A = new Linea(4, 4, 'A');


    }
    @Test
    public void test01GameIsNotFinishedWhenItStarts() {

        assertFalse(game4x4C.finished());
    }
    @Test
    public void test02PlayRedAt() {

        game4x4C.playRedAt(1);
        assertEquals(game4x4C.gameTable().get(0).get(0).toString(), new RedCell().toString());
    }
    @Test
    public void test03PlayBlueAt() {
        game4x4C.playRedAt(1);
        game4x4C.playBlueAt(1);
        assertEquals(game4x4C.gameTable().get(0).get(1).toString(), new BlueCell().toString());
    }
    @Test
    public void test04PlayerCantPlayIfItIsNotHisTurn() {

        game4x4A.playRedAt(1);
        assertThrowsLike(IT_S_NOT_YOUR_TURN_Error, () -> game4x4A.playRedAt(2));
    }
    @Test
    public void test05PlayerCantPlayIfPositionIsNotValid() {
        assertThrowsLike(POSITION_OUT_OF_BOUNDS_ERROR, () -> game4x4A.playRedAt(99));
    }
    @Test
    public void test06PlayerCantPlayIfColumnIsFull() {
        completeColumn(game4x4A);
        assertThrowsLike(COLUMN_IS_FULL_ERROR, () -> game4x4A.playRedAt(1));
    }

    @Test
    public void test07GameIsFinishedWhenSomeoneWins() {
        RedHorizontalWin(game6x9C);
        assertTrue(game6x9C.finished());
    }
    @Test
    public void test08GameIsFinishedWhenItIsTied() {
        completeGameTableWithOutWinning(game4x4A);
        assertTrue(game4x4A.finished());
    }
    @Test
    public void test09GameIsNotFinishedWhenItIsNotTiedAndNobodyWins() {
        game4x4A.playRedAt(1);
        game4x4A.playBlueAt(2);
        assertFalse(game4x4A.finished());
    }
    @Test
    public void test10GameModeAAllowsVerticalWin() {
        verticalRedWin(game4x4A);
        assertTrue(game4x4A.finished());
    }


    @Test
    public void test11GameModeAAllowsHorizontalWin() {
        RedHorizontalWin(game4x4A);
        assertTrue(game4x4A.finished());
    }
    @Test
    public void test12GameModeADoesntAllowDiagonalWin() {
        redDiagonalWin(game4x4A);
        assertFalse(game4x4A.finished());
    }
    @Test
    public void test13GameModeBAllowsDiagonalWin() {
        redDiagonalWin(game4x4B);
        assertTrue(game4x4B.finished());
    }
    @Test
    public void test14GameModeBDoesntAllowVerticalWin() {
        verticalRedWin(game4x4B);
        assertFalse(game4x4B.finished());
    }
    @Test
    public void test15GameModeBDoesntAllowHorizontalWin() {
        RedHorizontalWin(game4x4B);
        assertFalse(game4x4B.finished());
    }
    @Test
    public void test16GameModeCAllowsVerticalWin() {
        verticalRedWin(game4x4C);
        assertTrue(game4x4C.finished());
    }
    @Test
    public void test17GameModeCAllowsHorizontalWin() {

        RedHorizontalWin(game4x4C);
        assertTrue(game4x4C.finished());
    }
    @Test
    public void test18GameModeCAllowsDiagonalWin() {
        redDiagonalWin(game4x4C);
        assertTrue(game4x4C.finished());
    }

    @Test
    public void test19ItIsAllowToCreateDifferentSizesOfGameTables(){
        //base
        assertEquals(4, game4x4C.gameTable().size());
        assertEquals(5, game5x5C.gameTable().size());
        assertEquals(6, game6x9C.gameTable().size());
        //height
        assertEquals(4, game4x4C.gameTable().get(0).size());
        assertEquals(5, game5x5C.gameTable().get(0).size());
        assertEquals(9, game6x9C.gameTable().get(0).size());
    }




    private void completeGameTableWithOutWinning(Linea game) {
        for (int i = 0; i < game.gameTable().size(); i++) {
            for (int j = 0; j < game.gameTable().get(0).size()-3; j++) {
                    game.playRedAt(i + 1);
                    game.playBlueAt(i + 1);
                }
            }
        }

    private void completeColumn(Linea game) {
        for (int i = 0; i < game.gameTable().get(0).size(); i++) {
            if (i % 2 == 0) {
                game.playRedAt(1);
            } else {
                game.playBlueAt(1);
            }
        }

    }
    private void verticalRedWin(Linea game) {
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(1);
    }
    private void RedHorizontalWin(Linea game) {
        game.gameTable().forEach(column -> {
            game.playRedAt(game.gameTable().indexOf(column) + 1);
            game.playBlueAt(game.gameTable().indexOf(column) + 1);
        });
    }
    private void redDiagonalWin(Linea game) {
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(4);
        game.playRedAt(4);
        game.playBlueAt(1);
        game.playRedAt(4);

    }





    private void assertThrowsLike(String message, ThrowingRunnable e) {
        assertEquals(message, Assert.assertThrows(RuntimeException.class, e).getMessage());
    }

}
