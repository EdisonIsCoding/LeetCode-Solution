import java.util.Map;
import java.util.HashMap;

public class TwoSum
{
    public static int[] twoSum(int[] nums, int target)
    {
        if(nums == null || nums.length < 2)
        {
            return null;
        }

        int resultIndex[] = new int[2];
        Map<Integer, Integer> expectedNums = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(expectedNums.containsKey(target - nums[i]))
            {
                resultIndex[0] = expectedNums.get(target - nums[i]);
                resultIndex[1] = i;
                return resultIndex;
            }
            else
            {
                expectedNums.put(nums[i], i);
            }
        }

        return resultIndex;
    }

    public static void main(String[] args)
    {
        // Simple test case
        int testCase[] = new int[] {2, 7, 11, 15};
        int target = 9;
        int result[] = twoSum(testCase, target);
        if (result == null)
        {
            System.out.println("Not valid input");
        }
        else
        {
            System.out.println("[" + result[0] + ", " + result[1] + ']');
        }
    }
}
