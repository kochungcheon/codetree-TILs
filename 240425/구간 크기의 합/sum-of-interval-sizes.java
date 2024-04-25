import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    static class Node {
        int x; int v; int index;
        public Node(int x, int v, int index) {
            this.x = x;
            this.v = v;
            this.index = index;
        }
        public int getX() {
            return this.x;
        }
    }
    static List<Node> nodes = new ArrayList<>();
    static Set<Integer> segs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes.add(new Node(a, 1, i));
            nodes.add(new Node(b, -1, i));
        }

        nodes = nodes.stream().sorted(Comparator.comparing(Node::getX)).collect(Collectors.toList());

        int ans = 0;
        int start = nodes.get(0).x;
        int valSum = 0;

        for (int i=0; i< N * 2; i++) {
            int x = nodes.get(i).x;
            int v = nodes.get(i).v;
            int idx = nodes.get(i).index;

            if (start == 0 && valSum == 0 && v == 1) {
                start = x;
            }

            valSum += v;
            
            if (valSum == 0) {
                ans += x - start;
                start = 0;
            }

        }

        System.out.print(ans);
    }
}