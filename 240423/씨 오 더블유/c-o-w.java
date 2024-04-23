import java.io.*;
import java.util.*;

public class Main {
    static int len;
    static String str;
    static int[] R;
    static int[] L;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        str = br.readLine();

        L = new int[len];
        R = new int[len];

        if (str.charAt(0) == 'C') {
            L[0] = 1;
        }
        if (str.charAt(len-1) == 'W') {
            R[len-1] = 1;
        }

        for (int i=1; i<len; i++) {
            if (str.charAt(i) == 'C') {
                L[i] = L[i-1] + 1;
            } else {
                L[i] = L[i-1];
            }
        }

        for (int i=len-2; i>=0; i--) {
            if (str.charAt(i) == 'W') {
                R[i] = R[i+1] + 1;
            } else {
                R[i] = R[i+1];
            }
        }

        long ans = 0;
        for (int i=1; i<len-1; i++) {
            if (str.charAt(i) == 'O') {
                ans += L[i] * R[i];
            }
        }
        System.out.println(ans);
    }
}