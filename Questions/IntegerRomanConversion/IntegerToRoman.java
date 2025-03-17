package IntegerRomanConversion;

public class IntegerToRoman {
    public String getRoman(int num, int place){
        if(num == 0){
            return "";
        }

        if(place == 1){
            if(num < 5){
                if(num+1 == 5){
                    return "IV"; // for final reverse
                }
                StringBuilder x = new StringBuilder();
                while (num > 0) {
                    x.append("I");
                    num--;
                }
                return x.toString();
            }
            if(num > 5){
                if(num + 1 == 10){
                    return "IX";
                }
                StringBuilder x = new StringBuilder("V");
                while (num > 5) {
                    x.append("I");
                    num--;
                }
                return x.toString();
            }
            return "V";
        }

        if(place == 2){
            if(num < 5){
                if(num+1 == 5){
                    return "XL";
                }
                StringBuilder x = new StringBuilder();
                while (num > 0) {
                    x.append("X");
                    num--;
                }
                return x.toString();
            }
            if(num > 5){
                if(num + 1 == 10){
                    return "XC";
                }
                StringBuilder x = new StringBuilder("L");
                while (num > 5) {
                    x.append("X");
                    num--;
                }
                return x.toString();
            }
            return "L";
        }
        if(place == 3){
            if(num < 5){
                if(num+1 == 5){
                    return "CD";
                }
                StringBuilder x = new StringBuilder();
                while (num > 0) {
                    x.append("C");
                    num--;
                }
                return x.toString();
            }
            if(num > 5){
                if(num + 1 == 10){
                    return "CM";
                }
                StringBuilder x = new StringBuilder("D");
                while (num > 5) {
                    x.append("C");
                    num--;
                }
                return x.toString();
            }
            return "D";
        }
        if(place == 4){
            StringBuilder x = new StringBuilder();
            while (num > 0) {
                x.append("M");
                num--;
            }
            return x.toString();
        }
        return "";
    }

    public String intToRoman(int num) {
        // num = 3459;

        int count = 0;
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            int current = num % 10;
            count++;

            String currString = getRoman(current, count);

            StringBuilder revString = new StringBuilder();
            for (int i = currString.length() - 1; i >= 0; i--){
                revString.append(currString.charAt(i));
            }

            result.append(revString);

            num /= 10;
        }

        StringBuilder finalResult = new StringBuilder();
        for (int i = result.length()-1 ; i >= 0; i--) {
            finalResult.append(result.charAt(i));
        }

        return finalResult.toString();
    }

}