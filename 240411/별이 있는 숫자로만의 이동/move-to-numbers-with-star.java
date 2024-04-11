import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] grid;
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                findMaxSum(i, j);
            }
        }

        System.out.println(maxSum);
    }

    static void findMaxSum(int x, int y) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0}); // {x, y, steps}
        visited.add(x + "," + y);

        int sum = grid[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int steps = current[2];

            if (steps == K) continue;

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : directions) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited.contains(nx + "," + ny)) {
                    visited.add(nx + "," + ny);
                    sum += grid[nx][ny];
                    queue.add(new int[]{nx, ny, steps + 1});
                }
            }
        }

        maxSum = Math.max(maxSum, sum);
    }
}