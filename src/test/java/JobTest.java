import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import root.BatchApplication;

@SpringBootTest(classes = BatchApplication.class)
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
