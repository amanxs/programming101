package programming2018.goldmanSachs.algoDs;

public class RobotPosition {

    public static void main(String args[]){

        getPosition("UDDLLRUUUDUURUDDUULLDRRRR");
    }

    static void getPosition(String s){
        char arr[] = s.toCharArray();
        int x =0;
        int y = 0;

        for(int i = 0 ; i<arr.length; i++) {
            switch (arr[i]) {
                case 'U':
                    y++;
                    break;

                case 'D':
                    y--;
                    break;

                case 'L':
                    x--;
                    break;

                case 'R':
                    x++;
                    break;
            }
        }

        System.out.print("Coordinates:" +x+","+y);
    }
}
