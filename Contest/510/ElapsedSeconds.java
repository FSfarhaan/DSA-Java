// Unsolved

public class ElapsedSeconds {
    // static int secondsBetweenTimes(String startTime, String endTime) {
        
    // }
    public static void main(String[] args) {
        String startTime = "12:34:56", endTime = "13:00:00";

        String start = new String();
        String end = new String();
        for (String split : startTime.split(":")) {
            start += split;
        };
        for(String split: endTime.split(":")) {
            end += split;
        }

        int iStart = Integer.parseInt(start);
        int iEnd = Integer.parseInt(end);


        // System.out.println(startTime);
        System.out.println(iEnd - iStart);
        // System.out.println(endArr);

        // for(int i = 0; i < stArr.length; i++) {
        //     System.out.print(stArr[i] + " ");
        // }
    }
}
