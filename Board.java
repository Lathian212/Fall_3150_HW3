
public class Board {
	public int pieces[][] = null;
	public int N;
	Board() {
		System.err.println("You called the default constructor for Board, this is an error");
	}
	Board(int N){
		// Creates a new board of size N
		this.N = N;
		pieces = new int[N][N];
	}
	Board(Board solution) {
		// Creates a copy of a board containing a solution.
		this.N = solution.N;
		pieces = new int[N][N];
		for (int i = 0; i<N; i++){
			for (int j = 0; j<N; j++){
				pieces[i][j] = solution.pieces[i][j];
			}
		}
	}
	public static void main(String[] args) {
		/*
		//A main to test class itself
		Board board = new Board(8);
		
		//test toString method with board set to all zeros
		System.out.print(board);
		//test setQ method and if Queens shows up
		board.setQ(0, 0);
		System.out.print(board);
		//test unSetQ method
		board.unSetQ(0, 0);
		System.out.print(board);
		// Test Queen Conflict detection in isBoardValid just vary parameters manually
		board.setQ(1, 0);
		board.setQ(2,1);
		System.out.print(board);
		System.out.println("board.isBoardValid()= "+board.isBoardValid());
		*/
		System.out.println("There is no auomatic testing code for this class but check source code."+
				" main contains some commented code to get you started.");
	}
	// Below method places a Queen in the form of a one on the board.
	public void setQ(int row, int col){
		pieces[row][col] = 1;
	}
	public void unSetQ(int N, int i) {
		pieces[N][i] = 0;
	}
	/* Checks whether board is valid. Rows are not checked across because every Queen is
	 * placed in it's own row. If any column or any diagonal adds to more then 1 it is an
	 * invalid board.
	 */
	public boolean isBoardValid(){
		//Check Columns straight down from top to bottom.
		int sum = 0;
		for (int col=0; col < N; col++){
			for (int row=0; row < N; row++){
				sum += pieces[row][col];
			}
			// This is case where two or more Queens are in the same column
			if (sum > 1) {
				return false;
			}
			else {
				sum = 0;
			}
		}
		// Below two for loops check '/' diagonal
		// count to keep track how far down the rows the program is and how many times it should
		// ratchet along the diagonal
		int tempRow, tempCol;
		for (int row =0; row <N; row++){
			tempRow = row;
			for (int col = 0; col <= row; col++){
				sum += pieces[tempRow][col];
				tempRow--;
			}
			if (sum > 1){
				return false;
			}
			else {
				sum = 0;
			}
		}
		for (int col =1; col < N; col++) {
			tempCol = col;
			for (int row = (N-1); row >= col; row--) {
				sum += pieces[row][tempCol];
				tempCol++;
			}
			if (sum > 1) {
				return false;
			}
			else {
				sum = 0;
			}
		}
		// Below two four loops check the '\' diagonal
		tempRow=0;
		tempCol=0;
		sum=0;
		for (int row =0; row <N; row++){
			tempRow = row;
			for (int col = (N-1); col >= (N-1-row); col--){
				sum += pieces[tempRow][col];
				tempRow--;
			}
			if (sum > 1){
				return false;
			}
			else {
				sum = 0;
			}
		}
		for (int col =0; col < N; col++) {
			tempCol = col;
			for (int row = (N-1); row >= (N-1-col); row--) {
				sum += pieces[row][tempCol];
				tempCol--;
			}
			if (sum > 1) {
				return false;
			}
			else {
				sum = 0;
			}
		}

		// Finally if all those checks are passed no Queens are threatening each other and
		// true is returned.
		return true;
	}
	@Override
	public String toString(){
		StringBuilder ASCII = new StringBuilder();
		ASCII.append("  _");
		for (int i = 0; i < N; i++) {
			ASCII.append("_____");
		}
		ASCII.append("\n");
		for (int row = 0; row < N; row++){
			// Left Side space padding on return string
			ASCII.append("  |");
			for (int col = 0; col <N; col++){
				if(pieces[row][col] == 1) {
					ASCII.append(" Q  |");
				}
				else {
					ASCII.append("    |");
				}
			}
			ASCII.append("\n");
			ASCII.append("  _");
			for (int i = 0; i < N; i++) {
				ASCII.append("_____");
			}
			ASCII.append("\n");
	}
		ASCII.append("\n\n");
		return ASCII.toString();
	}
}

