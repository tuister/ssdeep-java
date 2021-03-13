package tech.tuister.ssdeep4j;

import org.junit.Assert;
import org.junit.Test;
import tech.tuister.ssdeep4j.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tuister 2021/3/11 22:15
 * @version 1.0.0
 * @since 1.0.0
 */
public class ThreadSafeTest implements TestData {

    static void test() throws IOException {
        byte[] data = Utils.readFile(file2);
        String hash = FuzzyHashing.fuzzyHash(data);
        System.out.println(hash);
        Assert.assertEquals(hash2, hash);
    }

    @Test
    public void testThreadSafe() throws Exception {
        int n = 100;

        List<Runnable> tasks = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tasks.add(() -> {
                try {
                    test();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }

        for (Runnable task : tasks) {
            new Thread(task).start();
        }

        Thread.sleep(1000 * 10);
    }
}
