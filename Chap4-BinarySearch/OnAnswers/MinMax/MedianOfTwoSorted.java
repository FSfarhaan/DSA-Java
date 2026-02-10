class MedianOfTwoSorted  {

    // Brute Force (TC ->  n1 + n2, SC -> n1 + n2);
    static double getMedian(int nums1[], int nums2[]) {
        int n1 = nums1.length, n2 = nums2.length;
        int arr3[] = new int[n1+n2];
        int left = 0, right = 0, i = 0;

        while (left < n1 && right < n2) {
            if(nums1[left] <= nums2[right]) {
                arr3[i++] = nums1[left++];
            } else {
                arr3[i++] = nums2[right++];
            }
        }

        while (left < n1) {
            arr3[i++] = nums1[left++];
        }
        while (right < n2) {
            arr3[i++] = nums2[right++];
        }

        int n3 = arr3.length; 

        if(n3 % 2 == 1) {
            return arr3[n3 / 2];
        } else {
            int el1 = arr3[n3 / 2];
            int el2 = arr3[n3/2 -1];
            return (el1 + el2) / 2.0;
        }
    }

    // Better Approach (TC -> n1 + n2, SC -> 1)
    // Basically we dont need the extra space to store the elements, we just need indexes, so why to store an entire array.
    static double BetGetMedian(int nums1[], int nums2[]) {
        int n1 = nums1.length, n2 = nums2.length, n = n1 + n2;
        int index = 0;
        int ele1 = -1, ele2 = -1;

        int ind1 = n / 2;
        int ind2 = ind1 - 1;
        int left = 0, right = 0;

        while (left < n1 && right < n2) {
            if(nums1[left] <= nums2[right]) {
                if(index == ind2) ele2 = nums1[left];
                if(index == ind1) ele1 = nums1[left];
                left++;
            } else {
                if(index == ind2) ele2 = nums2[right];
                if(index == ind1) ele1 = nums2[right];
                right++;
            }
            index++;
        }

        while (left < n1) {
            if(index == ind2) ele2 = nums1[left];
            if(index == ind1) ele1 = nums1[left];
            left++;
            index++;
        }

        while (right < n2) {
            if(index == ind2) ele2 = nums2[right];
            if(index == ind1) ele1 = nums2[right];
            right++;
            index++;
        }

        if(n % 2 == 1) return (double) ele1;
        else return (ele1 + ele2) / 2.0;
    }

    // Optimal Approach - Wrong mistake by me.
    static double OptGetMedian(int nums1[], int nums2[]) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) return OptGetMedian(nums2, nums1);
        int l1 = Integer.MAX_VALUE, l2 = Integer.MAX_VALUE;
        int r1 = Integer.MIN_VALUE, r2 = Integer.MIN_VALUE;

        int low = 0, high = n1 - 1;
        // int index = 0;
        while (low < high && low >= 0 && high + 1 <= n1) {
            l1 = nums1[low];
            l2 = nums2[high - low - 1];
            r1 = nums1[low + 1];
            r2 = nums2[high - low];
            System.out.println(l1);
            System.out.println(l2);
            System.out.println(r1);
            System.out.println(r2);
            low++;
            if(l1 < r2 && l2 < r1) {

                if((n1 + n2) % 2 == 0) return (l2 + r1) /2.0;
                else return Math.max(r1, l2);
            } 
        }
        // For low = 0
        //    1 | 3
        // 2, 4 | 6

        // Expected
        // 1, 3 |
        //    2 | 4, 6
        return 1.0;
    }

    static double OptGetMedian2(int nums1[], int nums2[]) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) return OptGetMedian2(nums2, nums1);
        int low = 0, high = n1;

        while (low <= high) {
            // Get the cut elements into left side for nums1
            int cut1 = low + (high - low) /  2;
            // Give the remaining to nums2 into left side
            int cut2 = (n1 + n2 + 1) / 2  - cut1;


            // Handling edge cases
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE: nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            // Check Partition valid
            if(l1 <= r2 && l2 <= r1) {
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else  return Math.max(l1, l2);
            }

            // Not Valid, so trimming is necessary
            else if(l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int nums2[] = {1, 2};
        int nums1[] = {3, 4};
        // 1, 2, 3, 4, 5, 6

        //    1 | 3, 5
        // 2, 4 | 6

        // 1, 3, 5 | 
        //         | 4, 5, 6

        //    2 | 4, 6
        // 1, 3 | 

        // System.out.println("The answer is: " + getMedian(nums1, nums2));
        // System.out.println("The answer is: " + BetGetMedian(nums1, nums2));
        // System.out.println("The answer is: " + OptGetMedian(nums1, nums2));
        System.out.println("The answer is: " + OptGetMedian2(nums1, nums2));
    }
}