import java.util.ArrayList;
import java.util.List;

public class Converter {

    public Converter(){

    }

    //prime factorisation 

    public String toPrimeFactor(int input){

        int n = input;

        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }

        return factors.toString();
    }

    //roman numerals 
    public String toRomanNumerals(int num){

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
    public String toBinary(int input){
        return Integer.toBinaryString(input);
    }

    //Hexadecimal
    public String toHexadecimal(int input){
        return Integer.toHexString(input);
    }


    
}
