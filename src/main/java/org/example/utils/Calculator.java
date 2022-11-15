package org.example.utils;

public class Calculator {
    public  double calculate(String sentence){
        sentence.replace(" ", "");

        if(sentence.contains("+")){
            String[] nums = sentence.split("\\+");
            return Double.parseDouble(nums[0]) + Double.parseDouble(nums[1]);
        }
        else if (sentence.contains("-")) {
            String[] nums = sentence.split("-");
            return Double.parseDouble(nums[0]) - Double.parseDouble(nums[1]);
        }
        else if (sentence.contains("/")) {
            String[] nums = sentence.split("/");
            return Double.parseDouble(nums[0]) / Double.parseDouble(nums[1]);
        }
        else if (sentence.contains("x")) {
            String[] nums = sentence.split("x");
            return Double.parseDouble(nums[0]) * Double.parseDouble(nums[1]);
        }
        return 0;
    }
}
