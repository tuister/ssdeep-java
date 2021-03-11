package tech.tuister.ssdeep4j;

import java.io.File;

/**
 * @author tuister 2021/3/11 20:34
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FuzzyHashing {
    int SPAMSUM_LENGTH = 64;
    int FUZZY_MAX_RESULT = 2 * SPAMSUM_LENGTH + 20;

    static String fuzzyHash(byte[] data) {
        byte[] result = new byte[FUZZY_MAX_RESULT];
        int status = FuzzyLibrary.INSTANCE.fuzzy_hash_buf(data, data.length, result);
        System.out.println(new String(result));
        //success
        if (status == 0) {
//            return new String(result);
            return stripEndZero(result);
        }
        return null;
    }


    static String fuzzyHashFile(File file) {
        return fuzzyHashFilename(file.getAbsolutePath());
    }

    static String fuzzyHashFilename(String filename) {
        byte[] result = new byte[FUZZY_MAX_RESULT];

        int status = FuzzyLibrary.INSTANCE.fuzzy_hash_filename(filename, result);
        if (status == 0) {
            return stripEndZero(result);
        }
        return null;
    }

    static int fuzzyCompare(String hash1, String hash2) {
        return FuzzyLibrary.INSTANCE.fuzzy_compare(hash1, hash2);
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
