import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class WordLadderII
{
    public List<List<String>> ladderLength(String beginWord, String endWord,
        List<String> wordList)
    {
        List<List<String>> result = new LinkedList<>();
        if (wordList == null || wordList.size() == 0)
        {
            return result;
        }

        if (beginWord == null || endWord == null ||
            beginWord.length() != endWord.length() || endWord.length() == 0)
        {
            return result;
        }

        if (!wordList.contains(endWord))
        {
            return result;
        }

        int shortestLength = BFS(beginWord, endWord,  wordList);
        if (shortestLength == 0)
        {
            return result;
        }
        List<String> curPath = new LinkedList<>();
        curPath.add(beginWord);
        DFS(beginWord, endWord, wordList, shortestLength, curPath, result);
        return result;
    }

    private void DFS(String curWord, String endWord, List<String> wordList,
        int shortestLength, List<String> curPath, List<List<String>> result)
    {
        if (curWord.equals(endWord))
        {
            result.add(new LinkedList<String>(curPath));
            return;
        }

        if (curPath.size() >= shortestLength)
        {
            return;
        }

        char[] curWordChar = curWord.toCharArray();
        for (int i = 0; i < curWord.length(); i++)
        {
            char oldChar = curWordChar[i];
            for (int j = 'a'; j <= 'z'; j++)
            {
                curWordChar[i] = (char) j;
                String newWord = new String(curWordChar);
                if (wordList.contains(newWord))
                {
                    wordList.remove(newWord);
                    curPath.add(newWord);
                    DFS(newWord, endWord, wordList, shortestLength, curPath, result);
                    curPath.remove(curPath.size() - 1);
                    wordList.add(newWord);
                }
            }
            curWordChar[i] = oldChar;
        }
    }

    private int BFS(String beginWord, String endWord, List<String> wordList)
    {
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
