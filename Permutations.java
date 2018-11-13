import java.util.List;
import java.util.ArrayList;

public class Permutations
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
        {
            return result;
        }

        List<Integer> currentNums = new ArrayList<>();
        permute(nums, currentNums, result);
        return result;
    }

    private void permute(int[] nums, List<Integer> curNums,
        List<List<Integer>> result)
    {
        if (curNums.size() == nums.length)
        {
            result.add(new ArrayList<Integer>(curNums));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (curNums.contains(nums[i]))
            {
                continue;
            }
            curNums.add(nums[i]);
            permute(nums, curNums, result);
            curNums.remove(curNums.size() - 1);
        }
    }
}
