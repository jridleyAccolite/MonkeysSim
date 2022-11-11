import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MonkeyWrite implements Runnable{
    // adds a character to typewriter

    // typewriter reference == Experiment.typewriter


    @Override
    public void run() {

            /* just using synchronized() but not lock, resulted in occassional
            ConcurrentModificationException */

            // lock typewriter
            Experiment.lock.lock();

            // update typewriter
            Random r = new Random();
            char c = (char) r.nextInt(97, 124);
            if (c == '{') {
                c = ' ';
            }
            System.out.println(Thread.currentThread().getName() + " monkey entered " + c);
            Experiment.typewriter.add(c);

            // unlock typewriter
            Experiment.lock.unlock();
    }
}
