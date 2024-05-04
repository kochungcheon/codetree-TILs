import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] grid;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    static boolean canGo(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }
    static boolean check(int target) {
        int totalCnt = 0;
        int tmpCnt = 0;
        visit = new boolean[N][N];
        int limit = (N * N + 1) / 2;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (visit[i][j]) continue;
                if (totalCnt >= limit) return false;
                tmpCnt += BFS(i, j, target);
                if (tmpCnt >= limit) return true;
                totalCnt += tmpCnt;
                tmpCnt = 0;
            }
        }
        return false;
    }
    static int BFS(int x, int y, int dis) {
        int cnt = 1;
        visit[x][y] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));
        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (!canGo(nx, ny)) continue;
                if (visit[nx][ny]) continue;
                if (Math.abs(grid[nx][ny] - grid[now.x][now.y]) > dis) continue;
                visit[nx][ny] = true;
                cnt++;
                q.add(new Pair(nx, ny));
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        
        for (int i=0; i<N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int ans = 1000000;
        int s = 0;
        int e = 1000000;

        
        while ( e >= s) {
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

// 100