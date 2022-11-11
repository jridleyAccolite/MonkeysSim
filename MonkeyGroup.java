import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// class to model a group of monkeys working to interact with typewriters
public class MonkeyGroup implements Runnable{

    public ExecutorService monkeys;
    public Random r;

    public MonkeyGroup(int size){
        System.out.println("Created a group of " + size + " monkeys.");
        monkeys = Executors.newFixedThreadPool(size);
        r = new Random();
    }

    @Override
    public void run() {
        while(true) {
            // start randomly assigning tasks
            if (r.nextInt(4) != 0) {
                monkeys.submit(new MonkeyWrite());
            } else {
                monkeys.submit(new MonkeyDelete());
            }

            try {
                Thread.sleep(r.nextInt(10, 80));    // stagger commands
            } catch (InterruptedException e) {
                monkeys.shutdown();
                break;
                //throw new RuntimeException(e);
            }
        }
    }

    public void inputKey(){
        System.out.println(Thread.currentThread().getName() + " monkey entered a character");
    }

    public void backspace(){
        System.out.println(Thread.currentThread().getName() + " monkey hit backspace");
    }
}
