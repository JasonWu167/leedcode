package leedcode.leedcode1904;

public class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        //获取开始时分和结束时分、
        int beginH = Integer.parseInt(loginTime.substring(0, 2));
        int beginM = Integer.parseInt(loginTime.substring(3));
        int endH = Integer.parseInt(logoutTime.substring(0, 2));
        int endM = Integer.parseInt(logoutTime.substring(3));
        int begin = beginH*60+beginM;
        int end = endH*60+endM;
        //获取有效开始结束时分
        beginM = f1(beginM);
        endM = f2(endM);
        if (beginM == 60) {
            beginH++;
            beginM = 0;
        }
        if (begin > end) {//通宵
            return (24 - beginH - 1 + endH) * 4 + (60 - beginM + endM) / 15;
        } else {
            return ((endH - beginH - 1) * 4 + (60 - beginM + endM) / 15) >0? ((endH - beginH - 1) * 4 + (60 - beginM + endM) / 15) :0;
        }
    }

    private int f1(int beginM) {
        if (beginM <= 0) {
            beginM = 0;
        } else if (beginM <= 15) {
            beginM = 15;
        } else if (beginM <= 30) {
            beginM = 30;
        } else if (beginM <= 45) {
            beginM = 45;
        } else if (beginM <= 60) {
            beginM = 60;
        }

        return beginM;
    }

    private int f2(int endM) {
        if (endM < 15) {
            endM = 0;
        } else if (endM < 30) {
            endM = 15;
        } else if (endM < 45) {
            endM = 30;
        } else if (endM < 60) {
            endM = 45;
        }
        return endM;
    }
}
