# ssdeep-java

ssdeep-java is a JNA wrapper for SSDeep(Fuzzy hashing)

> ssdeep is thread safe

## Usage

```xml

<dependency>
    <groupId>tech.tuister</groupId>
    <artifactId>ssdeep-java</artifactId>
    <version>0.0.1</version>
</dependency>
```

```java

public class Main {
    public static void main(String[] args) {
        byte[] text = Utils.readFile(new File("/tmp/test.doc"));
        String hash = FuzzyHashing.fuzzyHash(text);
        System.out.println(hash);
    }
}

```

**Demo:**

[FuzzyHashingTest](src/test/java/tech/tuister/ssdeep4j/FuzzyHashingTest.java)

## Performance

TODO

