package programming2019.geeksForGeeks.mathematicalAlgorithms;

public interface  StdRandom {
    /*
    initialize
real between 0 and 1
integer between 0 and N-1 integer between lo and hi-1 real between lo and hi
true with probability p normal, mean 0, std dev 1 normal, mean m, std dev s
i with probability a[i] randomly shuffle the array a[]
     */
    void initialize(long seed); //initialize
    double random(); //real between 0 and 1

    int uniform(int N); //integer between 0 and N-1
    int uniform(int lo, int hi); //integer between lo and hi-1
    double uniform(double lo, double hi); //real between lo and hi
    boolean bernoulli(double p);// true with probability p
    double gaussian(); //    normal, mean 0, std dev 1
    double gaussian(double m, double s); //normal, mean m, std dev s
    int discrete(double[] a); //i with probability a[i]
    void shuffle(double[] a); // randomly shuffle the array a[]
}
