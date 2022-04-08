public class Counter implements Runnable{
    private String name;

    public Counter(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=1; i<1000; i++) {
            System.out.println(name + i);
        }
    }
}
