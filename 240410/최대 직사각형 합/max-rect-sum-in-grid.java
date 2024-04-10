import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findMaxRectangleSum(grid, n));
    }

    private static int findMaxRectangleSum(int[][] grid, int n) {
        int maxSum = Integer.MIN_VALUE;

        for (int rowStart = 0; rowStart < n; rowStart++) {
            int[] temp = new int[n];

            for (int rowEnd = rowStart; rowEnd < n; rowEnd++) {
                for (int col = 0; col < n; col++) {
                    temp[col] += grid[rowEnd][col];
                }

      
                maxSum = Math.max(maxSum, kadanesAlgorithm(temp));
            }
        }

        return maxSum;
    }

    private static int kadanesAlgorithm(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}