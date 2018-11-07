import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3)
        {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; (i < nums.length - 2) && (nums[i] <= 0); i++)
        {
            int target = -1 * nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while(lo < hi)
            {
                if (nums[lo] + nums[hi] < target)
                {
                    while (lo < hi && nums[lo] == nums[lo + 1])
                    {
                        lo++;
                    }
                    lo++;
                }
                else if (nums[lo] + nums[hi] > target)
                {
                    while (lo < hi && nums[hi] == nums[hi - 1])
                    {
                        hi--;
                    }
                    hi--;
                }
                else
                {
                    List<Integer> combo = new ArrayList<>();
                    combo.add(nums[i]);
                    combo.add(nums[lo]);
                    combo.add(nums[hi]);
                    result.add(combo);
                    while (lo < hi && nums[lo] == nums[lo + 1])
                    {
                        lo++;
                    }
                    lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1])
                    {
                        hi--;
                    }
                    hi--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
            {
                i++;
            }
        }
        return result;
    }
}
