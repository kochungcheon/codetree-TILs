import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] count = new int[26];
        Arrays.fill(count, -1);
        int ans = 0;
        int tmp = 0;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int n = c - 97;
            if (count[n] == -1) {
                tmp++;
                count[n] = i + 1;
            } else {
                tmp -= count[n];
                tmp++;
            }
            ans = Math.max(tmp, ans);
        }
        System.out.println(ans);
    }
}