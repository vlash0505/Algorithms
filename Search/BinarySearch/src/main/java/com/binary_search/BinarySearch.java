package main.java.com.binary_search;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


    public static int recursiveBinarySearch(int[] arr, int l, int r, int target) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            l = mid + 1;
            return recursiveBinarySearch(arr, l, r, target);
        } else {
            r = mid - 1;
            return recursiveBinarySearch(arr, l, r, target);
        }
    }
}
