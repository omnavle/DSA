class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) {
            return nums;
        }

        // Count the frequency of each number
        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Min Heap based on frequency
        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> count.get(a) - count.get(b)
        );

        // Keep only top k frequent elements
        for (int n : count.keySet()) {
            heap.add(n);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Store the answer
        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}