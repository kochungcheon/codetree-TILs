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

        int[] arr = new int[n];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] prefix = new int[n+1];
        for (int i=0; i<n; i++) {
            prefix[i+1] = prefix[i] + arr[i]; 
        }

        int cnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                if (prefix[j] - prefix[i] == k) {
                    cnt++;
                }
            }
        }               

        System.out.print(cnt);
    }
}