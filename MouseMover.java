import java.awt.*;

public class MouseMover {

    public static void main(String[] args) {
        new MouseMover().changeCursorLocation();
    }

    public synchronized void changeCursorLocation(){
        try {
            Robot robot = new Robot();
            // width and height of the screen
            final int width = 1024;
            final int height = 720;
            long counter = 0;
            while (true){
                //mouse will move in every 10 seconds
                this.wait(10000);
                System.out.println("Cursor has moved " + (counter = counter + 1) + " times already !");
                robot.mouseMove((int)(Math.random()*width), (int)(Math.random()*height));
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
