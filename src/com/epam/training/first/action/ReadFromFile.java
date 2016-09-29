package com.epam.training.first.action;

import com.epam.training.first.builder.CircleBuilder;
import com.epam.training.first.entity.Circle;
import com.epam.training.first.exception.NotCircleException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;


public class ReadFromFile {
    private static Logger logger = Logger.getLogger(ReadFromFile.class);

    public static ArrayList<Circle>  readFromFile(String filename) {
        ArrayList<Circle> circleList = null;
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(s -> {
                try {
                    circleList.add(new CircleBuilder(Arrays.stream(s.split(" "))
                            .mapToInt(Integer::parseInt).toArray()).build());
                } catch (NumberFormatException | NotCircleException e) {
                    logger.error(e);
                }
            });
        } catch (IOException e) {
            logger.error(e);
        }
        return circleList;
    }

}
