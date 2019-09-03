package challenges.leetCode;

public class MaxDistanceToClosestPerson {

    public static void main(String[] args) {
//        int[] seats =  {1,0,0,0,1,0,1};
        int[] seats =  {1,0,0,0};
        int result = maxDistToClosest(seats);
        System.out.println(result);
    }

    public static int maxDistToClosest(int[] seats) {
        int i1 = 0;
        int i2 = 0;
        int max = 0;
        while (i2 < seats.length-1) {
            while (i2 < seats.length-1 && seats[i2] == 0) {
                i2++;
            }
            int itMax;
            if ((i1 == 0 && seats[i1] == 0) || (i2 == seats.length - 1 && seats[i2] == 0)) {
                itMax = i2 - i1;
            } else {
                itMax = (i2 - i1)/2;
            }
            max = Math.max(max, itMax);
            i1 = i2;
            i2++;
        }
        return max;
    }



    } // end class
