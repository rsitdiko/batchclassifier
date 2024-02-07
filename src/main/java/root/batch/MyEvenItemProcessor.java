package root.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyEvenItemProcessor implements ItemProcessor<Object, Object> {

    @Override
    public Object process(Object item) throws Exception {
        System.out.println("--- MyEvenItemProcessor");
        System.out.println("    Считанная строка четная = " + item);
        return item;
    }
}
