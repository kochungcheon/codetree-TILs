import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static int N;
    
    static class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    
    static List<Pair> arr = new ArrayList<>();

    static int[] R;
    static int[] L;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        L = new int[N];
        R = new int[N];
    

        arr.stream()
                 .sorted(Comparator.comparingInt((Pair p) -> p.x)
                                     .thenComparingInt(p -> p.y))
                 .collect(Collectors.toList());

        L[0] = arr.get(0).y;
        R[N-1] = arr.get(N-1).y;

        for (int i=1; i<N; i++) {
            L[i] = Math.max(arr.get(i).y, L[i-1]);
            R[N-i-1] = Math.min(R[N-i], arr.get(N-1-i).y);
        }

        int ans = 0;

        for (int i=0; i<N; i++) {
            if (R[i] >= L[i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}