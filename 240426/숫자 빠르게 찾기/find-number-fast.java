import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Main {
    static int N, M;
    static int[] arr;
    static int check(int num) {
        int s = 0; int e = N-1;
        while (e >= s) {
            int mid = (s+e) / 2;
            if (arr[mid] == num) {
                return mid + 1;
            }

            if (arr[mid] > num) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i=0; i<M; i++) {
            int now = Integer.parseInt(br.readLine());
            System.out.println(check(now));
        }
    }
}