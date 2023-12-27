import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i=0; i<n; i++) {
            String com = sc.nextLine();
            String[] tmp = com.split(" ");
            hash.put(tmp[1], hash.getOrDefault(tmp[1], 0)+1);
        }

        long ans = 1;
        for (int cnt : hash.values()) {
            ans *= (cnt + 1);
        }
        ans-=1;
        System.out.println(ans);

    }
}