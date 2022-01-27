package com.kevin.capture.arithmetic.samples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 十进制转二进制
 *
 * @author kevin
 */
public class DecimalConvertBinaryTest {


    @Test
    public void decimalConvertBinaryTest() {
        String binaryNumber = decimalConvertBinary(11);
        System.out.println(binaryNumber);

        String binaryString = Integer.toBinaryString(11);
        System.out.println(binaryString);
    }


    private String decimalConvertBinary(int num) {
        List<Integer> numList = new ArrayList<>();
        while (num != 0) {
            int mod = num % 2;
            numList.add(mod);
            num = num / 2;
        }
        //反转
        String reverseStr = "";
        for (int i = numList.size() - 1; i >= 0; i--) {
            reverseStr = reverseStr.concat(String.valueOf(numList.get(i)));
        }
        return reverseStr;
    }


}
