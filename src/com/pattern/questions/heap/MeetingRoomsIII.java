package com.pattern.questions.heap;

import java.util.*;

/**
 You are given an integer n. There are n rooms numbered from 0 to n - 1.

 You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed
 time interval [starti, endi). All the values of starti are unique.

 Meetings are allocated to rooms in the following manner:
 - Each meeting will take place in the unused room with the lowest number.
 - If there are no available rooms, the meeting will be delayed until a room becomes free.
 The delayed meeting should have the same duration as the original meeting.
 - When a room becomes unused, meetings that have an earlier original start time should be given the room.

 Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.

 A half-closed interval [a, b) is the interval between a and b including a and not including b.

 Example 1:

 Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
 Output: 0
 Explanation:
 - At time 0, both rooms are not being used. The first meeting starts in room 0.
 - At time 1, only room 1 is not being used. The second meeting starts in room 1.
 - At time 2, both rooms are being used. The third meeting is delayed.
 - At time 3, both rooms are being used. The fourth meeting is delayed.
 - At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
 - At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
 Both rooms 0 and 1 held 2 meetings, so we return 0.

 Example 2:

 Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
 Output: 1
 Explanation:
 - At time 1, all three rooms are not being used. The first meeting starts in room 0.
 - At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
 - At time 3, only room 2 is not being used. The third meeting starts in room 2.
 - At time 4, all three rooms are being used. The fourth meeting is delayed.
 - At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
 - At time 6, all three rooms are being used. The fifth meeting is delayed.
 - At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
 Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1.


 eg:
 {{0,10},{1,2},{12,14},{13,15}}


 https://leetcode.com/problems/meeting-rooms-iii/solutions/
 */
public class MeetingRoomsIII {

    public static void main(String[] args) {
        int n = 2;
        List<int[][]> input = new ArrayList<>();
        int[][] meetings1 = new int[][]
                {
                        {0, 10},
                        {1, 5},
                        {2, 7},
                        {3, 4}
                };
        int[][] meetings2 = new int[][]
                {{0, 10}, {1, 2}, {12, 14}, {13, 15}};
        input.add(meetings1);
        input.add(meetings2);
        for (int i = 0; i < input.size(); i++) {
            System.out.println("For Meeting No: "+i);
            System.out.println(new MeetingRoomsIII().mostBooked(n, input.get(i)));
        }

    }

    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Meet> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> bookingCount = new HashMap<>();
        for (int i = 0; i < n && i< meetings.length; i++) {
            minHeap.offer(new Meet(meetings[i][1], i));
            bookingCount.put(i, 1);
        }

        for (int i = n; i < meetings.length; i++) {
            Meet earliestFreeRoom = minHeap.poll();
            earliestFreeRoom.endTime = earliestFreeRoom.endTime + (meetings[i][1] - meetings[i][0]);
            minHeap.offer(earliestFreeRoom);
            bookingCount.put(earliestFreeRoom.roomNumber, bookingCount.get(earliestFreeRoom.roomNumber) + 1);
        }

        int maxOccupancy = -1;
        int roomWithMaxOccupancy = -1;
        for (Map.Entry<Integer, Integer> entry : bookingCount.entrySet()) {
            if (entry.getValue() > maxOccupancy) {
                maxOccupancy = entry.getValue();
                roomWithMaxOccupancy = entry.getKey();
            }
        }

        return roomWithMaxOccupancy;
    }

    class Meet implements Comparable{
        Integer endTime;
        Integer roomNumber;
        boolean inUse; //

        Meet(Integer endTime,
        Integer roomNumber){
            this.endTime=endTime;
            this.roomNumber=roomNumber;
        }
        @Override
        public int compareTo(Object o) {
            Meet m = (Meet) o;
            return this.endTime.compareTo(m.endTime)==0?this.roomNumber.compareTo(m.roomNumber): this.endTime.compareTo(m.endTime);
        }
    }
}
