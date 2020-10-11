import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() {
        int numOfMsg = 0;

        try {
            while (!Thread.currentThread().isInterrupted() && numOfMsg != 2) {
                numOfMsg++;
                System.out.printf("Привет, работает %s\n", Thread.currentThread().getName());
                System.out.println(numOfMsg);
                Thread.currentThread().sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return numOfMsg;
    }
}
