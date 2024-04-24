import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    static class Point {
        int x, v, index;

        public Point(int x, int v, int index) {
            this.x = x;
            this.v = v;
            this.index = index;
        }

        public int getX() {
            return this.x;
        }

        @Override
        public String toString() {
            return String.format("Point(x=%d, v=%d, index=%d)", x, v, index);
        }
    }

    static List<Point> points = new ArrayList<>();

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

            points.add(new Point(s, 1, i));
            points.add(new Point(e, -1, i));
        }

        points = points.stream().sorted(Comparator.comparing(Point::getX)).collect(Collectors.toList());

        int ans = 0;
        
        for (int i=0; i<2*N; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int index = points.get(i).index;

            if (v == +1) {
                if (segs.size() == 0) {
                    ans++;
                }
                segs.add(index);
            }
            else {
                segs.remove(index);
            }
        }
        System.out.println(ans);
    }
}