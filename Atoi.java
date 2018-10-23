public class Atoi
{
    public int atoi(String str)
    {
        // input validation
        if (str == null || str.length() <= 0)
        {
            return 0;
        }

        char[] chars = str.toCharArray();
        int curIndex = 0;
        int result = 0;
        boolean isNegative = false;
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;

        // find first character which is not a white space
        while(chars[curIndex] == ' ')
        {
            if (curIndex >= chars.length - 1)
            {
                return 0;
            }
            curIndex++;
        }

        if (chars[curIndex] == '-')
        {
            isNegative = true;
            curIndex++;
        }
        else if (chars[curIndex] == '+')
        {
            curIndex++;
        }

        for (int i = curIndex; i < chars.length; i++)
        {
            if (chars[i] < '0' || chars[i] > '9')
            {
                break;
            }

            if (!isNegative)
            {
                if (result > MAX / 10)
                {
                    result = MAX;
                    break;
                }
                else if (result == MAX / 10 && chars[i] > '7')
                {
                    result = MAX;
                    break;
                }
                else
                {
                    result = result * 10 + chars[i] - '0';
                }
            }
            else
            {
                if (result > MAX / 10)
                {
                    result = MIN;
                    isNegative = false;
                    break;
                }
                else if (result == MAX / 10 && chars[i] > '8')
                {
                    result = MIN;
                    isNegative = false;
                    break;
                }
                else
                {
                    result = result * 10 + chars[i] - '0';
                }
            }
        }

        if (isNegative)
        {
            result *= -1;
        }

        return result;
    }
}