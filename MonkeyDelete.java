public class MonkeyDelete implements Runnable{
    @Override
    public void run() {
                // lock typewriter
                Experiment.lock.lock();

                System.out.println(Thread.currentThread().getName() + " monkey hit backspace");
                Experiment.typewriter.remove(Experiment.typewriter.size() - 1);

                // unlock typewriter
                Experiment.lock.unlock();
            }
}
