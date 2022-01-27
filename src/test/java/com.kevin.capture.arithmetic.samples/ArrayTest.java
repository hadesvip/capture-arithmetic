package com.kevin.capture.arithmetic.samples;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ArrayTest {


  @Test
  public void shuffleTest() {
    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
    //打散随机
    Collections.shuffle(nums);
    nums.forEach(System.out::println);

    List<String> strs = Collections.nCopies(2, "hello");
    strs.forEach(System.out::println);
    Logger.getGlobal().info("=========end==========");

  }

}
