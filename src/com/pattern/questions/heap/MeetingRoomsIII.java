package com.pattern.questions.heap;

/**
 * You have an integer rooms, representing room numbers from 0 to rooms−1. Additionally, you are given an 2D2D integer array called meetings, where each element meetings[i] = [starti,endi][starti​,endi​] indicates that a meeting will be held in the half-closed interval [starti,endi)[starti​,endi​). Each startistarti​​ is unique.
 * <p>
 * Meetings are allocated to rooms in the following manner:
 * <p>
 * Each meeting will take place in the unused room with the lowest number.
 * <p>
 * If there are no available rooms, the meeting will be delayed until a room becomes free, maintaining the same duration as the original meeting.
 * <p>
 * When a room is vacated, the meeting with the earliest original start time is given priority for that room.
 * <p>
 * Your task is to determine the room number that hosted the highest number of meetings. If there are multiple rooms, return the room with the lowest number.
 * <p>
 * Note: A half-closed interval [a, b) is the interval between a and b including a and not including b.
 */
public class MeetingRoomsIII {
}
