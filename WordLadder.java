import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class WordLadder
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        if (wordList == null || wordList.size() == 0)
        {
            return 0;
        }

        if (beginWord == null || endWord == null ||
            beginWord.length() != endWord.length() || endWord.length() == 0)
        {
            return 0;
        }

        if (!wordList.contains(endWord))
        {
            return 0;
        }
        LinkedList<String> words = new LinkedList<>();
        LinkedList<Integer> dists = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        words.addLast(beginWord);
        dists.addLast(1);
        visited.add(beginWord);

        while (!words.isEmpty())
        {
            String curWord = words.removeFirst();
            int curDist = dists.removeFirst();

            for (int i = 0; i < curWord.length(); i++)
            {
                char[] newWordChar = curWord.toCharArray();
                for (int j = 'a'; j <= 'z'; j++)
                {
                    newWordChar[i] = (char) j;
                    String newWord = new String(newWordChar);
                    if (!visited.contains(newWord) && wordList.contains(newWord))
                    {
                        if (endWord.equals(newWord))
                        {
                            return curDist + 1;
                        }
                        words.addLast(newWord);
                        dists.addLast(curDist + 1);
                        visited.add(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
