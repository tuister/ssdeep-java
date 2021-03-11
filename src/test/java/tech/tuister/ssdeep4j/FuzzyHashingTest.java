package tech.tuister.ssdeep4j;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FuzzyHashingTest {

    // 24576:5Z4U4FlmZzZVEGS3X1OmS2NpHpw3VQJgGMQ5EA7hxlWv5RWhD:5Z4nFkZ1Vs3XtJw3WJgGMQ5EA7hxOWhD
    static final File file1 = new File("D:\\Program Files\\OpenVPN\\bin\\openssl.exe");

    // 768:EJsfx1myHFtreIPhSO33vJsaVUuyQ4tmrROOaqh:Vx4hK33Bp34wrkqh
    static final File file2 = new File("D:\\opensource\\ssdeep-release-2.14.1\\fuzzy.c");

    @Test
    public void fuzzyHash() throws IOException {
        byte[] text = readFile(file2);
        String hash = FuzzyHashing.fuzzyHash(text);
        System.out.println(hash);
        Assert.assertEquals("768:EJsfx1myHFtreIPhSO33vJsaVUuyQ4tmrROOaqh:Vx4hK33Bp34wrkqh", hash);
    }

    @Test
    public void testFuzzyHash() throws Exception {
        byte[] text = readFile(file1);
        String hash = FuzzyHashing.fuzzyHash(text);
        System.out.println(hash);
        Assert.assertEquals("24576:5Z4U4FlmZzZVEGS3X1OmS2NpHpw3VQJgGMQ5EA7hxlWv5RWhD:5Z4nFkZ1Vs3XtJw3WJgGMQ5EA7hxOWhD", hash);
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
    }

    @Test
    public void stripEndZero() {
    }


    static byte[] readFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[2048];

            int len = fis.read(buf);
            while (len > 0) {
                byteArrayOutputStream.write(buf, 0, len);
                len = fis.read(buf);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }
}