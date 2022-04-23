package cn.xxblog.leetcode;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 2, 3, 2};
        int i = new RemoveElement().removeElement(ints, 2);
        System.out.println(i);
    }

}
