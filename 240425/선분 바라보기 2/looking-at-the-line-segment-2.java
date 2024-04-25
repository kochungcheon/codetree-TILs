import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Main {
    static class Node implements Comparable<Node>{
        int y; int x1; int x2;
        public Node(int y, int x1, int x2) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
        }
        public int compareTo(Node other) {
            if (this.y != other.y) {
                return Integer.compare(other.y, this.y);
            } return Integer.compare(this.x1, other.x1);
        }

        public int getX() {
            return this.x1;
        }
    }

    static List<Node> nodes = new ArrayList<>();
    static TreeSet<Node> active = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            nodes.add(new Node(y, x1, x2));
        }

        nodes.sort(Comparator.comparingInt(s -> s.x1));

        Set<Integer> visible = new HashSet<>();
        int ans = 0;
        for (Node node : nodes) {
            active.removeIf(n -> n.x2 < n.x1);

            Node high = active.isEmpty() ? null : active.first();
            if (high == null || node.y > high.y) {
                if (visible.add(node.y)) {
                    ans++;
                }
            }
            active.add(node);
        }

        System.out.println(ans + 1);
    }
}