import java.util.List;
import java.util.ArrayList;

public class PermutationsII
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
        {
            return result;
        }

        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permutations(nums, new ArrayList<Integer>(), result, used);
        return result;
    }

    private void permutations(int[] nums, List<Integer> curNums,
        List<List<Integer>> result, boolean[] used)
    {
        if (curNums.size() == nums.length)
        {
            result.add(new ArrayList<Integer>(curNums));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i-1])
            {
                continue;
            }
            curNums.add(nums[i]);
            used[i] = true;
            permutations(nums, curNums, result, used);
            curNums.remove(curNums.size() - 1);
            used[i] = false;
        }
    }
}
