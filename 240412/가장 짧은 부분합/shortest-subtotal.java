import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int n = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = n+1;

        int total = 0;

        int s = 0;
        int e = 0;
        while (n > s && s >= e) {
            total += arr[s];
            while (total >= S) {
                ans = Math.min(s - e + 1, ans);
                e++;
                total -= arr[e];
            }
            s++;
        }
        if (ans == n+1) {
            System.out.println(-1); 
        } else {
            System.out.println(ans);
        }
    }
}