package recursive;

public class Demo {
    private static Demo ourInstance = new Demo();

    public static Demo getInstance() {
        return ourInstance;
    }

    private Demo() {
    }
}
