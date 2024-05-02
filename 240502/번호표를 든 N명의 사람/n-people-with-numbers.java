import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    static int n, tMax;
    static int[] arr;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람 수
        n = Integer.parseInt(st.nextToken());
        // 걸리는 최대 시간
        tMax = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        for (int k=n; k>=1; k--) {
            int time = 0;
            int mt = 0;
            pq = new PriorityQueue<>();
            for (int i=0; i<k; i++) {
                pq.add(time + arr[i]);
                mt = Math.max(time + arr[i], mt);
            }
            // 남은 친구들 처리
            for (int i=k; i<n; i++) {
                int now = pq.poll();
                time = now;
                pq.add(time + arr[i]);
                mt = Math.max(time + arr[i], mt);
            }

            if (mt <= tMax) {
                ans = k;
            } 
            else {
                break;
            }
        }

        System.out.println(ans);
    }
}