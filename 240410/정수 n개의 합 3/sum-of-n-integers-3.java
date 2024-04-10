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

        int[][] grid = new int[N][N];
        for (int i=0; i<N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] prefix = new int[N+1][N+1];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                prefix[i+1][j+1] = prefix[i+1][j] + prefix[i][j+1] - prefix[i][j] + grid[i][j]; 
            }
        }

        // for (int i=0; i<=N; i++) {
        //     for (int j=0; j<=N; j++) {
        //         System.out.print(prefix[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int ans = 0;

        for (int i=K; i<=N; i++) {
            for (int j=K; j<=N; j++) {
                ans = Math.max(ans, prefix[i][j] - prefix[i-K][j] - prefix[i][j-K] + prefix[i-K][j-K]);
            }
        }

        System.out.println(ans);
    }
}