import java.util.*;
import java.util.stream.*;
import java.io.*;

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
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) * 2;
            int b = Integer.parseInt(st.nextToken()) * 2 - 1;

            nodes.add(new Node(a, 1, i));
            nodes.add(new Node(b, -1, i));
        }

        nodes = nodes.stream().sorted(Comparator.comparing(Node::getX)).collect(Collectors.toList());

        int valSum = 0;
        int ans = 0;

        for (Node node : nodes) {
            valSum += node.v;
            if (node.v == 1) {
                ans = Math.max(ans, valSum);
            }
        }

        System.out.println(ans);
    }
}