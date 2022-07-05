import java.awt.*;
import java.util.Scanner;

public class MouseMover {

    public static void main(String[] args) {

        System.out.println("=====================================\n" +
                "Welcome to mouse mover program !!! \n" +
                "=====================================\n" +
                "The cursor/mouse will move in every 10 seconds.\n" +
                "Hence if you want it to move for 1 minutes please enter 6 " +
                "as the number of time the cursor should move \n\n" +
                "6 times = 1 minute \n" +
                "60 times = 10 minute \n" +
                "360 times = 1 hour \n" +
                "720 times  = 2 hour");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many time should the cursor move : ");
        int times = myObj.nextInt();  // Read user input

        new MouseMover().changeCursorLocation(times);

    }

    public synchronized void changeCursorLocation(int times){
        try {
            Robot robot = new Robot();
            // width and height of the screen
            final int width = 1024;
            final int height = 720;
            int movement = 0;
            long counter = 0;

            while (counter <= times){
                //mouse will move in every 10 seconds
                this.wait(10000);
                counter++;
                System.out.println("Cursor has moved " + (movement = movement + 1) + " times already !");
                robot.mouseMove((int)(Math.random()*width), (int)(Math.random()*height));
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
