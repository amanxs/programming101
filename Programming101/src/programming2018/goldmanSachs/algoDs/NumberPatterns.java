package programming2018.goldmanSachs.algoDs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/*
Form minimum number from given sequence
4
Given a pattern containing only I’s and D’s. I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern.
Digits from 1-9 and digits can’t repeat.
 */
public class NumberPatterns {
    public static void main(String args[]){

        args= new String[]{"I", "D", "I", "D"};
        //getMinUsingStacks(args);
        collapseString("geeksforgeeks");

    }

    public static void getMin(String str[]){
        int decCount = 0;
        int min = 1;
        int max = 2;
        int n = str.length;
        int arr[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            switch(str[i]){
                case "I":
                    arr[i] = min;
                    arr[i+1] = max;
                    min=max;//4
                    break;
                case "D":
                    if(i>0 && str[i-1].equalsIgnoreCase("D"))
                        break;
                    for (int j=i;j<str.length;j++) {//1
                        if(str[j].equalsIgnoreCase("D"))
                            decCount++;//1,
                        else
                            break;
                    }
                    for (int j=i;decCount>=0;j++){//3
                        arr[j] = min + decCount;
                        decCount--;
                    }
                    if(arr[i]>max)
                        max=arr[i]+1; //4

                    break;
            }
            System.out.print(arr[i]);//1 3 2 5 4
        }
        System.out.print(arr[arr.length-1]);//1 3 2 5 4

    }

    public static void getMinGeeksForGeeks(String arr[]){
        int min =1, pos_I = 0;
        ArrayList<Integer> list = new ArrayList<>();

        if(arr[0]=="I"){
            list.add(1);
            list.add(2);
            min = 3;
            pos_I=1;
        }
        else{
            list.add(2);
            list.add(1);
            min = 3;
        }

        for (int i = 1; i< arr.length; i++){
            if(arr[0]=="I"){
                list.add(min);
                min++;
                pos_I =i+1;
            }
            else{
                list.add(list.get(i));
                for (int j = pos_I; j <= i; j++) {
                    list.add(j,list.get(j)+1);
                }
                min++;
            }

        }
        for (Integer s:list) {
            System.out.print(s);
        }
    }

    public static void getMinUsingStacks(String str[]){

        //int arr[] = new int[str.length+1];
        ArrayList<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0; i<=str.length; i++){
            stack.push(i+1);
            if(i==str.length || str[i]=="I"){
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }

            }
        }
        for (Integer s:list) {
            System.out.print(s);
        }
    }
    /*
 * Complete the closingBracePosition function below.
 */
    static int closingBracePosition(String inputSentence, int openingBraceNum) {
        /*
         * Write your code here.
         */
        if(hasError(inputSentence))
            return -1;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int count =0;
        char arr[] = inputSentence.toCharArray();
        for(int i=0; i<arr.length;i++){
            if('('==arr[i])
                count++;
            if(openingBraceNum==count)
                for(int j=i+1; j<arr.length;j++){
                    if(')'==arr[j])
                        return j+1;
                }

        }

        return -1;



    }

    private static boolean hasError(String sentence){
        Stack<Character> stack = new Stack<Character>();
        char arr[] = sentence.toCharArray();
        for(int i=0; i<arr.length;i++){
            if('('==arr[i])
                stack.push(arr[i]);
            else if(stack.isEmpty() && ')'==arr[i])
                return false;
            else if(')'==arr[i])
                stack.pop();
        }

        return !stack.isEmpty();

    }

    static String collapseString(String input) {
        if(input.length()==0)
            return "";

        HashMap <Character, Integer> map = new HashMap<Character,Integer>();
        char arr[] = input.toCharArray();
        char currChar = arr[0];
        int count = 1;
        for(int i=1; i<arr.length; i++){
            map.put(currChar,count);
            if(arr[i]==currChar)
                count++;
            else{
                currChar =arr[i];
                count=1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character key : map.keySet()){
            sb.append(map.get(key));
            sb.append(key);
        }

        return sb.toString();


    }
}
