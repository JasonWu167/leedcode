package leedcode.others.leedcode481;

public class Solution {
    public int magicalString(int n) {
        if(n<=3){
            return 1;
        }
        int res = 0;
        int num = 1;
        StringBuffer sb = new StringBuffer();
        sb.append("122");
        for (int i = 2;sb.length()<=n; i++) {
            if(sb.charAt(i) == '1'){
                sb.append(num);
            }else{
                sb.append(num).append(num);
            }
            num^=3;
        }
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)=='1'){
                res++;
            }
        }
        return res;
    }
}
