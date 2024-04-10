import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] num = new int[1000001];
        
        for (int a : arr) {
            num[a]++;
        }

        int[] prefix = new int[1000002];
        for (int i=1; i<1000001; i++) {
            prefix[i] = num[i] + prefix[i-1];
        }

        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(prefix[e] - prefix[s-1]);
        }    
    }
}