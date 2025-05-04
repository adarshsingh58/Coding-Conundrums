package com.DataStructures_And_Questions.QueuesStack;

/**
 * Convert an infix expression to a postfix expression
 * e.g: 3+6∗5−1/2 to 365*+12/-
 */
public class InfixToPostfix {

    public static void main(String[] args) {
        String expression = "3+6*5-1/2";
        String postFix = getPostFixNotation(expression);
        System.out.println(postFix);
    }

    /**
     * So to convert Infix to Postfix, we follow below algo:
     * >Create a stack for storing operators and a stringbuilder, sb, for saving final postfix expression
     * >For each operand i.e. Digit, we simply append it to the sb
     * >For each operator(*,/,+,-), we follow below rules:
     * o If stack is empty, we push the current operator
     * o If stack is NOT empty
     * - we see if current operator has lower prec than operator on top of stack, we push the current operator
     * - else if current operator has higher prec than ope on topOfStack, we pop and append ALL operators
     * from stack to sb. And THEN push current operator to stack.
     * >At the end if infix expression is empty but stack is not empty, we pop and append operator from stack to
     * sb until stack is empty.
     * <p>
     * The whole idea is that, stack must always contain operator with higher prec in order. i.e. from index 0 to
     * current index in stack, each index i must be of higher prec than operator i-1.
     * If we try to push any operator which does not have higher prec than curent top, our rule will be broken
     * hence, we pop out all the elements and then push current operator in empty stack.
     *
     * @TimeComplexity O(n), we traverse through the entire infix string, where n is length of expression
     * @SpaceComplexity O(m), where m is number of operators. We have used stack of size m.
     */
    public static String getPostFixNotation(String expression) {
        StringBuffer sb = new StringBuffer();
        java.util.Stack operatorStack = new java.util.Stack();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(c);
                } else {
                    if (hasHigherOrEqualPrec((char) operatorStack.peek(), c)) {
                        while (!operatorStack.isEmpty()) {
                            sb.append(operatorStack.pop());
                        }
                    }
                    operatorStack.push(c);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            sb.append(operatorStack.pop());
        }
        return sb.toString();
    }

    /**
     * This is to tell if stackTop has higher precedence than c or not.
     * (* and / has higher prec than + and -.
     * We are limiting our scope to these 4 opeprators only.
     * <p>
     * So, if stackTop has higher or equal precedence than c, we return true.
     */
    private static boolean hasHigherOrEqualPrec(char stackTop, char c) {
        if (stackTop == '/' || stackTop == '*') {//c has higher precedence
            return true;
        }
        if ((c == '-' || c == '+') && (stackTop == '-' || stackTop == '+')) {//if c has equal prec as stackTop
            return true;
        }
        return false;
    }
}
