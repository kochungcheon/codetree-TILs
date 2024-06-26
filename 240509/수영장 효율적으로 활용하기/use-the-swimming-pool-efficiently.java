import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean check(int target) {
        int cnt = 1;
        int box = 0;
        for (int i=0; i<N; i++) {
            if (arr[i] > target) return false;
            if (box + arr[i] > target) {
                cnt++;
                box = 0;
            }
            box += arr[i];
        }
        return cnt <= M;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람 수
        N = Integer.parseInt(st.nextToken());
        // 레인 수
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s = 0;
        int e = Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;
        while ( e >= s) {
            int mid = s + (e - s) / 2;
            if (check(mid)) {
                e = mid - 1;
                ans = Math.min(ans, mid);;
            }
            else {
                s = mid + 1;
            }
        }

        System.out.println(ans);
    }
}