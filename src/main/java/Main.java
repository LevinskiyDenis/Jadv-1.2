import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final ExecutorService threadPool = Executors.newFixedThreadPool(4);

        final MyCallable myCallable = new MyCallable();
        final MyCallable myCallable2 = new MyCallable();
        final MyCallable myCallable3 = new MyCallable();
        final MyCallable myCallable4 = new MyCallable();

        ArrayList<MyCallable> tasks = new ArrayList<>();
        tasks.add(myCallable);
        tasks.add(myCallable2);
        tasks.add(myCallable3);
        tasks.add(myCallable4);

        final int resultOfAnyTask = threadPool.invokeAny(tasks);
        List<Future<Integer>> resultsOfTasks = threadPool.invokeAll(tasks);

        System.out.println("Результаты одного таска");
        System.out.println(resultOfAnyTask);
        System.out.println("Результаты всех тасков");
        for (int i = 0; i < resultsOfTasks.size(); i++) {
            System.out.println(resultsOfTasks.get(i).get());
        }
        System.out.println("Завершаю работу пула");
        threadPool.shutdown();
    }
}
