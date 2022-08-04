import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 描述:
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(color == image[sr][sc])
            return image;
        int old = image[sr][sc];
        int m = image.length, n = image[0].length;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{sr,sc});
        image[sr][sc] = color;
        while(queue.peek() != null){
            int[] t = queue.poll();
            int x = t[0],y = t[1];
            for(int[]tmp: new int[][]{{x+1,y},{x,y+1},{x-1,y},{x,y-1}}){
                int i = tmp[0],j=tmp[1];
                if(i>=0 && i<m && j>=0 && j<n && old==image[i][j]) {
                    queue.add(new int[]{i, j});
                    image[i][j] = color;
                }
            }
        }
        return image;
    }
    @Test
    public void test(){
        int[][] arr = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1,
        sc = 1,
        color = 2;
        for (int[] ints : floodFill(arr, sr, sc, color)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void main(String[] args) {
        int[] arr = null;
        for (int i : arr) {
            System.out.println(i);
        }
    }
}