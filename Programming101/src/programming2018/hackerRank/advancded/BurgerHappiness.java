package programming2018.hackerRank.advancded;

import java.util.ArrayList;
import java.util.Scanner;

public class BurgerHappiness {

    public  static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int numberOfRest = in.nextInt();
        ArrayList<int[]> listOfBurgerRestaurants = new ArrayList();

        for (int i = 0; i <numberOfRest ; i++) {
            int Xi = in.nextInt();
            int Ai= in.nextInt();
            int Bi = in.nextInt();

            int happiness[] = new int[2];
            happiness[0] = Ai;
            happiness[1] = Bi;

            listOfBurgerRestaurants.add(Xi-1,happiness);

        }

        int happiness1[] = listOfBurgerRestaurants.get(0);
        int maxHappiness = happiness1[0]+happiness1[1];

        for (int j = 1; j < listOfBurgerRestaurants.size(); j++) {
            int happinessi[] = listOfBurgerRestaurants.get(j);
            int happiness = happinessi[0] - happinessi[1];
            if(happiness>0)
                maxHappiness+=happiness;

            else if(happiness<0 ) {
                if (j + 1 < listOfBurgerRestaurants.size()) {
                    int happinessNext[] = listOfBurgerRestaurants.get(j + 1);
                    int nextHappiness = happinessi[0] - happinessi[1];

                }
            }


        }


        }
}
