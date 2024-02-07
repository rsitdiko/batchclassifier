package root.batch.job001;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class MyItemReader implements ItemReader {

    BufferedReader reader;
    {
        try {
            reader = new BufferedReader(new FileReader("/Users/20258467/IdeaProjects/batchclassifier/src/main/resources/testData"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("--- MyItemReader");

        String line = reader.readLine();

        if (line == null) {
            reader.close();
        }

        return line;
    }
}
