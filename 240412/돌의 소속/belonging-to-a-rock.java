import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] one = new int[N];
        int[] two = new int[N];
        int[] three = new int[N];

        for (int i=0; i<N; i++) {
            int com = Integer.parseInt(br.readLine());
            if (com == 1) {
                one[i]++;
            } else if (com == 2) {
                two[i]++;
            } else {
                three[i]++;
            }
        }

        int[] prefixone = new int[N+1];
        int[] prefixtwo = new int[N+1];
        int[] prefixthree = new int[N+1];
        for (int i=0; i<N; i++) {
            prefixone[i+1] = prefixone[i] + one[i];
            prefixtwo[i+1] = prefixtwo[i] + two[i];
            prefixthree[i+1] = prefixthree[i] + three[i];
        }

        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken());

            int o = prefixone[e] - prefixone[s];
            int t = prefixtwo[e] - prefixtwo[s];
            int th = prefixthree[e] - prefixthree[s];
            System.out.println(o + " " + t + " " + th);
        }
    }
}