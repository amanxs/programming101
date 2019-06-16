package programming2018.Algorithms;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int arr [] = {4, 35, 80, 123, 12345, 44, 8, 5, 24, 3, 22, 35};
        solution(arr, 4);
    }
    public static void solution(int[] A, int K) {
        // write your code in Java SE 8

        double n = A.length;


        int mx = Arrays.stream(A).map(x-> String.valueOf(x).length()).max().getAsInt();
        int row = (int)Math.ceil(n/K);
        int column = (K>A.length) ? A.length : K;

        System.out.println(row);

        createBox(mx,column,row , A );

    }

    static void createBox(int boxLength, int columns, int rows, int number[]){
        StringBuilder s = new StringBuilder();
        int index = 0;
        int cnt = 0;

        for(int r=0; r <rows; r++) {
            cnt = 0;

            for (int i = 0; i <columns; i++) {
                s.append("+");
                for (int j = 0; j < boxLength; j++) {
                    s.append("-");
                }
            }
            s.append("+");

            s.append("\n");



            for (int i = 0; i <columns; i++) {
                s.append("|");cnt++;

                String x = addNumber(boxLength-String.valueOf(number[index]).length(), number[index]);
                s.append(x);
                cnt = cnt + x.length();

                index++;
                if(index ==  number.length)
                    break;
            }
            s.append("|"); cnt++;

            s.append("\n");

        }


        System.out.println(cnt);
        int xxx = 0;
        for (int i = 0; i <columns; i++) {
            xxx++;
            if(xxx>= cnt) break;

            s.append("+");

            for (int j = 0; j < boxLength; j++) {
                s.append("-"); xxx++;
            }
        }
        s.append("+");



        System.out.println(s.toString());
    }

    static String addNumber(int spaceCount, int number){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<spaceCount; i++)
            sb.append(" ");

        sb.append(number);

        return sb.toString();
    }
}
