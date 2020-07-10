import java.util.ArrayList;
import java.util.List;

public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        if(n <= 6 ) return n;

        List<Integer> uglys  = new ArrayList<>();
        uglys.add(1);// first ugly number

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while(uglys.size() < n){
            int next = (int) Math.min(Math.min(uglys.get(i2) * 2L, uglys.get(i3) * 3L), uglys.get(i5)* 5L);

            if(next == uglys.get(i2) * 2L){
                i2++;
            }
            if(next == uglys.get(i3) * 3L){
                i3++;
            }
            if(next == uglys.get(i5) * 5L){
                i5++;
            }
            uglys.add(next);
        }
        return uglys.get(n-1);
    }
}
