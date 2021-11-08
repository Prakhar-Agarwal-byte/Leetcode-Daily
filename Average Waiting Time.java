class Solution {
    public double averageWaitingTime(int[][] customers) {
        long freeTime = 0;
        long totWait = 0;
        for (int i = 0; i < customers.length; i++) {
            long curWait = 0;
            if (freeTime > customers[i][0]) {
                curWait += freeTime-customers[i][0];
            }
            if (freeTime < customers[i][0]) {
                freeTime = customers[i][0];
            }
            curWait += customers[i][1];
            freeTime += customers[i][1];
            totWait += curWait;
        }
        return (double) totWait/customers.length;
    }
}
