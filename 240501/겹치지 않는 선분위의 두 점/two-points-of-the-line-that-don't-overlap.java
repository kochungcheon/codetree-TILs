import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    static int N, M;
    static class Pair {
        long x;
        long y;
        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }
    }
    static Pair[] arr; 
    static long ans = 0;
    static boolean check(long target) {
        int cnt = 0;
        long start = -(long)1e18;

        for (int i=0; i<M; i++) {
            long x = arr[i].x;
            long y = arr[i].y;

            while(start + target <= y) {
                cnt++;
                start = Math.max(start + target, x);

                if (cnt >= N) break;
            }
        }
        return cnt >= N;
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Pair[M];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        Arrays.sort(arr, Comparator.comparingLong(Pair::getX));

        long s = 1;
        long e = Long.MAX_VALUE;

        while (e >= s) {
            long mid = s + (e - s) / 2;
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