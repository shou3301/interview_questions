public class DevuAndBeautifulSubstrings {
    private long res = 0;
    
    public long countBeautifulSubstrings(int n, int cnt) {
        if (n == 0 || cnt == 0) return 0;
        backtracking("", 0, 0, n, cnt);
        
        return res;
    }
    
    private void backtracking(String buffer, int last, int count, int n, int cnt) {
        if (buffer.length() == n) {
            if (count == cnt) res++;
            return;
        }
        
        if (count >= cnt) return;
        
        if (buffer.length() == 0) {
            backtracking("0", 1, 1, n, cnt);
            backtracking("1", 1, 1, n, cnt);
        } else {
            if (buffer.charAt(buffer.length() - 1) == '0') {
                backtracking(buffer + "0", 1, count + 1, n, cnt);
                backtracking(buffer + "1", last + 1, count + last + 1, n, cnt);
            } else {
                backtracking(buffer + "1", 1, count + 1, n, cnt);
                backtracking(buffer + "0", last + 1, count + last + 1, n, cnt);
            }
        }
    }
    
}