import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    static class Node {
        int x, v, index;

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
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodes.add(new Node(s, 1, i));
            nodes.add(new Node(e, -1, i));
        }

        nodes = nodes.stream().sorted(Comparator.comparing(Node::getX)).collect(Collectors.toList());

        int ans = 0;



        for (int i=0; i<2*N; i++) {
            int x = nodes.get(i).x;
            int v = nodes.get(i).v;
            int index = nodes.get(i).index;

            if (v == 1) {
                segs.add(index);
            }
            else {
                segs.remove(index);
            }

            ans = Math.max(ans, segs.size());
        }

        System.out.println(ans);
    }
}