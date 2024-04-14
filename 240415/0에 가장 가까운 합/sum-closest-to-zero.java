import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int len = arr.length;

        int R = len - 1;
        int L = 0;
        int ans = Integer.MAX_VALUE;

        while (R > L) {
            int tmp = arr[L] + arr[R];
            ans = Math.min(Math.abs(tmp), ans);
            if (tmp >= 0) {
                R--;
            } else {
                L++;
            }
        }
        System.out.println(ans);
    }
}