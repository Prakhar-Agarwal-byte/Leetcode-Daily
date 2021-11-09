import java.util.*;

class Solution {
  public int longestBeautifulSubstring(String word) {
    HashSet<Character> set = new HashSet<>();
    int maxLen = 0;
    int i = word.indexOf("a"), j = i;
    if (i < 0)
      return maxLen;
    while (j < word.length()) {
      set.add(word.charAt(j));
      if (set.size() == 5) {
        maxLen = Math.max(maxLen, j - i + 1);
      }
      if (isValid(j, word)) {
        j++;
      } else {
        i = word.indexOf("a", j+1);
        if (i < 0)
          return maxLen;
        j = i;
        set.clear();
      }
    }
    if (set.size() == 5) {
        return j-i;
    } else return maxLen;
    
  }

  private boolean isValid(int j, String word) {
      if (j == word.length()-1) return true;
    if (word.charAt(j) == 'a' && (word.charAt(j + 1) == 'e' || word.charAt(j + 1) == 'a'))
      return true;
    if (word.charAt(j) == 'e' && (word.charAt(j + 1) == 'i' || word.charAt(j + 1) == 'e'))
      return true;
    if (word.charAt(j) == 'i' && (word.charAt(j + 1) == 'o' || word.charAt(j + 1) == 'i'))
      return true;
    if (word.charAt(j) == 'o' && (word.charAt(j + 1) == 'u' || word.charAt(j + 1) == 'o'))
      return true;
    if (word.charAt(j) == 'u' && word.charAt(j + 1) == 'u')
      return true;
    return false;
  }
}
