package com.DataStructures_And_Questions.scenarioBasedQues;

import java.util.Arrays;

/**
 * Given a grid of m boys and n girls, where grid[i][j] = 1 represents that ith boy can invite girl jth girl to party. Each boy can invite only one girl and each girl can accept only one invitation. Find the most invitations that can be accepted.
 * <p>
 * Example:
 * <p>
 * Input: grid = {{1,1,1},
 * {1,0,1},
 * {0,0,1}}
 * Output: 3
 * Explanation: The invitations can be sent as follows:
 * => 1st boy invites the 2nd girl.
 * => 2nd boy invites the 1st girl.
 * => 3rd boy invites the 3rd girl.
 * <p>
 * <p>
 * Input: grid = {{1,0,1,0},
 * {1,0,0,0},
 * {0,0,1,0},
 * {1,1,1,0}}
 * Output: 3
 * Explanation: The invitations can be sent as follows:
 * => 1st boy invites the 3rd girl.
 * => 2nd boy invites the 1st girl.
 * => 3rd boy invites no one.
 * => 4th boy invites the 2nd girl.
 * <p>
 * https://www.geeksforgeeks.org/maximum-number-of-accepted-invitations-to-party/
 */
public class MaximumNumberofAcceptedInvitationstoParty {

    // Function to check if the current boy can invite any girl
    static boolean canInviteGirl(int[][] invitationMatrix, int totalBoys, int currentBoy,
                                 int[] girlInvitedBy, boolean[] visitedBoys) {
        // If the boy has already visited, return false
        if (visitedBoys[currentBoy]) return false;

        // Mark the boy as visited
        visitedBoys[currentBoy] = true;

        // Iterate through all the girls
        for (int girl = 0; girl < invitationMatrix[currentBoy].length; girl++) {
            // If the current boy can invite the girl
            if (invitationMatrix[currentBoy][girl] == 1) {
                // If the girl is not invited by any boy or the
                // boy who invited the girl can invite another girl
                if (girlInvitedBy[girl] == -1 || canInviteGirl(invitationMatrix, totalBoys,
                        girlInvitedBy[girl], girlInvitedBy, visitedBoys)) {
                    // The girl is invited by the current boy
                    girlInvitedBy[girl] = currentBoy;
                    return true;
                }
            }
        }
        return false;
    }

    // Function to find the maximum number of invitations
    static int maximumInvitations(int[][] invitationMatrix) {
        int totalBoys = invitationMatrix.length;
        int totalGirls = invitationMatrix[0].length;
        int[] girlInvitedBy = new int[totalGirls];
        Arrays.fill(girlInvitedBy, -1); // girl[i] = which boy has invited the ith girl.
        int totalInvitations = 0;

        // For each boy, try to invite a girl
        for (int boy = 0; boy < totalBoys; boy++) {
            boolean[] visitedBoys = new boolean[totalBoys];
            if (canInviteGirl(invitationMatrix, totalBoys, boy, girlInvitedBy, visitedBoys))
                totalInvitations++;
        }

        return totalInvitations;
    }

    public static void main(String[] args) {
        // Define the invitation matrix
        int[][] invitationMatrix = {{1, 1, 1}, {1, 0, 1}, {0, 0, 1}};

        // Call the maximumInvitations function and store the result
        int totalInvitations = maximumInvitations(invitationMatrix);

        // Print the result
        System.out.println("The maximum possible number of accepted invitations is: " + totalInvitations);
    }
}
