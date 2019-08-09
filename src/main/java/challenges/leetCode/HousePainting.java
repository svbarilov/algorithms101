package challenges.leetCode;


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
