package com.kevin.capture.arithmetic.samples;

import java.util.Arrays;

/**
 * 区间查找
 * <p>
 * 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author kevin
 */
public class LeetCode34 {


  public static void main(String[] args) {

    int[] orderedArray = new int[]{2, 2};
    int target = 2;
    int[] rtArray = new LeetCode34().searchRange(orderedArray, target);

    Arrays.stream(rtArray).forEach(System.out::println);

  }


  /**
   * 区间查找 思路：采用两次二分查找
   *
   * @param orderedArray 升序的int数组
   * @param target       要查找的数值
   * @return 不存在目标值 target,返回[-1, -1],反之返回起始位置和末尾位置[x,x]
   */
  public int[] searchRange(int[] orderedArray, int target) {
    return new int[]{findLeftPosition(orderedArray, target),
        findRightPosition(orderedArray, target)};
  }

  /**
   * 左端位置
   */
  private int findLeftPosition(int[] orderedArray, int target) {
    int left = 0;
    int right = orderedArray.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      //查找的元素下标是0或者前一个元素小于目标值
      if (orderedArray[middle] == target && (middle == 0 || orderedArray[middle - 1] < target)) {
        return middle;
      }
      //要查找的元素在左侧
      else if (orderedArray[middle] == target || orderedArray[middle] > target) {
        right = middle - 1;
      }
      //要查找的元素在右侧
      else if (orderedArray[middle] < target) {
        left = middle + 1;
      }
    }
    return -1;
  }

  /**
   * 右端位置
   */
  private int findRightPosition(int[] orderedArray, int target) {
    int left = 0;
    int right = orderedArray.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      //查找的元素的下标是数组的最大小标或者后一个元素大于目标值
      if (orderedArray[middle] == target && (middle == orderedArray.length - 1
          || orderedArray[middle + 1] > target)) {
        return middle;
      }
      //要查找的元素在左侧
      else if (orderedArray[middle] > target) {
        right = middle - 1;
      }
      //要查找的元素在右侧
      else if (orderedArray[middle] < target || orderedArray[middle] == target) {
        left = middle + 1;
      }
    }

    return -1;
  }


}
