import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[w] += candy; 
        }

        int[] prefix = new int[1000002];
        for (int i = 0; i <= 1000000; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int ans = 0;

        int R = 2 * M + 1;
        int L = 0;
        while (R < 1000002) { 
            if (prefix[R] - prefix[L] > ans) {
                ans = prefix[R] - prefix[L];
            }
            L++;
            R++;
        }
        System.out.println(ans);
    }
}