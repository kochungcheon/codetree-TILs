import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[4000001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[w] += candy; 
        }

        int[] prefix = new int[4000002];
        for (int i = 0; i < 4000001; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int ans = 0;

        int R = 2 * K + 1;
        int L = 0;
        while (R < 4000001) { 
            if (prefix[R] - prefix[L] > ans) {
                ans = prefix[R] - prefix[L];
            }
            L++;
            R++;
        }
        System.out.println(ans);
    }
}