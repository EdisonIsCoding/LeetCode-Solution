import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class CombinationSum
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target < 0)
        {
            return result;
        }

        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        combinationSum(candidates, target, combination, result, 0);
        return result;
    }

    private void combinationSum(int[] candidates, int target, List<Integer> combination,
        List<List<Integer>> result, int start)
    {
        if (target == 0)
        {
            result.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++)
        {
            if (candidates[i] > target)
            {
                break;
            }

            combination.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], combination, result, i);
            combination.remove(combination.size() - 1);
        }
    }
}
