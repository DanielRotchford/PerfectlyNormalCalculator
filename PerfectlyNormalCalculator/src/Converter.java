public class Converter {

    public Converter(){

    }

    //prime factorisation 

    public String toPrimeFactor(int input){

        return "";
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

    //exponential form 
    public String toExponential(int input){

        return "";
    }

    //floating point notation






    
}
