package root.batch;

import org.springframework.batch.item.ItemProcessor;

public class MyItemProcessor implements ItemProcessor<Object, Object> {

    @Override
    public Object process(Object item) throws Exception {
        System.out.println("--- MyItemProcessor");
        System.out.println("    Считанная строка = " + item);
        return item;
    }
}
