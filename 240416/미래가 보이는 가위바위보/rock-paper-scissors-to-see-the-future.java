import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int RULES = 3;
    // 가위 바위 보 승리 배열
    static int[][] wins;
    // 누적 승리 배열
    static int[][] prefix;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        input();
        setPrefix();
        System.out.print(calAns());
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        wins = new int[RULES][N];
        for (int i=0; i<N; i++) {
            String now = br.readLine();
            wins[0][i] = calWinH(now);
            wins[1][i] = calWinS(now);
            wins[2][i] = calWinP(now);
        }
    }

    static void setPrefix() {
        prefix = new int[RULES][N+1];
        for (int i=0; i<N; i++) {
            prefix[0][i + 1] = prefix[0][i] + wins[0][i];
            prefix[1][i + 1] = prefix[1][i] + wins[1][i];
            prefix[2][i + 1] = prefix[2][i] + wins[2][i];
        }
    }

    static int calAns() {
        int ans = 0;
        for (int i=0; i<N; i++) {
            int restH = prefix[0][N] - prefix[0][i];
            int restS = prefix[1][N] - prefix[1][i];
            int restP = prefix[2][N] - prefix[2][i];

            int h = prefix[0][i] + Math.max(restS, restP);
            int s = prefix[1][i] + Math.max(restH, restP);
            int p = prefix[2][i] + Math.max(restH, restS); 
            ans = Math.max(ans, h);
            ans = Math.max(ans, s);
            ans = Math.max(ans, p);
        }
        return ans;
    }
    static int calWinH(String now) {
        if (now.equals("S")) return 1;
        return 0;
    }

    static int calWinS(String now) {
        if (now.equals("P")) return 1;
        return 0;
    }

    static int calWinP(String now) {
        if (now.equals("H")) return 1;
        return 0;
    }


}

// 가위, 바위, 보 냈을 때 몇 번 이기는 지 알 수 있다.
// 누적합으로 누적 횟수 구하기
//