package coding2020;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(4));
        double d = sqrt(4);
        System.out.println(d);
    }

    public static double sqrt(int num){
        double l = 0.000000001;
        double x = num;
        double root;
        int count=0;
        while(true){
            count++;
            root = 0.5 * (x + num/x);
            if(Math.abs(root - x) < l) break;

            x = root;
        }
        return root;

    }
}
