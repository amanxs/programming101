package programming2020;

public class SpiralTraversalInMatrix {
    // driver program
    public static void main(String[] args)
    {
        int R = 3;
        int C = 6;
        int a[][] = {
                { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };
        spiralPrint(R, C, a);
    }

    private static void spiralPrint(int R, int C, int a[][]){
        int r=0;
        int c=0;
        while(r<R && c<C){
            for(int i=c; i<C-1; i++){
                System.out.print(a[r][i] + " " );
            }
            for(int i=r; i<R-1; i++){
                System.out.print(a[i][C-c-1] + " ");
            }
            if(r<R/2 && c<C/2) {
                for (int i = c; i < C - 1; i++) {
                    System.out.print(a[R - r - 1][C - c - 1 - i] + " ");
                }

                for (int i = r; i < R - 1; i++) {
                    System.out.print(a[R - r - 1 - i][c] + " ");
                }
            }
            r++;
            c++;
        }

    }
}
