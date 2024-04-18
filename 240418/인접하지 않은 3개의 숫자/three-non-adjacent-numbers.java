import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] L;
    static int[] R;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        input();
        calAns();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        L = new int[N];
        L[0] = arr[0];
        for (int i=1; i<N; i++) {
            L[i] = Math.max(L[i-1], arr[i]);
        }
        
        R = new int[N];
        R[N-1] = arr[N-1];
        for (int i=N-2; i >=0; i--) {
            R[i] = Math.max(R[i+1], arr[i]);
        }
    }

    static void calAns() {
        int ans = 0;
        for (int i=2; i<N-2; i++) {
            ans = Math.max(ans, L[i-2] + arr[i] + R[i+2]);
        }
        System.out.println(ans);
    }
}