import java.util.List;
import java.util.ArrayList;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Calculate1("7 + 10 * 21");
    }

    public static final String add = "+";
    public static final String subtract = "-";
    public static final String multiply = "*";
    public static final String divide = "/";

    public static void Calculate1(String calc) {
        String[] calculate = calc.split(" "); //splits string 
        int total = 0;
        List<Integer> numbers = new ArrayList<Integer>(); //will contain all numbers
        List<String> operations = new ArrayList<String>(); //will contain all operations
        for(int i = 0; i < calculate.length; i++) {
            try {
                numbers.add(Integer.parseInt(calculate[i]));
            }
            catch (NumberFormatException e) {
                operations.add(calculate[i]);
            }
        }
        total += numbers.get(0);
        for(int j = 0; j < operations.size(); j++) {
            switch(operations.get(j)) {
                case add:
                    total = total + numbers.get(j+1);
                    break;
                case subtract:
                    total = total - numbers.get(j+1);
                    break;
                case multiply:
                    total = total * numbers.get(j+1);
                    break;
                case divide:
                    total = total / numbers.get(j+1);
                    break;
            }
        }
        System.out.println(total);
    }
}
