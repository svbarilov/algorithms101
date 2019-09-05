package challenges.leetCode;

public class RotateMatrix90 {

    public static void main(String[] args) {
        int[][] N = new int[4][4];
        int val = 11;
        for (int i = 0; i < N.length; i++) {
            for (int j = 0; j < N.length; j++) {
                N[i][j] = val++;
            }
        }
        printMatrix(N);
        System.out.println("\n\n\n");
        int[][] result = rotate90(N);
        printMatrix(result);
        printMatrix(result);
    }

    public static int[][] rotate90(int[][] N) {
        int length = N.length;
        int lastIndex = length-1;
        int[] top = new int[length];
        int[] right = new int[length];
        int[] bottom = new int[length];
        int[] left = new int[length];
        for (int s = 0; s <= length/2; s++) {
            ////////   saving edges    //////////////////
            // fill top
            for (int h = s; h < length; h++) {
                top[h] = N[s][h];
            }
            // fill right
            int r = lastIndex;
            for (int v = s; v < length; v++) {
                right[r--] = N[v][lastIndex];
            }
            // fill bottom
            for (int h = s; h < length; h++) {
                bottom[h] = N[lastIndex][h];
            }
            // fill  left
            int l = lastIndex;
            for (int v = s; v < length; v++) {
                left[l--] = N[v][s];
            }
            ////////  rotating    //////////////////
            // top -> right & fill for next
            for (int v = s; v < length; v++) {
                N[v][lastIndex] = top[v];
            }
            // right -> bottom
            for (int h = s; h < length; h++) {
                N[lastIndex][h] = right[h];
            }
            // bottom -> left
            for (int v = s; v < length; v++) {
                N[v][s] = bottom[v];
            }
            // left -> top
            for (int h = s; h < length; h++) {
                N[s][h] = left[h];
            }
            length -= 1;
            lastIndex -= 1;
        }
        return N;
    }

    public static void printMatrix(int[][] N) {
        for (int i = 0; i < N.length; i++) {
            for (int j = 0; j < N.length; j++) {
                System.out.print(N[i][j] + " ");
            }
            System.out.print("\n");
        }

    }


}
