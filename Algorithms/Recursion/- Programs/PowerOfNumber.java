package com.Codes.Recursion;

public class PowerOfNumber {

    public static double findPower(double base, double power){
        if(power == 0){
            return 1;
        }

        if(power > 0){
            return base * findPower(base, power - 1);
        }else{
            return 1 / (findPower(base, - power)); // convert negative power to positive
        }
    }

    public static void main(String[] args) {
        System.out.println(findPower(5, 3));
    }
}
