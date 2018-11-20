import java.util.List;
import java.util.ArrayList;

public class PalindromePartition
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0)
        {
            return result;
        }

        char[] chars = s.toCharArray();
        List<String> partition = new ArrayList<>();
        partition(chars, 0, partition, result);
        return result;
    }

    private void partition(char[] chars, int start, List<String> partition,
        List<List<String>> result)
    {
        if (start >= chars.length)
        {
            result.add(new ArrayList<String>(partition));
            return;
        }

        for (int offset = 0; offset < chars.length - start; offset++)
        {
            if (isPalindrome(chars, start, offset))
            {
                partition.add(new String(chars, start, offset + 1));
                partition(chars, start + offset + 1, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(char[] chars, int start, int offset)
    {
        int i = start;
        int j = start + offset;
        while(i < j)
        {
            if (chars[i] != chars[j])
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
