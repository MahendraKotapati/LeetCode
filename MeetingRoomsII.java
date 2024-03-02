import java.util.Arrays;

public class MeetingRoomsII {

    /*
    https://www.geeksforgeeks.org/minimum-halls-required-for-class-scheduling/
    
     Approach 2:
        -->  If we draw the start and end times in timeline
        -->  Then the value (represents no.of meetings) at time point at which maximum meetings intersect is minimum meeting rooms required
        -->  We follow the Lazy Approach + Prefix Sum technique to mark there is a meeting going from start[i] to end[i]
            time_slot[start[i]] += 1; // which represents from start[i] there is meeting going on.
            time_slot[end[i]] -= 1; // to nullify effect which caused by prefix sum

        --> then prefix sum the time_slot[], and find the max_value which will be our answer (min meeting rooms)  
    */

    /*
    // Approach 2
    public int minMeetingRooms(int[][] intervals) {
        
        int MAX_END_TIME = 1000000;
        int[] time_slot = new int[MAX_END_TIME+1];
        int min_meeting_rooms = 0;

        for(int i=0;i<intervals.length;i++) {
            time_slot[intervals[i][0]] += 1;
            time_slot[intervals[i][1]] -= 1; 
        }

        min_meeting_rooms = time_slot[0];
        for(int i=1;i<=MAX_END_TIME;i++) {
            time_slot[i] += time_slot[i-1];
            min_meeting_rooms = Math.max(time_slot[i], min_meeting_rooms);
        }

        return min_meeting_rooms;
    }
    */

    
    /*
        Approach 1:

        Sort the startTimes array
        then for each startTime check if any meeting room available or not.
        the easiest way to check is, check the first element in sorted array of endTimes (i.e) endTimes[j] < startTimes[i],
        Then meeting room is available, we don't need to care about which meeting room is available
    */

    // Approach 1
    public int minMeetingRooms(int[][] intervals) { 

        int n = intervals.length, i = 0, j = 0, curr_meetings = 0, min_meeting_rooms = 0;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for(i=0;i<n;i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        i=0;j=0;

        while(i<n && j<n) {
            if (startTimes[i]<endTimes[j]) { // no meeting room is availble, so take increase no.of meeting rooms
                curr_meetings++;
                min_meeting_rooms = Math.max(min_meeting_rooms, curr_meetings);
                i++;
            } else if (startTimes[i] > endTimes[j]) { // meeting room is available, so decrease no.of meeting rooms
                curr_meetings--;
                j++;
            } else { // one meeting has ended, and new meeting has started at same time so, no change in no.of meeting rooms.
                i++;j++;
            }
        }

        return min_meeting_rooms;
    }
}