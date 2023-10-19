import java.util.Scanner;
class InvalidTimeException extends Exception {
    public InvalidTimeException() {
    }
    public InvalidTimeException(String msg) {
        super(msg);
    }
}
public class Lab10 {
    public static int convertTime(String time) throws InvalidTimeException {
        String tokens[] = time.split(":");
        if (tokens.length != 3) {
            throw new InvalidTimeException("Enter a valid time");
        }
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);
        if (hours < 0) throw new InvalidTimeException("Hours must be positive.");
        if (hours > 23) throw new InvalidTimeException("Hours must be below 24.");
        if (minutes < 0) throw new InvalidTimeException("Minutes must be positive.");
        if (minutes > 59) throw new InvalidTimeException("Minutes must be below 60.");
        if (seconds < 0) throw new InvalidTimeException("Seconds must be positive.");
        if (seconds > 59) throw new InvalidTimeException("Seconds must be below 60.");
        return hours * 60 * 60 + minutes * 60 + seconds;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time;
        int seconds1, seconds2, difference;
        try {
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            time = sc.nextLine();
            seconds1 = convertTime(time);
            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            time = sc.nextLine();
            seconds2 = convertTime(time);
            if (seconds1 > seconds2) difference = seconds1 - seconds2;
            else difference = seconds2 - seconds1;
            System.out.println("Difference in seconds: " + difference);
        } catch (InvalidTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
