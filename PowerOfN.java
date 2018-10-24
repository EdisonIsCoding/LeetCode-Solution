public class PowerOfN
{
    public double power(final double x, final int n)
    {
        if (n == 0)
        {
            return 1.0;
        }

        double e = 0.00000001;
        boolean isNegativePow = false;
        double result = 0.0;

        if (n < 0)
        {
            if (x > -1 * e && x < e)
            {
                // x is zero
                return 0.0;
            }
            else
            {
                isNegativePow = true;
            }
        }

        if (isNegativePow)
        {
            result = 1 / x * positivePower(1 / x, - 1 * (n + 1));
        }
        else
        {
            result = positivePower(x, n);
        }

        return result;
    }

    private double positivePower(final double x, final int n)
    {
        if (n == 0)
        {
            return 1;
        }

        double result = 1.0;
        result = positivePower(x, n >> 1);
        result *= result;
        if (n % 2 == 1)
        {
            result *= x;
        }
        return result;
    }
}
