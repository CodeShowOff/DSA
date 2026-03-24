public class DecimalToBinary {
    public String convertToBinary(int num) {
        if (num == 0) return "0";

        StringBuilder result = new StringBuilder();

        while (num > 0) {
            result.append(num % 2);
            num /= 2;
        }

        return result.reverse().toString();
    }

    public String covertToBinary2(int num){
        return Integer.toBinaryString(num);
    }
}
