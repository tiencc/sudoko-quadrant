### Sudoku Quadrant

Have the function SudokuQuadrantChecker(strArr) read the strArr parameter being passed which will represent a NxN Sudoku board of integers ranging from 1 to N. N will be a perfect square (e.g. 1,4,9,16,…)

The rules of Sudoku are to place each of the N integers in every row and column and not have any integers repeat in the respective row, column, or Z by Z sub-grid (where Z is the square root of N).

The input strArr will represent a Sudoku board and it will be a comma separated list of values from 1 to N and the character x. The character x will represent an empty square.   The csv list will represent cells row by row from top-left to bottom-right._

Your program will determine if the board is legal; the board also does not necessarily have to be finished. If the board is legal, your program should return the string legal but if it isn't legal, it should return the ZxZ quadrants (separated by commas) where the errors exist. The ZxZ quadrants are numbered from 1 to N starting from top-left going to bottom-right.

**For example:**

for a 9x9 grid - if strArr is: “1,2,3,4,5,6,7,8,1,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,1,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x"
then your program should return 1,3,4 since the errors are in quadrants 1, 3 and 4 because of the repeating integer 1.

**Another example:**

for a 9x9 grid, if strArr is: "1,2,3,4,5,6,7,8,9,x,x,x,x,x,x,x,x,x,6,x,5,x,3,x,x,4,x,2,x,1,1,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,9"
then your program should return 3,4,5,9.