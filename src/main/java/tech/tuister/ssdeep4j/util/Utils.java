package tech.tuister.ssdeep4j.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author tuister 2021/3/13 10:22
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Utils {

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

    static String stripEndZero(byte[] bytes) {
        int index = 0;
        for (int i = bytes.length - 1; i >= 0; i--) {
            if (bytes[i] != 0) {
                index = i;
                break;
            }
        }
        return new String(bytes, 0, index + 1);
    }
}
