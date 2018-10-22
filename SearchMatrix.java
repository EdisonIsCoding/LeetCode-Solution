public class SearchMatrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int endIndex = rows * cols - 1;
        int startIndex = 0;
        int middleIndex, row, col;

        while(startIndex <= endIndex)
        {
            middleIndex = (startIndex + endIndex) / 2;
            row = middleIndex / cols;
            col = middleIndex % cols;

            if (startIndex == endIndex)
            {
                return matrix[row][col] == target;
            }

            if (matrix[row][col] < target)
            {
                startIndex = middleIndex + 1;
            }
            else if (matrix[row][col] > target)
            {
                endIndex = middleIndex - 1;
            }
            else
            {
                return true;
            }
        }

        return false;
    }
}