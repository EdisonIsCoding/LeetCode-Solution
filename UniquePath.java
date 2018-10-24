public class UniquePath
{
    public int uniquePaths(final int m, final int n)
    {
        int[] sum = new int[m];
        for (int i = 0; i < m; i++)
        {
            sum[i] = 1;
        }
        for (int i = 2; i <= n; i++)
        {
            for (int j = 1; j < m; j++)
            {
                sum[j] = sum[j] + sum[j - 1];
            }
        }
        return sum[m - 1];
    }
}