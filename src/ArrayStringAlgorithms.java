class ArrayStringAlgorithms {

    // Rotate right in place: O(n) time, O(1) extra space
    public static void rotateRight(int[] a, int k) {
        if (a == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int n = a.length;

        if (n == 0) {
            return;
        }

        k = ((k % n) + n) % n;

        if (k == 0) {
            return;
        }

        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
    }

    // Reverse an array section
    private static void reverse(int[] a, int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }
    }

    // Check anagrams: O(n) time, O(1) extra space
    // Case-sensitive; counts UTF-16 char values
    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        int[] frequency = new int[Character.MAX_VALUE + 1];

        for (int i = 0; i < a.length(); i++) {
            frequency[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            frequency[b.charAt(i)]--;

            if (frequency[b.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }

    // Two Sum sorted: O(n) time, O(1) extra space
    // Returns zero-based indices, or {-1, -1}
    public static int[] twoSumSorted(int[] a, int target) {
        if (a == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            long sum = (long) a[left] + a[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}