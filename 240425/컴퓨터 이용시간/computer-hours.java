import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    static class Node {
        int time;
        int type;
        int index;

        public Node(int time, int type, int index) {
            this.time = time;
            this.type = type;
            this.index = index;
        }

        public int getTime() {
            return this.time;
        }

        public int getType() {
            return this.type;
        }
    }

    static List<Node> nodes = new ArrayList<>();
    static PriorityQueue<Integer> availableComputers = new PriorityQueue<>();
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ans = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            nodes.add(new Node(start, 1, i));
            nodes.add(new Node(end, -1, i));
        }

        for (int i = 1; i <= N; i++) {
            availableComputers.add(i);
        }

        nodes = nodes.stream()
                     .sorted(Comparator.comparingInt(Node::getTime))
                     .collect(Collectors.toList());

        for (Node node : nodes) {
            if (node.type == 1) { 
                int computer = availableComputers.poll();
                ans[node.index] = computer;
            } else { 
                availableComputers.add(ans[node.index]); 
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}