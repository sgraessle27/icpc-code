import java.util.Arrays;

public class EightQueens {
    static int [] board;
    static int sum;
    static int attempt;
    public static void main(String [] args)
    {
        board = new int[8];  //column in row i with a queen
        sum=0;
        attempt = 0;
        System.out.println(backtrack(0));
printBoard();
System.out.println(sum);
System.out.println(attempt);
    }

    static boolean backtrack(int row) {
        int next;
        while((next = nextCandidate(row) )!= -1)
        {
            if(success(next))
            {
                printBoard();
                sum++;
               // return true;
            }
            else if(feasible(row))
            {
                boolean solution = backtrack(next);
                if(solution) {
                    printBoard();
                    sum++;
                    //backtrack(next);
                    //return true;
                }

            }
        }
        board[row]=0;
        return false;
        //nextCandidate(state)
        //feasibility(nextCandidate)
        //problemSolved(state)
        //backtrack(state)
            //While next = nextCandidate(state)
            //if success(next) return next
            //if feasible(next) backtrack(next)
        //return null
    }

    static  void printBoard() {
        for(int  i=0; i<8; i++)
        {
            System.out.printf("(%d, %d) ", i+1, board[i]);
        }
        System.out.println();
    }

    static int nextCandidate(int row) {
        attempt++;
        if(board[row] < 8) {
            ++board[row];
            return row+1;
        }

        return -1;
    }

    static boolean feasible(int row)
    {
        for(int i=0; i<row; i++)
        {
            if(board[i]==board[row]) {
                return false;
            }

            if(Math.abs((board[i]-board[row])) == Math.abs(row-i))
            {
                return false;
            }
        }
        return true;
    }

    static boolean success(int row) {
        return feasible(row-1) && row==8;
    }
}