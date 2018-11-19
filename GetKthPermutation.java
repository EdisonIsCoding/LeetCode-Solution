public class GetKthPermutation
{
    public String getPermutation(int n, int k)
    {
        if (n <= 0 || n > 9 || k <=0 || k > getMaxPossibility(n))
        {
            return "";
        }

        char[] digits = new char[n];
        for (int i = 0; i < digits.length; i++)
        {
            digits[i] = (char) ('1' + i);
        }

        for (int i = 1; i < k; i++)
        {
            getNextPermutation(digits);
        }

        return new String(digits);
    }

    private int getMaxPossibility(int n)
    {
        int max = 1;
        for (int i = 1; i <= n; i++)
        {
            max *= i;
        }
        return max;
    }

    private void getNextPermutation(char[] digits)
    {
        int pivot = -1;
        for (int i = digits.length - 1; i > 0; i--)
        {
            if (digits[i - 1] < digits[i])
            {
                pivot = i - 1;
                break;
            }
        }

        if (pivot >= 0)
        {
            int swapIndex = 0;
            for (int i = digits.length - 1; i > pivot; i--)
            {
                if(digits[i] > digits[pivot])
                {
                    swapIndex = i;
                    break;
                }
            }
            swap(digits, pivot, swapIndex);
        }
        reverse(digits, pivot + 1);
    }

    private void swap(char[] digits, int i, int j)
    {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private void reverse(char[] digits, int startIndex)
    {
        int i = startIndex;
        int j = digits.length - 1;
        while(i < j)
        {
            swap(digits, i, j);
            i++;
            j--;
        }
    }
}
