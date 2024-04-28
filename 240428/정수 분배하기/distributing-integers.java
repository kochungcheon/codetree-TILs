import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean check(int target) {
        int val = 0;
        for (int a : arr) {
            val += a / target;
        }
        return val >= m;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n 개 정수를 분배해서
        n = Integer.parseInt(st.nextToken());
        // 같은 크기의 정수 k를 m개 만들려고 할 때
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int s = 1;
        int e = 100000;
        int ans = 0;

        while (e >= s) {
            int mid = (s + e) / 2;
            if (check(mid)) {
                s = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                 e = mid - 1;
            }
        }

        System.out.print(ans);
    }
}