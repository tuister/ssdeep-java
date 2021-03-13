package tech.tuister.ssdeep4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author tuister 2021/3/13 11:35
 * @version 1.0.0
 * @since 1.0.0
 */
public class Fuzzy {

    public static void main(String[] args) throws Exception{

        if (args == null || args.length == 0) {
            System.out.println("Usage: java -jar ssdeep-java.jar path");
            System.exit(-1);
        }

        for (String arg : args) {
            Path path = Paths.get(arg);
            if (Files.isDirectory(path)) {
                System.out.println(arg + ": Is a directory");
            } else {
                String s = FuzzyHashing.fuzzyHashFilename(arg);
                System.out.println(s + ",\"" + path.toFile().getCanonicalPath() + "\"");
            }
        }

    }
}
