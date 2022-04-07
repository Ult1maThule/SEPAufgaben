import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int getInt() {
        return scanner.nextInt();
    }

    public Boolean noNumber() {
        Boolean noNumber = false;

        if (scanner.hasNextInt()) {
            noNumber = true;
        }

        return noNumber;
    }
}
