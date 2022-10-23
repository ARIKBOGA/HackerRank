import java.util.Arrays;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        boolean[] arr = new boolean[nums.length + 1];

        // find duplicated value
        for (int num : nums) {
            if (arr[num]) {
                result[0] = num;
            }
            arr[num] = true;
        }

        // find missing value
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i] && i != result[0]) {
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = findErrorNums(new int[]{1, 2, 2, 4});
        System.out.println(Arrays.toString(ints));

        ints = findErrorNums(new int[]{1, 1});
        System.out.println(Arrays.toString(ints));
    }
}
