import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] count = new int[n+1];
        for (int i=0; i<b; i++) {
            count[Integer.parseInt(br.readLine())]--;
        }

        int[] prefix = new int[n+1];
        for (int i=0; i<n; i++) {
            prefix[i+1] = prefix[i] + count[i];
        }

        int ans = 100001;
        for (int i=k; i<=n; i++) {
            ans = Math.min(ans, -(prefix[i] - prefix[i-k]));
        }        

        System.out.print(ans);
    }
}