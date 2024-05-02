import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    static int n, tMax;
    static int[] arr;

    static boolean check(int target) {
        int time = 0;
        int mt = 0;
        // target 만큼 큐에 넣기 time + di 를 기준으로 넣자
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<target; i++) {
            pq.add(time + arr[i]);
            mt = Math.max(time + arr[i], mt);
        }
        // 남은 친구들 처리
        for (int i=target; i<n; i++) {
            int now = pq.poll();
            time = now;
            pq.add(time + arr[i]);
            mt = Math.max(time + arr[i], mt);
        }

        return mt <= tMax;
    }
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

        int s = 1;
        int e = n;
        int ans = 10000;
        while (e >= s) {
            int mid = (s + e) / 2;
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