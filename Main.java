public class Main {
    public static void main(String[] args) {

        int bb = 1000000000;
        long aa = (long) bb+bb+bb+bb;
        System.out.println(aa>Integer.MAX_VALUE);
    }
}
