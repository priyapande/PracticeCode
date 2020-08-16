package main.trial;

public class GCTrial {
    public static void main(String[] args) {
        int i=0;
        while(true) {
            String str = "Hello";
            Integer I = new Integer(i++);
            System.out.println(str+I);
        }
    }
}
