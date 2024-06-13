package io.zamo;

import java.util.*;
import java.util.stream.Collectors;

public class SudokuQuadrantChecker {

    public String check(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Sudoku board should be not null");
        }

        String[] data = input.split(",");

        int boardSize = (int) Math.sqrt(data.length);

        if (boardSize * boardSize != data.length) {
            throw new IllegalArgumentException("Sudoku board size should be NxN (where N is a perfect square).");
        }

        SudokuBoard sudokuBoard = new SudokuBoard(data, boardSize);

        return validateSudokuBoard(sudokuBoard).orElse(input);
    }

    private Optional<String> validateSudokuBoard(SudokuBoard sudokuBoard) {
        Set<String> quadrantInvalid = new HashSet<>();

        Map<Integer, List<Square>> squaresGroupByRowNumber = new HashMap<>();
        Map<Integer, List<Square>> squaresGroupByColumnNumber = new HashMap<>();
        Map<Integer, List<Square>> squaresGroupByQuadrantNumber = new HashMap<>();

        for (List<Square> squares : sudokuBoard.getSquaresGroupByValue().values()) {

            squares.forEach(square -> {
                addSquareToGroup(squaresGroupByRowNumber, square.row(), square);
                addSquareToGroup(squaresGroupByColumnNumber, square.column(), square);
                addSquareToGroup(squaresGroupByQuadrantNumber, square.quadrant(), square);
            });

            quadrantInvalid.addAll(checkRepeatValue(squaresGroupByRowNumber.values()));
            quadrantInvalid.addAll(checkRepeatValue(squaresGroupByColumnNumber.values()));
            quadrantInvalid.addAll(checkRepeatValue(squaresGroupByQuadrantNumber.values()));

            squaresGroupByRowNumber.clear();
            squaresGroupByColumnNumber.clear();
            squaresGroupByQuadrantNumber.clear();
        }

        return quadrantInvalid.isEmpty() ? Optional.empty() : Optional.of(String.join(",", quadrantInvalid.stream().sorted().toArray(String[]::new)));
    }

    private <K> void addSquareToGroup(Map<K, List<Square>> map, K key, Square square) {
        List<Square> squareList = map.computeIfAbsent(key, k -> new ArrayList<>());
        squareList.add(square);
    }

    private Set<String> checkRepeatValue(Collection<List<Square>> squares) {
        return squares.stream().filter(list -> list.size() > 1).flatMap(List::stream)
                .map(Square::quadrant)
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }
}
