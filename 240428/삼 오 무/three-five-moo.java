import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans = Integer.MAX_VALUE;
    static boolean check(int target) {
        return N <= target - target / 3 - target / 5 + target / 15;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int s = 1;
        int e = Integer.MAX_VALUE;
        
        while (e >= s) {
            int mid =  s + (e - s) / 2;

            if (check(mid)) {
                e = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                s = mid + 1;
            }
        }

        System.out.print(ans);
    }
}