package root.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyEvenItemProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String item) throws Exception {
        System.out.println("    Считанная строка четная = " + item);
        return item;
    }
}
