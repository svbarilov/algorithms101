package challenges.leetCode.Recursion;

//On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
//        The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
//        A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
//        then one square in an orthogonal direction.
//        Each time the knight is to move, it chooses one of eight possible moves uniformly at random
//        (even if the piece would go off the chessboard) and moves there.
//        The knight continues moving until it has made exactly K moves or has moved off the chessboard.
//        Return the probability that the knight remains on the board after it has stopped moving.
//
//Example:
//        Input: 3, 2, 0, 0
//        Output: 0.0625
//        Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
//        From each of those positions, there are also two moves that will keep the knight on the board.
//        The total probability the knight stays on the board is 0.0625.


import java.util.ArrayList;
import java.util.List;

public class KnightOutOfBound {

    public static void main(String[] args) {
        int N = 3;
        int K = 2;
        int r = 0;
        int c = 0;
        double[][][] dp = new double[N][N][K+1];
        Double result = knightProbability(N, K, r, c, dp);
        System.out.println(result);
    }

    public static double knightProbability(int N, int K, int r, int c, double[][][] dp) {
        if  (K < 1) {
            return 1.0;
        }
        Double result;
        List<List<Integer>> possibleMoves = getPossibleMoves();
        List<List<Integer>> moves = new ArrayList<>();
        for (int i = 0; i < possibleMoves.size(); i++) {
            List<Integer> move = new ArrayList<>();
            int x = r + possibleMoves.get(i).get(0);
            int y = c + possibleMoves.get(i).get(1);
            move.add(x);
            move.add(y);
            moves.add(move);
        }
        Double probability = 0.0;
        for (List<Integer> move: moves) {
            double prob;
            if (move.get(0) >= 0 && move.get(0) < N && move.get(1) >= 0 && move.get(1) < N) {
                if (dp[move.get(0)][move.get(1)][K] !=0) {
                    prob = dp[move.get(0)][move.get(1)][K];
                } else {
                    prob = knightProbability(N, K-1, move.get(0), move.get(1), dp);
                    dp[move.get(0)][move.get(1)][K] = prob;
                }
                probability += prob;
            }
        }
        result = probability/8;
        return result;
    }

    public static List<List<Integer>> getPossibleMoves() {
        List<List<Integer>> moves = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(-1);
        one.add(-2);
        moves.add(one);

        List<Integer> two = new ArrayList<>();
        two.add(-1);
        two.add(2);
        moves.add(two);

        List<Integer> three = new ArrayList<>();
        three.add(2);
        three.add(-1);
        moves.add(three);

        List<Integer> four = new ArrayList<>();
        four.add(2);
        four.add(1);
        moves.add(four);

        List<Integer> five = new ArrayList<>();
        five.add(1);
        five.add(2);
        moves.add(five);

        List<Integer> six = new ArrayList<>();
        six.add(1);
        six.add(-2);
        moves.add(six);

        List<Integer> seven = new ArrayList<>();
        seven.add(-2);
        seven.add(-1);
        moves.add(seven);

        List<Integer> eight = new ArrayList<>();
        eight.add(-2);
        eight.add(1);
        moves.add(eight);

        return moves;
    }

}
