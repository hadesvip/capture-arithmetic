package com.kevin.capture.arithmetic.samples;

import org.junit.Assert;
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
        String expectedNumber = Integer.toBinaryString(11);
        String binaryNumber = decimalConvertBinary(11);
        Assert.assertEquals(binaryNumber, expectedNumber);
    }


    private String decimalConvertBinary(int num) {
        if (num < 0) {
            throw new RuntimeException("暂不支持负数转换");
        }
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
