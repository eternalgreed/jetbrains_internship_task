import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoaderOptimizerTest {
    LoaderOptimizer loaderOptimizer;

    @Before
    public void setUp() throws Exception {
        loaderOptimizer = new LoaderOptimizer();
    }

    @Test
    public void maximizeEarning() {
        List<Train> trainList = new ArrayList<>(Arrays.asList(new Train(1, 100, 50, 20),  new Train(2, 110, 40, 30),  new Train(3, 120, 30, 5), new Train(4, 140, 10, 80)));
        int actualAnswer = loaderOptimizer.maximizeEarning(trainList);
        int expectedAnswer = 80;
        assertEquals(actualAnswer, expectedAnswer);
    }

}