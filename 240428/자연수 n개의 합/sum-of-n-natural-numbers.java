import java.util.*;
import java.io.*;
public class Main {
    static long s;
    static long ans = 0;
    static void choose(long perpose) {
        long s = 1;
        long e = Integer.MAX_VALUE;

        while (e >= s) {
            long mid = (s + e) / 2;
            if ((mid / 2) * (mid + 1)   <= perpose) {
                ans = Math.max(ans, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());
        choose(s);
        System.out.println(ans);
    }
}