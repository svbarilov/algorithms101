package challenges.leetCode;

import java.util.Arrays;

//Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
//
//        You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
//
//        Example 1:
//
//        Input: "19:34"
//        Output: "19:39"
//        Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
//        Example 2:
//
//        Input: "23:59"
//        Output: "22:22"
//        Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.


public class NextClosestTime {

    public static void main(String[] args) {
//        String time = "19:34";
//        String time = "13:55";
//        String time = "23:59";
//        String time = "21:45";
        String time = "15:55";
        String result = nextClosestTime(time);
        System.out.println(result);
    }

    public static String nextClosestTime(String time) {
        String[] times = time.split(":");
        int[] pool = new int[4];
        String hours = times[0];
        String mins = times[1];
        int hour1 = Integer.valueOf(hours)/10;
        int hour2 = Integer.valueOf(hours)%10;
        int min1 = Integer.valueOf(mins)/10;
        int min2 = Integer.valueOf(mins)%10;
        int[] oTime = new int[4];
        oTime[0] = hour1;
        oTime[1] = hour2;
        oTime[2] = min1;
        oTime[3] = min2;
        pool = Arrays.copyOf(oTime, 4);
        Arrays.sort(pool);
        for (int i = 3; i > 1; i--) {
            for (int j = 0; j < 4; j++) {
                if ((i == 3 && pool[j] > oTime[i] || (i == 2 && pool[j] > oTime[i] && pool[j] < 6))) {
                    oTime[i] = pool[j];
                    if (i == 2) {
                        oTime[3] = pool[0];
                    }
                    return convert(oTime);
                }
            }
        }
        for (int i = 1; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if ((i == 1 && ((oTime[0] == 2 && pool[j] < 5 && pool[j] > oTime[i]) || (oTime[0] < 2 && pool[j] > oTime[i]))) || (i == 0 && pool[j] < 2 && pool[j] > oTime[i] && oTime[i+1] < 5)) {
                    oTime[i] = pool[j];
                    oTime[2] = pool[0];
                    oTime[3] = pool[0];
                    return convert(oTime);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            oTime[i] = pool[0];
        }
        return convert(oTime);
    }



    public static String convert(int[] arr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            result.append(arr[i]);
            if (i == 1) {
                result.append(':');
            }
        }
        return result.toString();
    }


}
