package com.questions.scenarioBasedQues;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/*
*
* Next Closest Time

Given a time represented in the format “HH:MM:SS”, form the next closest time by rearranging the digits the current digits.

Assume the time is in 24 hour format (00:00:00 - 23:59:59)
Input

The first line of input consists of an integer T (number of test cases). Each test case consists of a time string.
Output

For each test case, print the closest time. In cases where the input time is valid but no solution is possible, the next closest time is the time provided itself. If the given time is invalid print “INVALID”.
Constraints

1 <= T <= 10000

Sample Input

7
12:36:09
01:01:21
11:00:61
09:09:09
06:06:06
12:12:12
23:59:59

Sample Output

12:39:06
01:02:11
INVALID
09:09:09
06:06:06
12:12:21
23:59:59

* Input
* 20
12:36:09
01:01:01
24:12:23
03:30:58
12:12:12
01:01:21
01:21:10
11:00:61
09:09:09
06:56:06
06:56:06
00:00:00
23:59:59
11:32:40
04:00:18
04:33:21
15:00:00
02:05:46
12:04:10
03:02:53

Output
12:39:06
01:01:10
INVALID
03:35:08
12:12:21
01:02:11
02:01:11
INVALID
09:09:09
06:56:06
06:56:06
00:00:00
23:59:59
11:34:02
04:01:08
10:23:34
15:00:00
02:06:45
12:10:04
03:03:25
* */
public class NextClosestTime {

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        int testCases = 1;
        try {
            for (int i = 0; i < testCases; i++) {
                String time = "03:02:53";/*scanner.next();*/
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                Date date = simpleDateFormat.parse(time);
                char[] cA = time.toCharArray();
                for (int j = cA.length - 1; j >= 0; j--) {
                    if (cA[j] == ':') continue;
                    for (int k = j; k >= 0; k--) {
                        if (cA[k] == ':') continue;
                        char[] cATemp = cA.clone();
                        char temp = cATemp[j];
                        cATemp[j] = cATemp[k];
                        cATemp[k] = temp;
                        String newTime = new String(cATemp);
                        Date newdate = simpleDateFormat.parse(newTime);
                        if (newdate.after(date)) {
                            System.out.println(simpleDateFormat.format(newdate));
                            return;
                        }
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("INVALID");
        }
    }

}
