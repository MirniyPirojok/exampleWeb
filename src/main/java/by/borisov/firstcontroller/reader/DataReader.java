package by.borisov.firstcontroller.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class DataReader {
    static Logger logger = LogManager.getLogger();

    public String readData(String filePath) {
        logger.info("Data reader started to work.");

        File file = new File(getClass().getClassLoader().getResource(filePath).getFile());

        String text = "";
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            text = bufferedReader.lines().collect(Collectors.joining(" "));
        } catch (IOException e) {
            logger.error("Cannot read file.", e);
        }

        logger.info("Data reader finished to work.");
        return text;
    }
}
