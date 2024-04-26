import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Main {
    static int n, m;
    static int[] arr;

    static int lb(int target) {
        int s = 0; int e = n-1;
        int idx = n;
        while (e >= s) {
            int mid = (s + e) / 2;
            if (arr[mid] >= target) {
                idx = Math.min(mid, idx);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }

    static int ub(int target) {
        int s = 0; int e = n-1;
        int idx = n;
        while (e >= s) {
            int mid = (s+e) / 2;
            if (arr[mid] > target) {
                idx = Math.min(mid, idx);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 

        for (int i=0; i<m; i++) {
            int t = Integer.parseInt(br.readLine());
            System.out.println(ub(t) - lb(t));
        }
    }
}