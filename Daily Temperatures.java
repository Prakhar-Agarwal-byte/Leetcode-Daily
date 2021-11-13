import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] arr = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            if (st.isEmpty()) arr[i] = 0;
            else if (T[st.peek()] > T[i]) arr[i] = st.peek() - i;
            else {
                while (!st.isEmpty() && T[st.peek()] <= T[i]) {
                    st.pop();
                }
                if (st.isEmpty()) arr[i] = 0;
                else arr[i] = st.peek() - i;
            }
            st.push(i);
        }
        return arr;
    }
}
