package programming2019.geeksForGeeks.mathematicalAlgorithms;

public class SquareRoot {
    public static void main(String[] args) {

        int number = 2;
        int squareRoot = squareRoot(number);
        if (0 == squareRoot)
            System.out.println("No square root found");
        else
            System.out.println("Square root is : " + squareRoot);

        System.out.println("but absolute square root would be : " + absoluteSquareRoot(number));


    }

    private static int squareRoot(int number) {
        int x = 0;
        int sqrt = 0;
        int squareX = x * x;

        while (x * x <= number) {

            if (x * x == number) {
                sqrt = x;
            }
            x++;
        }
        return sqrt;
    }

    private static double absoluteSquareRoot(int number) {
        double sqrt = 0;
        double x = 0;
        double epsilon = 0.001;// this decides the accuracy level

        while (x * x <= number - epsilon) {

            if (x * x - number <= epsilon) {
                sqrt = x;
            }
            x = x + 0.01;
        }
        return sqrt;
    }


    //Newton method
    public static double sqrt(double c)
    {
        if (c > 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t)
            t = (c/t + t) / 2.0;
        return t;
    }
}
