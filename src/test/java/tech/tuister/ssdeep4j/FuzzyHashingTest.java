package tech.tuister.ssdeep4j;

import org.junit.Assert;
import org.junit.Test;
import tech.tuister.ssdeep4j.util.Utils;

import java.io.IOException;

public class FuzzyHashingTest implements TestData {


    @Test
    public void fuzzyHash() throws IOException {
        byte[] text = Utils.readFile(file2);
        String hash = FuzzyHashing.fuzzyHash(text);
        System.out.println(hash);
        Assert.assertEquals(hash2, hash);
    }

    @Test
    public void fuzzy_hash_buf() throws Exception {
        byte[] data = Utils.readFile(file3);
        byte[] result = new byte[148];
        int status = FuzzyLibrary.INSTANCE.fuzzy_hash_buf(data, data.length, result);

        int count = 100;
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            FuzzyLibrary.INSTANCE.fuzzy_hash_buf(data, data.length, result);
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println("AverageCost: " + (cost / count));


        System.out.println(Utils.stripEndZero(result));


    }

    @Test
    public void testFuzzyHash() throws Exception {
        byte[] text = Utils.readFile(file1);
        String hash = FuzzyHashing.fuzzyHash(text);
        System.out.println(hash);
        Assert.assertEquals(hash1, hash);
    }

    @Test
    public void fuzzyHashFile() {
        String hash = FuzzyHashing.fuzzyHashFile(file1);
        System.out.println(hash);
    }

    @Test
    public void fuzzyHashFilename() {
        String s = FuzzyHashing.fuzzyHashFilename(file1.getAbsolutePath());
        System.out.println(s);
    }

    @Test
    public void fuzzyCompare() {
        System.out.println(FuzzyHashing.fuzzyCompare(hash1, hash2));
        System.out.println(FuzzyHashing.fuzzyCompare(hash2, hash2));
        System.out.println(FuzzyHashing.fuzzyCompare(hash1, hash1));
        System.out.println(FuzzyHashing.fuzzyCompare(hash2, hash1));

    }

    @Test
    public void stripEndZero() {
        byte[] data = new byte[]{
                '1', '2', '3', 0, 0, 0, 0, 0
        };
        System.out.println(Utils.stripEndZero(data));
    }


}