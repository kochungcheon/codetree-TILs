import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int ans = 0;
    static int[] arr;
    static boolean check(int target) {
        int now = arr[0];
        int cnt = 1;
        for (int i=1; i<n; i++) {
            if (arr[i] - now >= target) {
                cnt++;
                now = arr[i];
            } 
        }
        return cnt >= m;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int s = 1;
        int e = 1000000000;

        while (e >= s) {
            int mid = s + (e - s) / 2;

            if (check(mid)) {
                s = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                e = mid - 1;
            }
        }
        System.out.println(ans);
    }
}