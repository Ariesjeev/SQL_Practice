class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     int maxLeft = Integer.MIN_VALUE;
        //     // find Max from 0 to i
        //     for(int j = 0;j<=i;j++){
        //         maxLeft = Math.max(maxLeft,nums[j]);
        //     }
        //     int minRight = Integer.MAX_VALUE;
        //     // find Max from i to n-1
        //     for(int j = i;j<n;j++){
        //         minRight = Math.min(minRight,nums[j]);
        //     }
        //     int instability = maxLeft - minRight;
        //     if(instability<=k){
        //         return i;
        //     }
        // }
        // return -1;

        //Optimal Soln

        int n = nums.length;
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            int instability = prefixMax - suffixMin[i];
            if (instability <= k) {
                return i;
            }
        }
        return -1;
    }
}