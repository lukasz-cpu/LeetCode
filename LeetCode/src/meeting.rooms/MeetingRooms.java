package meeting.rooms;

import java.util.Arrays;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};

        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            int i1 = intervals[i][0];
            int i2 = intervals[i - 1][1];
            if (i1 < i2) {
                return false;
            }
        }
        
        return true;
    }
}
