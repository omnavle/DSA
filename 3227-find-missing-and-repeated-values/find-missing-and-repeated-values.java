class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int total = n * n;

        int[] frequency = new int[total + 1];

        // Count frequency of each number
        for (int[] row : grid) {
            for (int num : row) {
                frequency[num]++;
            }
        }

        int repeated = -1;
        int missing = -1;

        // Find repeated and missing numbers
        for (int num = 1; num <= total; num++) {

            if (frequency[num] == 2) {
                repeated = num;
            } else if (frequency[num] == 0) {
                missing = num;
            }
        }

        return new int[]{repeated, missing};
    }
}