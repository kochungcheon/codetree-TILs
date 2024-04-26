import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    static long m; 
    static int a, b;
    static int find(long target) {
        int cnt = 0;
        long s = 1; long e = m;
        
        while (e >= s) {
            cnt++;
            long mid = (s + e) / 2;
            if (mid == target) {
                return cnt;
            }
            if (mid > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int ansMax = -1;
        int ansMin = 100;
        for (long i=a; i<=b; i++) {
            int cnt = find(i);
            ansMin = Math.min(ansMin, cnt);
            ansMax = Math.max(ansMax, cnt);
        }
        System.out.println(ansMin + " " + ansMax);
    }
}