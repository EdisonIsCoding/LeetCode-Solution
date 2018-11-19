import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class SubsetsII
{
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
        {
            return result;
        }

        Arrays.sort(nums);
        boolean[] added = new boolean[nums.length];
        subsets(nums, new ArrayList<Integer>(), added, result, 0);
        return result;
    }

    private void subsets(int[] nums, List<Integer> curNums, boolean[] added,
        List<List<Integer>> result, int depth)
    {
        if (depth == nums.length)
        {
            result.add(new ArrayList<Integer>(curNums));
            return;
        }

        subsets(nums, curNums, added, result, depth + 1);
        if (depth > 0 && nums[depth] == nums[depth - 1] && !added[depth - 1])
        {
            return;
        }
        curNums.add(nums[depth]);
        added[depth] = true;
        subsets(nums, curNums, added, result, depth + 1);
        added[depth] = false;
        curNums.remove(curNums.size() - 1);
    }
}
