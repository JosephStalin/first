package com.epam.training.first;

import com.epam.training.first.shapes.CircleBuilder;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;


public class ReadFromFile {
    private static Logger logger = Logger.getLogger(ReadFromFile.class);

    public static void readFromFile(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(s -> {
                        try {
                            System.out.println(CircleBuilder.createCircle(Arrays.stream(s.split(" "))
                                    .mapToInt(Integer::parseInt).toArray()));

                        } catch(NumberFormatException e) {
                            logger.error(e);
                        }
                    });
        } catch (IOException e) {
            logger.error(e);
        }
    }

}
