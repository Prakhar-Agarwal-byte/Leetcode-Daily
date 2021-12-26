class Solution {
  public String gcdOfStrings(String str1, String str2) {
    int max = 0;
    for (int i = 0 ; i < Math.min(str1.length(), str2.length()); i++) {
      if (str1.charAt(i) != str2.charAt(i)) return "";
      if (str1.length() % (i+1) == 0 && str2.length() % (i+1) == 0) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int n1 = str1.length() / (i+1);
        int n2 = str2.length() / (i+1);
        String s = str1.substring(0, i+1);
        while (n1-- > 0) {
          sb1.append(s);
        }
        while (n2-- > 0) {
          sb2.append(s);
        }
        if (sb1.toString().equals(str1) && sb2.toString().equals(str2)) {
          max = i+1;
        }
      }
    }
    return str1.substring(0, max);
  }
}