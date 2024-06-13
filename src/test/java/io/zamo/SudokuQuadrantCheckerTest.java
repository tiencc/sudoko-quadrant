package io.zamo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SudokuQuadrantCheckerTest {

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenInputIsNull() {
        SudokuQuadrantChecker quant = new SudokuQuadrantChecker();

        Assertions.assertThrows(IllegalArgumentException.class, () -> quant.check(null));
    }


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenBoardSizeIsNotPerfectSquare() {
        SudokuQuadrantChecker quant = new SudokuQuadrantChecker();
        String input = "1,2,3,4,x,x,x,x";

        Assertions.assertThrows(IllegalArgumentException.class, () -> quant.check(input));
    }

    @Test
    public void shouldNotThrowIllegalArgumentExceptionWhenInputIsPerfectSquare() {
        SudokuQuadrantChecker quant = new SudokuQuadrantChecker();
        String input = "1,2,3,4,x,x,x,x,x";

        Assertions.assertDoesNotThrow(() -> quant.check(input));
    }


    @Test
    public void shouldReturnQuadrantNumber_ONE_THREE_FOUR() {
        SudokuQuadrantChecker quant = new SudokuQuadrantChecker();
        String input = "1,2,3,4,5,6,7,8,1,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,1,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x";

        String output = quant.check(input);
        System.out.println(output);
        Assertions.assertEquals("1,3,4", output);
    }

    @Test
    public void shouldReturnQuadrantNumber_THREE_FOUR_FIVE_NINE() {
        SudokuQuadrantChecker quant = new SudokuQuadrantChecker();
        String input = "1,2,3,4,5,6,7,8,9,x,x,x,x,x,x,x,x,x,6,x,5,x,3,x,x,4,x,2,x,1,1,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,9";

        String output = quant.check(input);
        System.out.println(output);
        Assertions.assertEquals("3,4,5,9", output);
    }

    @Test
    public void shouldReturnLegalString() {
        SudokuQuadrantChecker quant = new SudokuQuadrantChecker();
        String input = "1,2,3,4,5,6,7,8,9,x,x,x,x,x,x,x,x,x,6,x,5,x,3,x,x,4,x,2,x,1,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x";

        String output = quant.check(input);
        System.out.println(output);
        Assertions.assertEquals(input, output);
    }
}
