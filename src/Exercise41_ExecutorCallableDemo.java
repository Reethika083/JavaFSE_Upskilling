import java.util.concurrent.*;
import java.util.*;

public class Exercise41_ExecutorCallableDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create a list of Callable tasks
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(() -> {
            Thread.sleep(1000);
            return "Task 1 done!";
        });
        tasks.add(() -> {
            Thread.sleep(500);
            return "Task 2 done!";
        });
        tasks.add(() -> {
            Thread.sleep(700);
            return "Task 3 done!";
        });

        // Submit all tasks and get Futures
        List<Future<String>> futures = executor.invokeAll(tasks);

        // Collect and print results
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        // Shutdown executor
        executor.shutdown();
    }
}
