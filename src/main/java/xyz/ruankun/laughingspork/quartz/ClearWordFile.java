package xyz.ruankun.laughingspork.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;


@Service
public class ClearWordFile {
    public static final Logger logger = LoggerFactory.getLogger(ClearWordFile.class);

    //    每天五点删除一天前的文章
    @Scheduled(cron = "0 0 5 * * ?")
    public void ClearFile() {
        try {
            final long interval = 24 * 360000;
            long now = new Date().getTime();
            File file = new File(System.getProperty("user.dir") + "\\static\\");
            if (file.exists()) {
                File[] fileList = file.listFiles();
                for (File f : fileList
                ) {
                    logger.info(f.getPath());
                    if ((now - f.lastModified()) / interval > 0) f.delete();
                }
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }
}
