package com.DataStructures_And_Questions.math;

/**
 * @author Adarshs
 */
public class IsNumberValid {

    public static void main(String[] args) {
        String inputNumber = "..5.";
        boolean isValid = isNumberValid(inputNumber);
        System.out.println(isValid);
    }

    /**
     * This is an interesting problem where concept of Automata is used.
     * >We first note down all the states which are possible: START, INTEGER, DECIMAL, UNKNOWN, POST_DECIMAL_INTEGER
     * eg: 42.25
     * Here, 4,2 are INTEGER : . is a DECIMAL: 2,5 are POST_DECIMAL_INTEGER. Any other state will be an unknown leading to not a valid number.
     * >Now, we define which states are reachable from which states.
     * -From START we can reach to INTEGER or DECIMAL. Anything else will be invalid. eg 25 OR .21 VALID
     * -FROM INTEGER we can reach to INTEGER or DECIMAL. Anything else will be invalid. eg 25 OR 7.1 VALID
     * -FROM DECIMAL we can reach to POST_DECIMAL_INTEGER. Anything else will be invalid. eg .25 OR 7.1 VALID: .. is INVALID
     * -FROM POST_DECIMAL_INTEGER we can reach to POST_DECIMAL_INTEGER. Anything else will be invalid. eg .25 OR 7.12 VALID: .7. is INVALID
     * -At anytime, if we encounter UNKNOWN STATE, the number will be invalid
     */
    private static boolean isNumberValid(String inputNumber) {
        char[] charArr = inputNumber.toCharArray();
        STATE nextState = nextState(STATE.START, charArr[0]);
        for (int i = 1; i < inputNumber.length(); i++) {
            nextState = nextState(nextState, charArr[i]);
            if ((nextState == STATE.UNKNOWN)) {
                return false;
            }
        }
        return true;
    }

    private static STATE nextState(STATE currentState, char c) {
        switch (currentState) {
            case START: {
                if (c >= 48 && c <= 57) {
                    return STATE.INTEGER;
                } else if (c == '.') {
                    return STATE.DECIMAL;
                } else {
                    return STATE.UNKNOWN;
                }
            }
            case INTEGER: {
                if (c >= 48 && c <= 57) {
                    return STATE.INTEGER;
                } else if (c == '.') {
                    return STATE.DECIMAL;
                } else {
                    return STATE.UNKNOWN;
                }
            }
            case DECIMAL: {
                if (c >= 48 && c <= 57) {
                    return STATE.POST_DECIMAL_INTEGER;
                } else {
                    return STATE.UNKNOWN;
                }
            }
            case POST_DECIMAL_INTEGER: {
                if (c >= 48 && c <= 57) {
                    return STATE.INTEGER;
                } else {
                    return STATE.UNKNOWN;
                }
            }
        }
        return STATE.UNKNOWN;
    }

    enum STATE {START, INTEGER, DECIMAL, UNKNOWN, POST_DECIMAL_INTEGER}

    ;
}
