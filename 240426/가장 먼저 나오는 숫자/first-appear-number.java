import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    static int n, m;
    static int[] arr, mArr;
    static int lb(int target) {
        int s = 0; int e = n-1;
        int idx = n;
        while (e >= s) {
            int mid = (e + s) / 2;
            if (arr[mid] >= target) {
                if (arr[mid] == target) {
                    idx = Math.min(idx, mid);
                }
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return idx != n ? idx + 1 : -1;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int q : mArr) {
            System.out.println(lb(q));
        }
    }
}