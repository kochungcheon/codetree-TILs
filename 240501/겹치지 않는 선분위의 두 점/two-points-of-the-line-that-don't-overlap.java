import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long[] arrX;
    static long[] arrY;
    static long ans = 0;
    static boolean check(long target) {
    int placedPoints = 0; 
    long lastPosition = -Long.MAX_VALUE; 

    for (int i = 0; i < M; i++) {
        long start = arrX[i];
        long end = arrY[i];
        
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

        arrX = new long[M];
        arrY = new long[M];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            arrX[i] = Long.parseLong(st.nextToken());
            arrY[i] = Long.parseLong(st.nextToken());
        }

        long s = 0;
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