import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[200010];

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken()) + 1;
            arr[s]++;
            arr[e]--;
        }

        int ans = 0;

        int[] prefix = new int[200010];
        for (int i=0; i<20001; i++) {
            prefix[i+1] = prefix[i] + arr[i+1];
            ans = Math.max(ans, prefix[i+1]);
        }
        
        System.out.println(ans);



    }
}