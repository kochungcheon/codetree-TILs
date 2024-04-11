import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] count = new int[100001];

        int ans = 0;
        int R = 0;
        int L = 0;

        while (R >= L && N > R) {
            count[arr[R]]++;
            while (count[arr[R]] == 2) {
                count[arr[L]]--;
                L++;
            }
            ans = Math.max(ans, R - L + 1);
            R++;
        }
        System.out.println(ans);

    }
}