package com.smt.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SmtRequestTimerScheduler {

  private Logger logger = LoggerFactory.getLogger(SmtRequestTimerScheduler.class);

  //TODO timer gruplarina gore List<SmtRequest> alinarak ilgili request cagrilip logic islenecek

//  @Scheduled(cron = "0 */5 * * * *")
//  public void request5Minute() {
//    logger.info("The time is now: " + LocalDateTime.now());
//
//  }
//
//  @Scheduled(cron = "0 */10 * * * *")
//  public void request10Minute() {
//    logger.info("The time is now: " + LocalDateTime.now());
//
//  }
//
//  @Scheduled(cron = "0 */15 * * * *")
//  public void request15Minute() {
//    logger.info("The time is now: " + LocalDateTime.now());
//
//  }
//
//  @Scheduled(cron = "0 */30 * * * *")
//  public void request30Minute() {
//    logger.info("The time is now: " + LocalDateTime.now());
//
//  }
//
//  @Scheduled(cron = "0 0 */1 * * *")
//  public void request1Hour() {
//    logger.info("The time is now: " + LocalDateTime.now());
//
//  }
//
//  @Scheduled(cron = "0 0 */6 * * *")
//  public void request6Hour() {
//    logger.info("The time is now: " + LocalDateTime.now());
//
//  }
//
//  @Scheduled(cron = "0 0 */12 * * *")
//  public void request12Hour() {
//    logger.info("The time is now: " + LocalDateTime.now());
//
//  }
//
//  @Scheduled(cron = "0 0 */24 * * *")
//  public void request24Hour() {
//    logger.info("The time is now: " + LocalDateTime.now());
//
//  }
}