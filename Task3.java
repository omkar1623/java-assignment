import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {
     public static void main(String[] args) {

        System.out.println("Task3 compiled successfully");
    }

    // FIX: AtomicInteger used to make processedCount thread-safe
    private AtomicInteger processedCount = new AtomicInteger(0);

    public void process(List<StatementRecord> records) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {

            executor.submit(() -> {

                processRecord(record);

                // FIX: incrementAndGet() prevents race condition
                processedCount.incrementAndGet();
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }

    public int getProcessedCount() {

        // FIX: Safely return AtomicInteger value
        return processedCount.get();
    }

    private void processRecord(StatementRecord record) {

        // Dummy processing logic
    }
}

class StatementRecord {

}