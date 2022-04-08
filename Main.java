public class Main {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Counter("First: "));
        Thread threadTwo = new Thread((new Counter("Second: ")));

        threadOne.start();
        threadTwo.start();
    }
}
