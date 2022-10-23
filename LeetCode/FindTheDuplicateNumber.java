public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        boolean[] arr = new boolean[nums.length + 1];

        // find duplicated value
        int dup = 0;
        for (int num : nums) {
            if (arr[num]) {
                dup = num;
            }
            arr[num] = true;
        }
        return dup;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
