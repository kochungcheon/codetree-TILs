import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    static class Node {
        int x, v, index;
        public Node (int x, int v, int index) {
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        // K 개 이상 겹치는 거 
        int K = Integer.parseInt(st.nextToken());

        int start = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            int s = 0;
            int e = 0;

            if (dir.equals("R")) {
                s = start;
                start += move;
                e = start;
            } else {
                e = start;
                start -= move;
                s = start;
            }

            nodes.add(new Node(s, 1, i));
            nodes.add(new Node(e, -1, i));
        }

        nodes = nodes.stream().sorted(Comparator.comparing(Node::getX)).collect(Collectors.toList());

        int ans = 0;
        int sumVal = 0;

        for (int i=0; i<2*N; i++) {
            int x = nodes.get(i).x;
            int v = nodes.get(i).v;
            int index = nodes.get(i).index;

            sumVal += v;

            if (sumVal >= K) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}