package tech.tuister.ssdeep4j;

import java.io.File;

import static tech.tuister.ssdeep4j.util.Utils.stripEndZero;

/**
 * @author tuister 2021/3/11 20:34
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FuzzyHashing extends FuzzyLibrary {

    static String fuzzyHash(byte[] data) {
        byte[] result = new byte[FUZZY_MAX_RESULT];
        int status = INSTANCE.fuzzy_hash_buf(data, data.length, result);
        //success
        if (status == 0) {
            return stripEndZero(result);
        }
        return null;
    }


    static String fuzzyHashFile(File file) {
        return fuzzyHashFilename(file.getAbsolutePath());
    }

    static String fuzzyHashFilename(String filename) {
        byte[] result = new byte[FUZZY_MAX_RESULT];

        int status = INSTANCE.fuzzy_hash_filename(filename, result);
        if (status == 0) {
            return stripEndZero(result);
        }
        return null;
    }

    static int fuzzyCompare(String hash1, String hash2) {
        return INSTANCE.fuzzy_compare(hash1, hash2);
    }


}
