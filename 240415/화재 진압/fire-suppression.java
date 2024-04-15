import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 화재 가능성 cnt
        int n = Integer.parseInt(st.nextToken());
        
        // 소방서 위치 cnt
        int m = Integer.parseInt(st.nextToken());
        
        int[] nArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken()) + 1000000000;
        } 

        int[] mArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken()) + 1000000000;
        }

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        int ans = 0;
        for (int fire : nArr) {
            int tmp = find(fire, mArr);
            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }

    public static int find(int fire, int[] mArr) {
        int l = 0;
        int r = mArr.length - 1;

        int minTime = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;
            int time = Math.abs(fire - mArr[mid]);
            minTime = Math.min(minTime, time);

            if (mArr[mid] < fire) {
                l = mid + 1;
            } else if (mArr[mid] > fire) {
                r = mid - 1;
            } else {
                return 0;
            }
        }
        return minTime;
    }
}