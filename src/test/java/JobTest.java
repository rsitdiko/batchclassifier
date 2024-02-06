import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import root.BatchApplication;

@SpringBatchTest
@SpringBootTest(classes = BatchApplication.class)
public class JobTest {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Test
    void testJob() throws Exception {
        jobLauncher.run(job, new JobParameters());
    }
}
