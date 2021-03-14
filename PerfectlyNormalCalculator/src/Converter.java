import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Converter {

    public Converter(){

    }

    //prime factorisation 

    public String toPrimeFactor(double  input){
        
        int wholeInput = (int) input;
      
        String output = "";
        List<String> factors = new ArrayList<String>();

        for (int i = 2; i <= input / i; i++) {
            
            while (wholeInput % i == 0) {
                factors.add(randomiseFactor(i));
                wholeInput /= i;
                
              
            }
        }
        if (input > 1) {
            factors.add(Integer.toString(wholeInput));
        }
        for(int j = 0; j < factors.size(); j ++){
            if(j < factors.size() - 1){ //removes time 1 at the end
                output += factors.get(j) + "x";
            } else{
                output += factors.get(j);
            }
            
            
        }
        return output;
    }
    private String randomiseFactor(int num){
       
        Random rn = new Random();
        
        int ranNumTop = rn.nextInt(num*3); //random for top of fraction

        if(ranNumTop < 1){
            ranNumTop = 1;
        }
        
        int ranNumBottom = rn.nextInt(ranNumTop); //random for bottom of fraction
        int newNumTop = num * ranNumTop;
        
        if(ranNumTop % 2 == 0){
             
            int newNumBottom = ranNumTop + ranNumBottom;//then need to remove the ranNumBottom
            
            return new String("(" + newNumTop + "/(" + newNumBottom + "-" +  ranNumBottom + "))" );


        } else{
            
            int newNumBottom = ranNumTop - ranNumBottom;//then need to remove the ranNumBottom
            return new String("(" + newNumTop + "/(" + newNumBottom + "+" +  ranNumBottom + "))" );

        }
       
        


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
