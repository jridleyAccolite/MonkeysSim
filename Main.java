import java.util.ArrayList;
import java.util.List;

// Simulator of a group of monkeys typing on a typewriter
public class Main {
    public static void main(String[] args) {
        // enter how many desired monkeys in group and length of experiment in ms
        Experiment experiment = new Experiment(9, 10000);

        experiment.begin();
    }
}
