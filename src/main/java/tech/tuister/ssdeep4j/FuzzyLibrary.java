package tech.tuister.ssdeep4j;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author tuister 2021/3/11 20:31
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FuzzyLibrary extends Library {
    int SPAMSUM_LENGTH = 64;
    int FUZZY_MAX_RESULT = 2 * SPAMSUM_LENGTH + 20;

    FuzzyLibrary INSTANCE = Native.load("fuzzy", FuzzyLibrary.class);

    /**
     * Compute the fuzzy hash of a buffer<br>
     * * The computes the fuzzy hash of the first buf_len bytes of the buffer.<br>
     * It is the caller's responsibility to append the filename,<br>
     * if any, to result after computation.<br>
     *
     * @param buf     The data to be fuzzy hashed<br>
     * @param buf_len The length of the data being hashed<br>
     * @param result  Where the fuzzy hash of buf is stored. This variable<br>
     *                must be allocated to hold at least FUZZY_MAX_RESULT bytes.<br>
     * @return Returns zero on success, non-zero on error.<br>
     */
    int fuzzy_hash_buf(byte[] buf, int buf_len, byte[] result);

    /**
     * Compute the fuzzy hash of a file
     * <p>
     * Opens, reads, and hashes the contents of the file 'filename'
     * The result must be allocated to hold FUZZY_MAX_RESULT characters.
     * It is the caller's responsibility to append the filename
     * to the result after computation.
     *
     * @param filename The file to be hashed
     * @param result   Where the fuzzy hash of the file is stored. This
     *                 variable must be allocated to hold at least FUZZY_MAX_RESULT bytes.
     * @return Returns zero on success, non-zero on error.
     */
    int fuzzy_hash_filename(String filename, byte[] result);

    /**
     * Computes the match score between two fuzzy hash signatures.
     *
     * @param sig1 fuzzy hash 1
     * @param sig2 fuzzy hash 2
     * @return Returns a value from zero to 100 indicating the match score of the
     * two signatures. A match score of zero indicates the signatures
     * did not match. When an error occurs, such as if one of the
     * inputs is NULL, returns -1.
     */
    int fuzzy_compare(String sig1, String sig2);

}
