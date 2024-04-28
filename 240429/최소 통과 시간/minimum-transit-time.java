import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static long ans = Long.MAX_VALUE;
    static int[] arr;

    static boolean check(long target) {
        long cnt = 0;
        for (int a : arr) {
            cnt += target / a;
        }

        return n <= cnt;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 각 통로 통과하는 데 걸리는 시간
        arr = new int[m];

        for (int i=0; i<m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }        

        long s = 1;
        long e = Long.MAX_VALUE;

        while ( e >= s) {
            long mid = s + (e - s) / 2;
            if (check(mid)) {
                e = mid - 1;
                ans = Math.min(ans, mid);
            }

            else {
                s = mid + 1;
            }
        }

        System.out.println(ans);

    }
}