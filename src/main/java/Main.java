import java.util.*;

public class Main {
    public static void main(String[] args) {
        Train[] trainArray = new Train[]{ new Train(1, 100, 30, 20),  new Train(2, 110, 50, 30),  new Train(3, 160, 20, 5), new Train(4, 180, 20, 20)};
       /* int n = 1000000; count of trains to generate
        Train[] array = new Train[n];
        for (int i = 0; i < n; i++) {
           array[i] = new Train();
        }*/
        List<Train> trains = new ArrayList<>(Arrays.asList(trainArray));
        // List<Train> trainsGenerated = new ArrayList<>(Arrays.asList(array));
        System.out.println("MaximizedEarnings = " + new LoaderOptimizer().maximizeEarning(trains));
    }
}

