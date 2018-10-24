public class UniquePathII
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        if (obstacleGrid == null || obstacleGrid.length == 0
            || obstacleGrid[0].length == 0)
        {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows -1][cols - 1] == 1)
        {
            return 0;
        }
        if (rows == 1 && cols == 1)
        {
            return 1;
        }

        int[][] pathSum = new int[rows + 1][cols + 1];
        // Since we check there is no obstacle in bottom-right corner,
        // we can set the path to the virtual point behind it 1.
        pathSum[rows][cols - 1] = 1;
        for (int i = rows - 1; i >= 0; i--)
        {
            for (int j = cols - 1; j >= 0; j--)
            {
                if (obstacleGrid[i][j] == 1)
                {
                    pathSum[i][j] = 0;
                }
                else
                {
                    pathSum[i][j] = pathSum[i+1][j] + pathSum[i][j+1];
                }
            }
        }

        return pathSum[0][0];
    }
}
