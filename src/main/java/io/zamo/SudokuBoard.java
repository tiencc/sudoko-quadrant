package io.zamo;

import java.util.*;

public class SudokuBoard {
    private final int boardSize;
    private final Map<String, List<Square>> squaresGroupByValue;
    private static final String EMPTY_SQUARE_SYMBOL = "x";

    public SudokuBoard(String[] data, int boardSize) {
        this.boardSize = boardSize;
        this.squaresGroupByValue = new HashMap<>();
        initializeBoard(data);
    }

    private void initializeBoard(String[] data) {
        for (int row = 1; row <= boardSize; row++) {
            for (int column = 1; column <= boardSize; column++) {

                int quadrantSize = (int) Math.sqrt(boardSize);

                int quadrant = calculateQuadrant(row, column, quadrantSize);

                String value = data[(row - 1) * boardSize + column - 1];

                Square square = new Square(row, column, quadrant, value);

                if (!Objects.equals(value, EMPTY_SQUARE_SYMBOL)) {
                    List<Square> squareList = squaresGroupByValue.computeIfAbsent(value, k -> new ArrayList<>());
                    squareList.add(square);
                }
            }
        }
    }

    private int calculateQuadrant(int row, int column, int quadrantSize) {
        return (int) ((double) ((row - 1) / quadrantSize) * quadrantSize + (double) ((column - 1) / quadrantSize) + 1);
    }

    public Map<String, List<Square>> getSquaresGroupByValue() {
        return Collections.unmodifiableMap(squaresGroupByValue);
    }
}
