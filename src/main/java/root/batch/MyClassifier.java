package root.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.classify.Classifier;
import org.springframework.stereotype.Component;

@Component
public class MyClassifier implements Classifier<String, ItemProcessor<String, String>> {

    @Autowired
    private MyEvenItemProcessor evenItemProcessor;

    @Autowired
    private MyOddItemProcessor oddItemProcessor;

    @Override
    public ItemProcessor<String, String> classify(String incomingString) {
        return isOdd(incomingString) ? oddItemProcessor : evenItemProcessor;
    }

    private boolean isOdd(String incomingString) {
        return Integer.parseInt(incomingString.split("_")[1]) % 2 != 0;
    }
}
