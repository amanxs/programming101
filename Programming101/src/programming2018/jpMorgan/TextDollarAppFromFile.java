package programming2018.jpMorgan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextDollarAppFromFile {

    private static final int REQ_COMMAND_LINE_ARGS = 1;
    private static final int STATUS_FAILURE = 1;
    private static final int STATUS_SUCCESS = 0;
    private static final int ONE_BILLION = 1000000000;
    private static final int ONE_MILLION = 1000000;

    public static final String ones[] = {"","One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen ", "Twenty "};

    public static final String tens[] = {"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};

    public static final String hundreds = "Hundred ";

    public static final String thousands = "Thousand ";

    public static final String millions = "Million ";

    public static final String billions = "Billion ";


    public static final String currency = "dollars";

    public static void main(String args[]) {
        if (args.length == REQ_COMMAND_LINE_ARGS) {
            try {
                prettyTextualPrinter(args[0]);
            } catch (FileNotFoundException f) {
                System.out.println("Caught FileNotFoundException: Unable to find the given input file");
                System.exit(STATUS_FAILURE);

            } catch (IOException i) {
                System.out.println("Caught FileNotFoundException: Unable to find the given input file");
                System.exit(STATUS_FAILURE);

            } catch (NumberFormatException n) {
                System.out.println("Caught FileNotFoundException: Unable to find the given input file");
                System.exit(STATUS_FAILURE);

            } catch (RuntimeException r) {
                System.out.println("Caught FileNotFoundException: Unable to find the given input file");
                System.exit(STATUS_FAILURE);

            }

        }
    }

    /**
     *
     * @param filePath
     * @throws RuntimeException
     * @throws IOException
     */

    static void prettyTextualPrinter(String filePath) throws RuntimeException, IOException {
        BufferedReader input = new BufferedReader(new FileReader(filePath));
        boolean firstLine = true;
        while (input.ready()) {
            String amountString = input.readLine().trim().replaceAll("\\s", "");
            if (!amountString.isEmpty()) {
                if (!firstLine) {
                    System.out.print(System.lineSeparator());
                }
                long amount = Long.valueOf(amountString);
                if (amount < 0 && amount > ONE_BILLION)
                    throw new RuntimeException("The amount should be between 0 and 1000000000");
                int number = (int) amount;
                String numberInWords = prettyPrintCurrency(number);
                System.out.print(numberInWords);
                if (firstLine)
                    firstLine = false;
            }

        }
    }

    static String printCurrency(int number){
        return prettyPrintCurrency(number) + currency;
    }

    static String convertHundredsToText(int number){
        if(number<=20)
            return ones[number];

        else if(number < 100){
            int tensPlace = number/10;
            int onesPlace = number%10;
            return tens[tensPlace] + ones[onesPlace];
        }

        else{
            int hundredsPlace = number/100;
            int tensPlace = number%100;
            return ones[hundredsPlace] + hundreds +  convertHundredsToText(tensPlace);
        }

    }

    static String prettyPrintCurrency(int number){
        if(number<1000)
            return convertHundredsToText(number);
        else if(number < 1000000){
            return convertHundredsToText(number/1000) + thousands +  convertHundredsToText(number%1000);
        }
        else
            return convertHundredsToText(number/1000000) + millions +

                    prettyPrintCurrency(number%1000000);


    }



}