import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// N Queen Problem
public class QueensN {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = 0;
		List<Board> solutions = new ArrayList<Board>();
		
		System.out.print("Enter an integer (N) for size of board and number of Queens: ");
		N = input.nextInt();
		//Board will be initialized with zeros
		Board board = new Board(N);
		genBoards((N-1), board, solutions);
		System.out.println("The number of N Queen solutions for a N of: "+N+" is: "+solutions.size());
		System.out.print("Enter the number of solutions you wish to see: ");
		int numSol = input.nextInt();
		for (int i = 0; i < numSol; i++){
			System.out.print(solutions.get(i));
		}
		input.close();
	

	}   
	public static void genBoards(int N, Board board, List<Board> solutions) {
		if(N==0){
			Board newSolution = null;
			//base case, which represents the last row. Anytime the call to setQ returns true
			//here this is a solution and it get's added to solutions.
			for (int i = 0; i < board.N; i++){
				//N= row, i = col
				board.setQ(N, i);
				if((board.isBoardValid())){
					//Call copy constructor to make deep copy.
					newSolution = new Board(board);
					solutions.add(newSolution);
					//keeping checking for solutions so scrub board of old Queen placement
				}
				board.unSetQ(N, i);
			}
		}
		else {
			for (int i = 0; i < board.N; i++){
				// Set down the Queen and let the base case sort out valid from invalid boards.
				//N= row, i = col
				board.setQ(N, i);
				// No point setting all the boards down if Queens already threaten each other so check
				if(board.isBoardValid()){
					genBoards((N-1), board, solutions);
					board.unSetQ(N, i);
				}
				else {
					board.unSetQ(N, i);
				}
			}
		}
		return;
	}
}


