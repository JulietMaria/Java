//https://leetcode.com/problems/valid-sudoku/
public boolean isValidSudoku(char[][] board) {
    // Step 1: Create a HashSet to track seen numbers and their positions
    Set seen = new HashSet();

    // Step 2: Traverse the entire 9x9 Sudoku board
    for (int i = 0; i < 9; ++i) { // Loop through rows (0 to 8)
        for (int j = 0; j < 9; ++j) { // Loop through columns (0 to 8)
            
            char number = board[i][j]; // Get the current cell value
            
            // Step 3: Skip cells with '.' since they represent empty cells
            if (number != '.') {
                // Step 4: Check if the current number is already seen in the current row, column, or 3x3 block
                if (!seen.add(number + " in row " + i) || // Check row uniqueness
                    !seen.add(number + " in column " + j) || // Check column uniqueness
                    !seen.add(number + " in block " + i / 3 + "-" + j / 3)) { // Check 3x3 block uniqueness
                    
                    // If any condition fails, the board is invalid
                    return false;
                }
            }
        }
    }
    // Step 5: If no conflicts were found, the board is valid
    return true;
}
//Time Complexity: O(n ^2) (due to 𝑛^2 cells being processed).
//Space Complexity: O(n ^2) (due to tracking constraints for all cells).
