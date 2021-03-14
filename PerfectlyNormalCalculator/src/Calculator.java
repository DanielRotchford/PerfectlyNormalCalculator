import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Calculator {
    /*
     * public static void main(String[] args) throws Exception {
     * //Calculate1("7 + 10 * 21"); calculate("8.4 + 42 * 3 - 7.6 * 9"); }
     */

    public static final String add = "+";
    public static final String subtract = "-";
    public static final String multiply = "x";
    public static final String divide = "/";

    public Double Calculate1(String calc) {
        String[] calculate = calc.split(" "); // splits string
        double total = 0.0;
        List<Double> numbers = new ArrayList<Double>(); // will contain all numbers
        List<String> operations = new ArrayList<String>(); // will contain all operations
        for (int i = 0; i < calculate.length; i++) {

            try {

                numbers.add(Double.parseDouble(calculate[i]));

            } catch (NumberFormatException e) {
                operations.add(calculate[i]);
            }
        }
        total += numbers.get(0);

        for (int j = 0; j < operations.size(); j++) {
            switch (operations.get(j)) {
            case multiply:
                total = total * numbers.get(j + 1);
                break;
            case divide:
                total = total / numbers.get(j + 1);
                break;
            }
        }
        return total;
    }

    // between each 2d array is minus, between each array is plus
    public String calculate(String calculation) {

        String[] subsets = (calculation.split("\\+"));

        String[][] subsubsets = new String[subsets.length][];

        for (int j = 0; j < subsets.length; j++) {
            subsubsets[j] = subsets[j].split("\\-");

        }

        String result = merge(subsubsets);
        return result;

    }

    private String merge(String[][] values) {

        double result = 0;

        for (String[] subset : values) {

            ArrayList<Double> temp = new ArrayList<Double>();
            for (String equation : subset) {

                temp.add(Calculate1(equation.strip()));

            }
            result += combine(temp);

        }
        Converter converter = new Converter();
        Random rn = new Random();
        int switchCase;
        String resultString;
        if (result >= 0) {
            switchCase = rn.nextInt(5);
            switch (switchCase) {
            case 0:
                resultString = converter.toPrimeFactor(result);
                break;
            case 1:
                resultString = converter.toRomanNumerals(result);
                break;
            case 2:
                resultString = converter.toBinary(result) + " (binary Two's Complement)";
                break;
            case 3:
                resultString = converter.toHexadecimal(result) + " (hex)";
                break;
            default:
                resultString = String.valueOf(result);
            }
        } else {
            switchCase = rn.nextInt(4);
            switch (switchCase) {
                case 0:
                resultString = "-" + converter.toRomanNumerals(result * -1);
                break;
            case 1:
                resultString = converter.toBinary(result) + " (binary Two's Complement)";
                break;
            case 2:
                resultString = "-" + converter.toHexadecimal(result * -1) + " (hex)";
                break;
            default:
                resultString = String.valueOf(result);
            }
        }
        return resultString;
    }

    private static Double combine(ArrayList<Double> vals) {
        Double temp = vals.get(0);

        if (vals.size() > 1) {
            for (int i = 1; i < vals.size(); i++) {
                temp -= vals.get(i);
            }
        }

        return temp;
    }
}
