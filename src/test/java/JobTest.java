import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import root.BatchApplication;
import root.batch.job001.JobConfiguration;

@SpringBatchTest
@SpringBootTest(classes = BatchApplication.class)
@ContextConfiguration(classes = { JobConfiguration.class })
public class JobTest {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    Job testJob;

    @Test
    void testJob() throws Exception {
        System.out.println("------------- Начало теста -------------------");
        jobLauncher.run(testJob, new JobParameters());
    }
}
