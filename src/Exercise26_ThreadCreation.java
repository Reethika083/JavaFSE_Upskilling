class MessagePrinter extends Thread {
    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - Count: " + i);
            try {
                Thread.sleep(500); // Pause for 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        }
    }
}

public class Exercise26_ThreadCreation {
    public static void main(String[] args) {
        MessagePrinter thread1 = new MessagePrinter("Thread 1 says Hi!");
        MessagePrinter thread2 = new MessagePrinter("Thread 2 waves Hello!");

        thread1.start();
        thread2.start();
    }
}
