package com.questions.scenarioBasedQues;

public class LicenseKeyFormatting {

    public static void main(String[] args) {

        System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] cA = s.toCharArray();
        for (int i = cA.length - 1, j = k; i >= 0; i--) {
            if (j != 0) {
                if (cA[i] == '-')
                    continue;
                else {
                    stringBuffer.insert(0, Character.toUpperCase(cA[i]));
                    j--;
                }
            } else if (j == 0) {
                stringBuffer.insert(0, '-');
                j = k;
                i++;
            }
        }
        String res = stringBuffer.toString();
        if (stringBuffer!=null && stringBuffer.length()>0 && stringBuffer.toString().toCharArray()[0] == '-')
            res = stringBuffer.substring(1);
        return res;
    }
}
