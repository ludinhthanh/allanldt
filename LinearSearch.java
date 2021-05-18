package binarysearch;
public class Binarysearch {
    int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }        
        return -1;
    }

    public static void main(String args[]) {
        Binarysearch A = new Binarysearch();
        int arr[] = { 1, 1, 1, 1, 3, 4, 6, 8, 9, 9, 10, 86 };
        int n = arr.length;
        int x =4 ;
        int result = A.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Phần tử không tồn tại.");
        else
            System.out.println("Phần tử được tìm thấy tại vị trí: " + result);
    }
}
