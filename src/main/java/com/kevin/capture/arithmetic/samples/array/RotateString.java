//package com.kevin.capture.arithmetic.samples.array;
//
//
//import org.apache.commons.lang3.StringUtils;
//
///**
// * 给定 两个 字符串 s1 和 s2，
// * 要求 判定 s2 是否 能够 被 通过 s1 作 循环 移位（ rotate） 得到 的 字符串 包含。
// * <p>
// * 例如， 给定 s1 ＝ AABCD 和 s2 ＝ CDAA， 返回 true；
// * 给定 s1 ＝ ABCD 和 s2 ＝ ACBD， 返回 false。
// *
// * @author kevin
// */
//
//public class RotateString {
//
//
//    public static void main(String[] args) {
//        String s1 = "ABCD";
//        String s2 = "ACBD";
//        System.out.println(hasRotate3(s1, s2));
//    }
//
//    /**
//     * 空间换时间
//     * 解法1：循环移位的字符拼接2倍
//     * 缺陷：字符串过长导致内存消耗过大
//     */
//    public static boolean hasRotate1(String src, String dest) {
//        String doubleString = src + src;
//        for (int i = 0; i < dest.length(); i++) {
//            if (doubleString.substring(i).startsWith(dest)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 解法二：对字符串src进行循环移动
//     */
//    public static boolean hasRotate2(String src, String dest) {
//        //src:AABCD、desc:CDAA
//        //AABCD->AABC->ABCD->BCDA->CDAA->DAAB
//        if (StringUtils.isEmpty(src) || StringUtils.isEmpty(dest)) {
//            return false;
//        }
//        int srcLength = StringUtils.length(src);
//        int desLength = StringUtils.length(dest);
//        for (int i = 0; i < srcLength; i++) {
//            char c = src.charAt(i);
//
//
//
//            if (c == dest.charAt(0)) {
//                for (int j = 0; j < desLength; j++) {
////                    if ()
//                }
//            }
//
//        }
//        char[] attr1Arr = attr1.toCharArray();
//        int attrLen = attr1.length();
//        char temp;
//        for (int i = 0; i < attrLen; i++) {
//            temp = attr1.charAt(i);
//            for (int j = 0; j < attrLen - 1; j++) {
//                attr1Arr[j] = attr1Arr[j + 1];
//            }
//
//            attr1Arr[attrLen - 1] = temp;
//            if (new String(attr1Arr).contains(attr2)) {
//                // true
//                return true;
//            }
//        }
//        return false;
//
//
//        return false;
//    }
//
//
//    /**
//     * 解法三:
//     */
//    public static boolean hasRotate3(String src, String dest) {
//        //src:AABCD、desc:CDAA
//        //AABCD->AABC->ABCD->BCDA->CDAA->DAAB
//        if (StringUtils.isEmpty(src) || StringUtils.isEmpty(dest)) {
//            return false;
//        }
//        if (src.startsWith(dest)) {
//            return true;
//        }
//        int srcLength = StringUtils.length(src);
//        int desLength = StringUtils.length(dest);
//        int p = 0;
//        for (int i = 0; i < srcLength * 2; i++) {
//            char c = src.charAt(p % srcLength);
//            if (c == dest.charAt(0)) {
//                for (int j = 0; j <= desLength; j++) {
//                    if (j == desLength) {
//                        return true;
//                    }
//                    if (src.charAt((p + j) % srcLength) != dest.charAt(j)) {
//                        break;
//                    }
//                }
//            }
//            p++;
//        }
//        return false;
//    }
//
//}
