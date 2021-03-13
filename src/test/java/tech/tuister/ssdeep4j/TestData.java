package tech.tuister.ssdeep4j;

import java.io.File;

/**
 * @author tuister 2021/3/13 11:01
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TestData {
    static final File file1 = new File("D:\\Program Files\\OpenVPN\\bin\\openssl.exe");
    static final String hash1 = "24576:5Z4U4FlmZzZVEGS3X1OmS2NpHpw3VQJgGMQ5EA7hxlWv5RWhD:5Z4nFkZ1Vs3XtJw3WJgGMQ5EA7hxOWhD";

    static final File file2 = new File("D:\\opensource\\ssdeep-release-2.14.1\\fuzzy.c");
    static final String hash2 = "768:EJsfx1myHFtreIPhSO33vJsaVUuyQ4tmrROOaqh:Vx4hK33Bp34wrkqh";

    static final File file3 = new File("D:\\Downloads\\mingw-w64-v6.0.0.tar.bz2");
}
