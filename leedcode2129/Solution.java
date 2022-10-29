package leedcode.leedcode2129;


public class Solution {
    public String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        for(int i  =0;i< arr.length;i++){
            if(arr[i].length()>2){
                String temp = "";
               temp+= arr[i].substring(0,1).toUpperCase();
               temp+=arr[i].substring(1).toLowerCase();
               arr[i] = temp;
            }else {
                arr[i] = arr[i].toLowerCase();
            }
        }
        String res = "";
        for(String s:arr){
            res+=s+" ";
        }
        return res.substring(0,res.length()-1);
    }
}
