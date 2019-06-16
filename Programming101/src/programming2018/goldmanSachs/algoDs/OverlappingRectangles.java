package programming2018.goldmanSachs.algoDs;

import java.util.Scanner;

public class OverlappingRectangles {


    public static void main (String[] args) {
        //code

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            //2lines of input
            //every line contains 4 ints: x & y of top left and right bottom rectangle
                int xl1 = in.nextInt();
                int yl1 = in.nextInt();
                int xr1 = in.nextInt();
                int yr1 = in.nextInt();
            int xl2 = in.nextInt();
            int yl2 = in.nextInt();
            int xr2 = in.nextInt();
            int yr2 = in.nextInt();
            boolean cond1 = xl1==xl2 || xl1== xr2;
            boolean cond2 = xr1==xl2 || xr1== xr2;
            boolean cond3 = yr1==yl2 || yr1== yr2;
            boolean cond4 = yl1==yl2 || yl1== yr2;

            if(cond1||cond2||cond3||cond4)
                System.out.println(1+"");
            else
                System.out.println(0+"");

        }
    }

}
