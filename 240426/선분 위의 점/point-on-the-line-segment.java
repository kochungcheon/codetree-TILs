import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Main {
    static int n, m;
    static long[] arr;

    static int findR(long target) {
        int left = 0, right = n - 1;
        int minIdx = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else
                left = mid + 1;
        }
    
        return minIdx;
    }

    // 크거나 같은 것 중 가작 작은 것
    static int findL(long target) {
        int s = 0; int e = n - 1;
        int idx = n;
        while (e >= s) {
            int mid = (e + s) / 2;
            if (arr[mid] >= target) {
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
        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            long s = Integer.parseInt(st.nextToken());
            long e = Integer.parseInt(st.nextToken());

            int idxE = findR(e);
            int idxS = findL(s);
            if (idxE == -1 || idxS == n) {
                System.out.println(0);
            }
            else {
                System.out.println(findR(e) - findL(s));
            }
        }
    }
}


// e 작거나 같은 것 중 가장 큰 것
// s 크거나 같은 것 중 가장 작은 것