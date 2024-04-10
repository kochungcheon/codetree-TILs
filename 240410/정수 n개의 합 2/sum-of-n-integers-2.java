import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] prefix = new int[N+1];

        int ans = -101;

        for (int i=0; i<N; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }

        for (int i=K; i<=N; i++) {
            ans = Math.max(ans, prefix[i] - prefix[i-K]);
        }

    

        System.out.println(ans);

    }
}