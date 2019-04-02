package undestiny.springboot;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //初始化时延迟1s执行，每隔5s执行一次
    @Scheduled(initialDelay = 1000,fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("currentTime：" + dateFormat.format(new Date()));
    }

}
