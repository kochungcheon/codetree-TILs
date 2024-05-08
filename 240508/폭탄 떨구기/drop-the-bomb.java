import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Main {
    static int N, K;
    static int[] arr;
    static boolean check(int target) {
        int cnt = 1;
        int compare = arr[0];
        for (int a : arr) {
            if (a - compare > target * 2) {
                cnt++;
                compare = a;
            }
        }
        return K >= cnt;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 점 개수
        N = Integer.parseInt(st.nextToken());
        // 폭탄 개수
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int ans = 1000000000;

        int s = 0;
        int e = 1000000000;

        while (e >= s) {
            int mid = s + (e - s) / 2;
            if (check(mid)) {
                ans = Math.min(ans, mid);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(ans);
    }
}