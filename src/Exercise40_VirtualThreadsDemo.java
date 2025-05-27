public class Exercise40_VirtualThreadsDemo {

    public static void main(String[] args) throws InterruptedException {
        final int THREAD_COUNT = 100_000;

        System.out.println("Starting " + THREAD_COUNT + " virtual threads...");

        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                // Just a tiny message (comment out to reduce console spam)
                // System.out.println("Hello from virtual thread!");
            });
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();

        System.out.println("Completed " + THREAD_COUNT + " virtual threads in " + (end - start) + " ms");
    }
}
