import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 1;
    
        int s = 1;
        int e = 2;
        int tmp = s + e;
        while (e >= s && n > e) {
            if (tmp == n) {
                ans++;
                e++;
                tmp+=e;
            }
            else if (tmp > n) {
                tmp-=s;
                s++;
            } 
            else {
                e++;
                tmp+=e;
            }
        }

        System.out.println(ans);
    }
}

//