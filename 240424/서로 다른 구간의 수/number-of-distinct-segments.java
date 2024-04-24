import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2배 해준다
        int[] arr = new int[200010];

        int start = Integer.MAX_VALUE;
        int end = 0;

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) * 2;
            int e = Integer.parseInt(st.nextToken()) * 2 + 1;

            start = Math.min(start, s);
            end = Math.max(end, e);

            arr[s]++;
            arr[e]--;
        }

        int[] prefix = new int[200010];
        for (int i=0; i<200009; i++) {
            prefix[i+1] = prefix[i] + arr[i+1];
        }

        int ans = 0;
        for (int i=start-1; i<=end; i++) {
            if (prefix[i] == 0 && prefix[i-1] != 0) {
                ans++;
            }
        }
        System.out.println(ans);

    }
}