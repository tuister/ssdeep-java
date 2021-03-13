package tech.tuister.ssdeep4j;

import org.junit.Assert;
import org.junit.Test;
import tech.tuister.ssdeep4j.util.Utils;

public class FuzzyLibraryTest implements TestData {
    static FuzzyLibrary F = FuzzyLibrary.INSTANCE;

    @Test
    public void testFuzzyHashBuf() throws Exception {
        byte[] data = Utils.readFile(file1);
        byte[] result = new byte[FuzzyLibrary.FUZZY_MAX_RESULT];
        int status = F.fuzzy_hash_buf(data, data.length, result);
        System.out.println(status);
        Assert.assertEquals(hash1, Utils.stripEndZero(result));
    }


    @Test
    public void testFuzzyHashFilename() throws Exception {
        byte[] result = new byte[FuzzyLibrary.FUZZY_MAX_RESULT];
        int status = F.fuzzy_hash_filename(file1.getAbsolutePath(), result);
        System.out.println(status);
        Assert.assertEquals(hash1, Utils.stripEndZero(result));
    }

    @Test
    public void testFuzzyCompare() throws Exception {
        String hash = "768:EJsfx1myHFtrfasdSO33vJsaVUuyQ4tmrROOaqh:Vx4hKfssp34wrkqh";


        int distance = F.fuzzy_compare(hash, hash2);
        System.out.println(distance);
        int distance2 = F.fuzzy_compare(hash1, hash1);
        Assert.assertEquals(100, distance2);
    }
}