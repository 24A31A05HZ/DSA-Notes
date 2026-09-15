public class RadixSort {

    static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Sort according to each digit
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, place);
        }
    }

    static int getMax(int[] arr) {
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    static void countingSort(int[] arr, int place) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Count occurrences of each digit
        for (int num : arr) {
            int digit = (num / place) % 10;
            count[digit]++;
        }

        // Convert count into positions
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy back
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {

        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        radixSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
