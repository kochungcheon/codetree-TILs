import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Main {
    static class Pair {
        int s;
        int e;
        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
        public int getX() {
            return s;
        }
    }
    static int n;
    static Pair arr[];
    static boolean check(int target) {
        int preS = arr[0].s;
        for (int i=1; i<n; i++) {
            int s = arr[i].s;
            int e = arr[i].e;
            // target이 너무 큰 경우
            if (preS + target > e) return false;
            preS = Math.max(preS + target, s);
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Pair[n];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, Comparator.comparingLong(Pair::getX));

        int s = 1;
        int e = 1000000010;

        int ans = 0;

        while (e >= s) {
            int mid = (e + s) / 2;
            if (check(mid)) {
                ans = Math.max(ans, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(ans);
    }
}