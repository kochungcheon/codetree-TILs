import java.util.*;
import java.io.*;
public class Main {
    static int n, q;
    static int[] arr;
    static int[] L, R;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        q = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        L = new int[q];
        R = new int[q];

        L[0] = arr[0];
        R[q - 1] = arr[q-1];
        for (int i=1; i<n; i++){
            L[i] = Math.max(L[i-1], arr[i]);
            R[q-i-1] = Math.max(arr[q-i-1], R[q - i]); 
        }

        for (int i=0; i<n; i++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            System.out.println(Math.max(L[s-1], R[e+1]));
        }
    }
}