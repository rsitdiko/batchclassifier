package root.batch.job001;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyOddItemProcessor implements ItemProcessor<Object, Object> {

    @Override
    public Object process(Object item) throws Exception {
        System.out.println("--- MyOddItemProcessor");
        System.out.println("    Считанная строка нечетная = " + item);
        return item;
    }
}
