import java.util.List;
import java.util.ArrayList;

public class Calculator {
    public static void main(String[] args) throws Exception {
        //Calculate1("7 + 10 * 21");
        calculate("8 + 42 * 3 - 7 * 9");
    }

    public static final String add = "+";
    public static final String subtract = "-";
    public static final String multiply = "*";
    public static final String divide = "/";

    public static Integer Calculate1(String calc) {
        String[] calculate = calc.split(" "); //splits string 
        int total = 0;
        List<Integer> numbers = new ArrayList<Integer>(); //will contain all numbers
        List<String> operations = new ArrayList<String>(); //will contain all operations
        for(int i = 0; i < calculate.length; i++) {
            System.out.println(calculate[i]);
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
                case multiply:
                    total = total * numbers.get(j+1);
                    break;
                case divide:
                    total = total / numbers.get(j+1);
                    break;
            }
        }
        return total;
    }
    //between each 2d array is minus, between each array is plus
    public static void calculate(String calculation){
        String[] subsets = (calculation.split("\\+"));
       
        
        String[][] subsubsets = new String[subsets.length][];

        for(int j = 0; j < subsets.length; j ++){
            subsubsets[j] = subsets[j].split("\\-");

        }
        
        merge(subsubsets);
        

    }
    private static void merge(String[][] values){
        
        int result = 0;
        
        for(String[] subset : values){
            
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(String equation : subset){
                
                temp.add(Calculate1(equation.strip()));
                 
            }
            result += combine(temp);
            
        }
            System.out.println(result);
    }

    private static int combine(ArrayList<Integer> vals){
        int temp = vals.get(0);
        

        if(vals.size() > 1){
            for(int i = 1 ; i < vals.size(); i ++){
                temp -= vals.get(i);
            }
        }
        
        return temp;
    }
}
