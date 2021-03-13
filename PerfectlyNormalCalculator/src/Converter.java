import java.util.ArrayList;
import java.util.List;

public class Converter {

    public Converter(){

    }

    //prime factorisation 

    public String toPrimeFactor(double  input){


        List<Double> factors = new ArrayList<Double>();
        for (int i = 2; i <= input / i; i++) {
            while (input % i == 0) {
                factors.add((double) i);
                input /= i;
            }
        }
        if (input > 1) {
            factors.add(input);
        }

        return factors.toString();
    }

    //roman numerals 
    public String toRomanNumerals(double num){

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        return roman.toString();
    }

    //binary 
    public String toBinary(double input){
        return Integer.toBinaryString((int) input);
    }

    //Hexadecimal
    public String toHexadecimal(double input){
        return Integer.toHexString((int) input);
    }


    
}
