package root.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MyOddItemProcessor oddItemProcessor;

    @Autowired
    private MyEvenItemProcessor evenItemProcessor;

    @Autowired
    private MyClassifier myClassifier;

    @Bean
    public Job testJob() throws Exception {
        return jobBuilderFactory.get("testJob")
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() throws Exception {
        return stepBuilderFactory.get("step1")
                .allowStartIfComplete(true)
                .chunk(3)
                .reader(reader())
                .processor(classifierItemProcessor())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemReader reader() {
        return new MyItemReader();
    }

    @Bean
    public MyItemProcessor processor() {
        return new MyItemProcessor();
    }

    @Bean
    public ItemWriter writer() {
        return new MyItemWriter();
    }

    @Bean
    public ClassifierCompositeItemProcessor<Object, Object> classifierItemProcessor() throws Exception {
        return new ClassifierCompositeItemProcessorBuilder<>()
                .classifier(classifier())
                .build();
    }

    private Classifier<? super Object, ItemProcessor<?, ?>> classifier() {
        return new Classifier<Object, ItemProcessor<?, ?>>() {
            @Override
            public ItemProcessor<?, ? extends Object> classify(Object classifiable) {

                boolean isOdd = Integer.parseInt(((String) classifiable).split("_")[1]) % 2 != 0;

                if (isOdd){
                    return oddItemProcessor;
                }  else {
                    return evenItemProcessor;
                }
            }
        };
    }



}
