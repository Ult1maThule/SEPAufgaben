public class Launcher {
    public static void main(String[] args) throws NoNumberException {
        Input input = new Input();
        Calculator calculator = new Calculator();
        Display display = new Display();

        display.getFirstInt();

        if (!input.noNumber()) {
            throw new NoNumberException("Erste Eingabe enthält keinen Integerwert!");
        }

        int firstInt = input.getInt();

        display.getSecondInt();

        if (!input.noNumber()) {
            throw new NoNumberException("Zweite Eingabe enthält keinen Integerwert!");
        }

        int secondInt = input.getInt();

        int result = calculator.calculate(firstInt, secondInt);
        display.showResult(result);
    }
}
