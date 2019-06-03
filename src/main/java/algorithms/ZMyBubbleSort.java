package algorithms;

public class ZMyBubbleSort {

    public int[] sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            boolean swaped = false;
            for(int j = 0; j < arr.length - 1 - i; j++) {
                print(arr, i, j);
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swaped = true;
                }
            }
            if (!swaped) {
                break;
            }
        }
        return arr;
    }

    public void print(int[] a, int i, int j) {
        System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " i=" + i + " j=" + j);
    }


}
