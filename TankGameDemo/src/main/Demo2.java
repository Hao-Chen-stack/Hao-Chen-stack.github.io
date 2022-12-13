package main;

public class Demo2 {
    public static void main(String[] args) {
        int x=2,y=3;
        switch(x)
        {
            default:
                y++;
            case 3:
                y++;
            case 4:
                y++;
        }
        System.out.println("y="+y);
    }
}
