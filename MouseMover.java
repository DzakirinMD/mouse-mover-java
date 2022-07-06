import java.awt.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

/**
 * Datatime Formatter: https://www.javatpoint.com/java-localdatetime#:~:text=Java%20LocalDateTime%20class%20is%20an,%2DHH%2Dmm%2Dss.
 * How to calculate time : https://www.callicoder.com/how-to-add-subtract-days-hours-minutes-seconds-to-date-java/
 */
public class MouseMover {

    public static void main(String[] args) {

        System.out.println("=====================================\n" +
                "Welcome to mouse mover program !!! \n" +
                "=====================================\n" +
                "The cursor/mouse will move in every 10 seconds.\n");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter how many minutes (int) should the cursor move : ");
        int minutes = myObj.nextInt();  // Read user input

        new MouseMover().changeCursorLocation(minutes);
    }

    public synchronized void changeCursorLocation(int minutes){

        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(LocalTime.now().format(format));
        System.out.println("Current time is : " + time);

        // Add hours, minutes, or seconds
        LocalTime newTime = time.plusMinutes(minutes);
        System.out.println("The time when program will end is : " + newTime);

        int returnVal = time.compareTo(newTime);

        try {
            Robot robot = new Robot();
            // width and height of the screen
            final int width = 1024;
            final int height = 720;
            int movement = 0;
            long counter = 0;

            while (time.compareTo(newTime) < 0){

                time = LocalTime.parse(LocalTime.now().format(format));
                if (returnVal > 0) {
                    System.out.println("Current time while program is running : " + time);
                }else if (returnVal == 0) {
                    System.out.println("Current time while program is running : " + time);
                }else {
                    System.out.println("Current time while program is running : " + time);
                }

                //mouse will move in every 10 seconds
                this.wait(10000);
//                counter++;
//                System.out.println("Cursor has moved " + (movement = movement + 1) + " times already !");
                robot.mouseMove((int)(Math.random()*width), (int)(Math.random()*height));
            }

//            while (counter <= times){
//                //mouse will move in every 10 seconds
//                this.wait(10000);
//                counter++;
//                System.out.println("Cursor has moved " + (movement = movement + 1) + " times already !");
//                robot.mouseMove((int)(Math.random()*width), (int)(Math.random()*height));
//            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
