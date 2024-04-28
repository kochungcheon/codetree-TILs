import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int ans = Integer.MAX_VALUE;
    static boolean check(int target) {
        int val = 0;
        for (int i=1; i<=N; i++) {
            int tmp = target / i;
            if (tmp == 0) break;
            val += Math.min(tmp, N);
        }
        return K <= val;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        
        int s = 1;
        int e = 1000000000;

        while (e >= s) {
            int mid = s + (e - s) / 2;

            if (check(mid)) {
                e = mid - 1;
                ans = Math.min(mid, ans);
            }
            
            else {
                s = mid + 1;
            }
        }

        System.out.println(ans);
    }
}