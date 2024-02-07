package root.batch.job001;

import org.springframework.batch.item.ItemWriter;

import java.util.Arrays;
import java.util.List;

public class MyItemWriter implements ItemWriter {

    @Override
    public void write(List items) throws Exception {
        System.out.println("--- MyItemWriter");
        System.out.println("    На вход пришло: " + Arrays.toString(items.toArray()));

    }
}
