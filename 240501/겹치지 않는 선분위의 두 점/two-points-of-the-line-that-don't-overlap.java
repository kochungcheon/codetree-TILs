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
    int placedPoints = 0; 
    long lastPosition = -Long.MAX_VALUE; 

    for (int i = 0; i < M; i++) {
        long start = arr[i].x;
        long end = arr[i].y;
        
        long firstPossiblePosition = Math.max(start, lastPosition + target);

        if (firstPossiblePosition <= end) {
            long positions = 1 + (end - firstPossiblePosition) / target;
            placedPoints += positions;
            lastPosition = firstPossiblePosition + (positions - 1) * target;
            if (placedPoints >= N) {
                return true;
            }
        }
    }
    
    return false;
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