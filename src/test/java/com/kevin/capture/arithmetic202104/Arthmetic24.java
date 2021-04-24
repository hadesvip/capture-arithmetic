package com.kevin.capture.arithmetic202104;

/**
 * 每日一道算法题
 *
 * @author kevin
 * @date 2021/04/24
 */
public class Arthmetic24 {


  public static void main(String[] args) {
    int[] array = new int[]{1, 3, 4, 7, 7, 8, 10, 35};
    int low = 0;
    int high = array.length - 1;
    int target = 7;
    int index = binarySearch(array, low, high, target);
    System.out.println(index);

  }


  /**
   * 二分查找
   *
   * @param array  有序数组
   * @param low    低位
   * @param high   高位
   * @param target 目标值
   * @return 返回下标位置
   */
  public static int binarySearch(int[] array, int low, int high, int target) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (array[mid] > target) {
        high = mid - 1;
      } else if (array[mid] < target) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

}
