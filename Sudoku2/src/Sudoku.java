public class Sudoku {

	private int[][] board;

	
	public Sudoku(){
		board = new int[9][9];
	
	}
	
	/**
	 * Control if a is of the type Integer. if yes,control if the number is between 1 and 9.
	 * If yes, add a at position i,j in the sudoku.
	 * @throws IllegalArgumentException if it was not possible to add a.
	 * @param a object that is controlled to be number and than are added to the sudoku.
	 */
	public void insertNumber(Object a, int i, int j) {

		if(a instanceof Integer){
			int number= ((Integer) a).intValue();
			if(number>=1 && number<=9 && i>=0 && i<=8 && j>=0 && j<=8){
				board[i][j]=number;
				
			}else{
				throw new IllegalArgumentException("You need to insert a number between 1-9");
			}
			
			
		}else{
			throw new IllegalArgumentException("You need to insert a number.");
			
			
		}
	}
	/**
	 * Returns the number at position i,j in board.
	 * @param i the row in board.
	 * @param j the column in board.
	 * @return the number on place i,j in board.
	 */
	public int getNumber(int i, int j) {
		return board[i][j];
	}

	/**
	 * Makes the board empty.
	 */
	public void clear() {
		board = new int[9][9];

	}

	/**
	 * Controls if the sudoku is solveble by trying to find a solution 
	 * with the initial numbers in the board.
	 * @param i the row in board from where the solution shall start.
	 * @param j the column in board from where the solution shall start.
	 * @return true if the sudoku is solveble and false if not.
	 */
	public boolean solve(int i, int j) {
		return helpSolve(i,j);
	}

	private boolean helpSolve(int i, int j) {
		if(i == 8 && j == 8){
			return true;
		}else if (board[i][j] == 0) {
			for(int n=1;n<=9;n++){
				if(isAllowed(n,i,j)==true){
					board[i][j]=n;
					if(j < 8){
						if(helpSolve(i, j + 1)==true){
						return true;
					}
					}else if(i<8 && j==8){
						if(helpSolve(i + 1, 0)==true){
						return true;
						}
					}
				
				}
				
			}
			board[i][j]=0;
			return false;
						
		}else {
			if(isAllowed(board[i][j], i ,j)){
		
				if(i == 8 && j == 8){
				return true;
			}
				if(j < 8){
					if(helpSolve(i, j + 1)==true){
					return true;
				}
				}else if(i<8 && j==8){
					if(helpSolve(i + 1, 0)==true){
					return true;
					}
				}
			
		}
		}
		return false;
		
	}

	
	/**
	 * Controls if the number at position i,j is allowed according to rules of sudoku.
	 * @param number the number that is controlled.
	 * @param row the row in board where the number belongs to.
	 * @param col the comumn in board where the number belongs to.
	 * @return true if the number is allowed and false if not.
	 */
	private boolean isAllowed(int number, int row, int col){
		//Kontrollera värdet med raden
		for(int n=0;n<9;n++){
			if(board[row][n]==number && n!=col){
				return false;
			}
			
		}
		
		//kontrollera värdet med kollumnen
		for(int n=0;n<9;n++){
			if(board[n][col]==number && n!=row){
				return false;
			}
			
		}
		
		//Kontrollera värdet med 3x3 rutan
		int rutaRow=(row/3)*3;
		int rutaCol=(col/3)*3;
		for(int n=0; n<9; n++){
			for(int r=rutaRow;r<rutaRow + 3;r++){
				for(int c=rutaCol;c<rutaCol+3;c++){
					if(board[r][c]== number && r!=row && c!=col){
						return false;
					}
				}
				
				
			}
		}
		
		return true;
		
	}
}