import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;
        int R = 0;
        int L = 0;
        int tmp = 0;
        while (R >= L && n > R) {
            tmp += arr[R++];
            while (tmp > m) {
                tmp -= arr[L++];
            } 
            if (tmp == m) {
                    ans++;
            }
        }
        System.out.println(ans);
    }
}