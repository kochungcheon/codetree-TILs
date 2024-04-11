import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = n+1;

        int R = -1;
        int cnt = 0;

        for (int L=0; L<n; L++) {
            while (R + 1 < n && cnt < s) {
                R++;
                cnt += arr[R];
            }

            if (cnt >= s) {
                ans = Math.min(ans, R - L + 1);
            }
            cnt -= arr[L];
        }
        if (ans == n+1) {
            System.out.println(-1); 
        } else {
            System.out.println(ans);
        }
    }
}