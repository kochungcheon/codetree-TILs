import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] one = new int[n];
        for (int i=0; i<n; i++) {
            if (arr[i] == 1) {
                one[i] = 1;
            }
        }
        int[] prefix = new int[n + 1];
        for (int i=0; i<n; i++) {
            prefix[i+1] = prefix[i] + one[i];
        }
        // for (int i=0; i<=n; i++) {
        //     System.out.print(prefix[i] + " ");
        // }
        // System.out.println();

        int L = 0;
        int R = 1;

        int ans = Integer.MAX_VALUE;
        while (R >= L && n > R) {
            int nowK = prefix[R] - prefix[L];
            if (nowK >= k) {
                ans = Math.min(ans, R - L);
            }
            if (nowK < k) {
                R++;
            } else {
                L++;
            }
        }

        if (R == n) {
            if (k == 1 && one[0] == 1) {
                ans = 1;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }
}