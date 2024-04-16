import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int x;
        int y;
        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static Pair[] checkpointers;
    static int[] L;
    static int[] R;

    public static void main(String[] args) throws IOException {
        input();
        setLR();
        System.out.println(calAns());
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        checkpointers = new Pair[N];

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            checkpointers[i] = new Pair(x, y);
        }
    }

    static void setLR() {
        L = new int[N];
        R = new int[N];

        for (int i=0; i<N - 1; i++) {
            L[i+1] = L[i] + Math.abs(calTaxiDis(i, i+1));
        }

        for (int i=N-2; i >= 0; i--) {
            R[i] = R[i+1] + Math.abs(calTaxiDis(i, i+1));
        }
    }

    static int calTaxiDis(int a, int b) {
        return Math.abs(checkpointers[a].x - checkpointers[b].x) + Math.abs(checkpointers[a].y - checkpointers[b].y); 
    }

    static int calAns() {
        int ans = Integer.MAX_VALUE;
        for (int i=1; i<N-1; i++) {
            ans = Math.min(ans,
                L[i-1] + R[i+1] + calTaxiDis(i-1, i+1)
            );
        }
        return ans;
    }
}