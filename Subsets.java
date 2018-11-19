import java.util.List;
import java.util.ArrayList;

public class Subsets
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
        {
            return result;
        }

        subsets(nums, new ArrayList<Integer>(), result, 0);
        return result;
    }

    private void subsets(int[] nums, List<Integer> curNums,
        List<List<Integer>> result, int depth)
    {
        if (depth == nums.length)
        {
            result.add(new ArrayList<Integer>(curNums));
            return;
        }

        subsets(nums, curNums, result, depth + 1);
        curNums.add(nums[depth]);
        subsets(nums, curNums, result, depth + 1);
        curNums.remove(curNums.size() - 1);
    }
}
