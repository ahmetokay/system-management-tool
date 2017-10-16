package com.smt.timer;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SmtRequestTimerScheduler {

  private Logger logger = LoggerFactory.getLogger(SmtRequestTimerScheduler.class);

  @Scheduled(cron = "0 */1 * * * *")
  public void request() {
    logger.info("The time is now: " + LocalDateTime.now());

    //TODO timer gruplarina gore List<SmtRequest> alinarak ilgili request cagrilip logic islenecek

  }
}