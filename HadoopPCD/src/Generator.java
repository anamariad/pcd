import org.apache.commons.lang.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class Generator {

    public static void main(String[] args) throws IOException {
        List<String> subjects = Arrays.asList("mate", "bio", "info");
        Set<String> names = new HashSet<String>() {{

            for (int i = 0; i < 10000; i++) {
                add(RandomStringUtils.randomAlphabetic(4));
            }

        }
        };

        Writer writer = new BufferedWriter(new FileWriter("test2"));
        Random rand = new Random();
        double min = 4.0;
        double max = 10.0;
        for (String subject : subjects) {
            for (String name : names) {
                double grade = min + Math.random() * (max - min);
                writer.write(String.format("%s,%s,%.2f", subject, name, grade));
                writer.write(System.lineSeparator());
            }
        }
        writer.close();

    }
}
