package root.batch.job001;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.classify.Classifier;
import org.springframework.stereotype.Component;

@Component
public class MyClassifier implements Classifier<Object, ItemProcessor<?, ?>> {

    @Autowired
    private MyEvenItemProcessor evenItemProcessor;

    @Autowired
    private MyOddItemProcessor oddItemProcessor;

    @Override
    public ItemProcessor<?, ? extends Object> classify(Object incomingString) {
        return isOdd(incomingString) ? oddItemProcessor : evenItemProcessor;
    }

    private boolean isOdd(Object incomingString) {
        return Integer.parseInt(((String)incomingString).split("_")[1]) % 2 != 0;
    }

}