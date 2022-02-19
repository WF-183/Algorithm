package com.exec.search;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/1/23
 * @version: 1.0.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 2, 2, 2, 3, 4, 5};
        System.out.println(search(arr, 2));//3
        System.out.println(searchLeftBoard(arr, 2));//2
        System.out.println(searchRightBoard(arr, 2));//4
    }

    //无重复元素找指定值
    public static int search(int[] nums, int target) {
        //二分查找-非递归写法才是主流，更强大
        int left = 0;
        int right = nums.length - 1;

        //我统一使用左闭右闭区间
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                //直接返回
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    //寻找左边界
    public static int searchLeftBoard(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        //我统一使用左闭右闭区间
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                //找到继续往左找
                right = mid - 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            }
        }

        //检查越界、没找到
        if (left > arr.length - 1 || arr[left] != target) {
            return -1;
        }
        //right在移动，最终结果是left
        return left;
    }

    //寻找右边界
    public static int searchRightBoard(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        //我统一使用左闭右闭区间
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                //找到继续往右找
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            }
        }

        //检查越界、没找到
        if (right < 0 || arr[right] != target) {
            return -1;
        }
        return right;
    }

}
