import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// class to create and define experiment behaviour
public class Experiment {

    public static List<Character> typewriter;

    public Thread monkeyGroup;
    public int duration;

    public static ReentrantLock lock;

    public Experiment(int groupSize, int duration){
        lock = new ReentrantLock();
        typewriter = new ArrayList<Character>();
        monkeyGroup = new Thread(new MonkeyGroup(groupSize));
        this.duration = duration;   // length of experiment in ms
    }

    public void begin(){
        System.out.println("Experiment beginning!");

        // start sending monkey thread pool tasks
        monkeyGroup.start();

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // end experiment
        monkeyGroup.interrupt();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Experiment has now ended\n\nThe monkeys have typed: \n\"");
        for (int i = 1; i <= typewriter.size(); i++) {

            // formatting
            if (i % 65 == 0){ System.out.println("");}

            System.out.print(typewriter.get(i-1));
        }
        System.out.println("\"");
    }
}
