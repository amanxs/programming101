import java.util.HashSet;

public class SodukoSover {

    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    continue;
                }

                for(char k='1'; k<='9'; k++){
                    board[i][j]=k;
                    if(isValid(board, i, j) && helper(board)){
                        return true;
                    }
                    board[i][j]='.';
                }

                return false;
            }
        }

        return true; //return true if all cells are checked
    }

    private boolean isValid(char[][] board, int i, int j){
        HashSet<Character> set = new HashSet<>();

        for(int k=0; k<9; k++){
            if(set.contains(board[i][k])){
                return false;
            }
            if(board[i][k]!='.'){
                set.add(board[i][k]);
            }

        }

        set.clear();

        for(int k=0; k<9; k++){
            if(set.contains(board[k][j])){
                return false;
            }
            if(board[k][j]!='.'){
                set.add(board[k][j]);
            }
        }

        set.clear();

        int x=i/3 * 3;
        int y=j/3 * 3;
        for(int m=x; m<x+3; m++){
            for(int n=y; n<y+3; n++){
                if(set.contains(board[m][n])){
                    return false;
                }
                if(board[m][n]!='.'){
                    set.add(board[m][n]);
                }
            }
        }

        set.clear();

        return true;
    }
}
