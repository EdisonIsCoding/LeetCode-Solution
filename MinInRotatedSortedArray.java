public class MinInRotatedSortedArray
{
    public int findMin(final int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return Integer.MAX_VALUE;
        }

        if (nums.length == 1)
        {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        int middle = start;
        while(nums[start] >= nums[end])
        {
            if (end - start == 1)
            {
                middle = end;
                break;
            }

            middle = (start + end) / 2;
            if (nums[middle] == nums[start] && nums[middle] == nums[end])
            {
                return minInOrder(nums, start, end);
            }

            if (nums[middle] >= nums[start])
            {
                start = middle;
            }
            else if (nums[middle] <= nums[end])
            {
                end = middle;
            }
        }

        return nums[middle];
    }

    private int minInOrder(final int[] nums, final int start, final int end)
    {
        int min = nums[start];
        for (int i = start; i <= end; i++)
        {
            if (nums[i] < min)
            {
                min = nums[i];
            }
        }
        return min;
    }
}
