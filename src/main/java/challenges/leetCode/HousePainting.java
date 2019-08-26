package challenges.leetCode;

//There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
//
//        The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
//
//        Note:
//        All costs are positive integers.
//
//        Example:
//
//        Input: [[17,2,17],[16,16,5],[14,3,19]]
//        Output: 10
//        Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
//        Minimum cost: 2 + 5 + 3 = 10.



public class HousePainting {

    public static void main(String[] args) {
        int[][] input = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        int result = paintHouses(input);
        System.out.println(result);

    }


    public static int paintHouses(int[][] input) {
        int house = 0;
        int color = 0;
        boolean[] takenColor = new boolean[input.length];
        int result = helper(input, house, color, takenColor);
        return result;
    }

    public static int helper(int[][] input, int house, int color, boolean[] takenColor) {
        takenColor[color] = false;
        int length = input.length;
        if (house > length - 1) {
            return 0;
        }
        if (color > length - 1) {
            return 0;
        }
        for (int i = 0; i < takenColor.length; i++) {
            if (takenColor[color] == true) {
                color = i;
                break;
            } else {
                continue;
            }
        }

        int colorOne = input[house][color] + helper(input, house +1 , 0, takenColor);
        int colorTwo = helper(input, house + 1, 1, takenColor);
        int colorThree = helper(input, house + 1, 2, takenColor);
        int min = Math.min(colorOne, Math.min(colorTwo, colorThree));
        return min;
    }


}
