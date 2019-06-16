package programming2018.jpMorgan;

public class TextDollarApp {

    public static final String ones[] = {"","One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen ", "Twenty "};

    public static final String tens[] = {"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};

    public static final String hundreds = "Hundred ";

    public static final String thousands = "Thousand ";

    public static final String millions = "Million ";

    public static final String billions = "Billion ";


    public static final String currency = "dollars";


    private static final StringBuilder displayValue = new StringBuilder();

    public static void main(String args[]){
        System.out.println("Response for : " + printCurrency(21));

    }

    static String printCurrency(int number){
        String words = prettyPrintCurrency(number);
        displayValue.append(words);
        displayValue.append(currency);
        return displayValue.toString();
    }

    static String convertHundredsToText(int number){
        StringBuilder localBuilder = new StringBuilder();
        if(number<=20)
            localBuilder.append(ones[number]);

        else if(number < 100){
            int tensPlace = number/10;
            int onesPlace = number%10;
            localBuilder.append(tens[tensPlace]);
            localBuilder.append(ones[onesPlace]);
        }

        else{
            int hundredsPlace = number/100;
            int tensPlace = number%100;
            localBuilder.append(ones[hundredsPlace]);
            localBuilder.append(hundreds);
            localBuilder.append(convertHundredsToText(tensPlace));
        }

        return localBuilder.toString();
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
