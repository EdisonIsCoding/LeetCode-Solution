public class RegularExpressionMatch
{
    public boolean isMatch(String s, String p)
    {
        if (s == null || p == null)
        {
            return false;
        }

        if (s.length() == 0 && p.length() == 0)
        {
            return true;
        }

        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean isMatch(char[] s, int indexS, char[] p, int indexP)
    {
        if (indexS == s.length && indexP == p.length)
        {
            return true;
        }
        if (indexS != s.length && indexP == p.length)
        {
            return false;
        }

        if (indexP + 1 < p.length && p[indexP + 1] == '*')
        {
            if (indexS != s.length && (p[indexP] == '.' || p[indexP] == s[indexS]))
            {
                return isMatch(s, indexS + 1, p, indexP)      // not match current digit
                    || isMatch(s, indexS, p, indexP + 2)      // skip .* pattern
                    || isMatch(s, indexS + 1, p, indexP + 2); // match one digit and skip .*
            }
            else
            {
                return isMatch(s, indexS, p, indexP + 2);
            }
        }

        if (indexS != s.length && (p[indexP] == s[indexS] || p[indexP] == '.'))
        {
            return isMatch(s, indexS + 1, p, indexP + 1);
        }

        return false;
    }
}
