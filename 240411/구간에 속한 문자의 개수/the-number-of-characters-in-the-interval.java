import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] grid = new String[n];
        int[][] agrid = new int[n][m];
        int[][] bgrid = new int[n][m];
        int[][] cgrid = new int[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine();
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == 'a') {
                    agrid[i][j] = 1;
                } else if (grid[i].charAt(j) == 'b') {
                    bgrid[i][j] = 1;
                } else if (grid[i].charAt(j) == 'c') {
                    cgrid[i][j] = 1;
                }
            }
        }

        int[][] prefixa = new int[n + 1][m + 1];
        int[][] prefixb = new int[n + 1][m + 1];
        int[][] prefixc = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixa[i + 1][j + 1] = prefixa[i + 1][j] + prefixa[i][j + 1] - prefixa[i][j] + agrid[i][j];
                prefixb[i + 1][j + 1] = prefixb[i + 1][j] + prefixb[i][j + 1] - prefixb[i][j] + bgrid[i][j];
                prefixc[i + 1][j + 1] = prefixc[i + 1][j] + prefixc[i][j + 1] - prefixc[i][j] + cgrid[i][j];
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int acnt = prefixa[r2][c2] - prefixa[r2][c1] - prefixa[r1][c2] + prefixa[r1][c1];
            int bcnt = prefixb[r2][c2] - prefixb[r2][c1] - prefixb[r1][c2] + prefixb[r1][c1];
            int ccnt = prefixc[r2][c2] - prefixc[r2][c1] - prefixc[r1][c2] + prefixc[r1][c1];

            System.out.println(acnt + " " + bcnt + " " + ccnt);
        }
    }
}