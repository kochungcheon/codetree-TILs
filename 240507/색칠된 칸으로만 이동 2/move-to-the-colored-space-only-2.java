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
    static int N, M;
    static int[][] grid;
    static int[][] color;
    static List<Pair> pairs = new ArrayList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;

    static boolean canGo(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static boolean check(int target) {
        visit = new boolean[N][M];
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(pairs.get(0).x, pairs.get(0).y));

        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (!canGo(nx, ny)) continue;
                if (visit[nx][ny]) continue;
                if (Math.abs(grid[now.x][now.y] - grid[nx][ny]) > target) continue;
                visit[nx][ny] = true;
                q.add(new Pair(nx, ny));
            }
        }

        for (Pair pair : pairs) {
            if (!visit[pair.x][pair.y]) return false;
        }
        return true;
    }

    static void findStart() {
        boolean flag = false;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (color[i][j] == 1) {
                    pairs.add(new Pair(i, j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        color = new int[N][M];

        for (int i=0; i<N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i=0; i<N; i++) {
            color[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        findStart();

        int s = 0;
        int e = 1_000_000_000;

        int ans = 1_000_000_000;

        while (e >= s) {
            int mid = s + (e - s) / 2;
            if (check(mid)) {
                e = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                s = mid + 1;
            }
        }
        
        System.out.println(ans);
    }
}

// 상하좌우만 이동 가능
// D 이하 차이만 이동 가능
//