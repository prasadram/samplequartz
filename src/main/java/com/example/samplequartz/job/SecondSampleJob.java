package com.example.samplequartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SecondSampleJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(SecondSampleJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.info("SecondSampleJob executed at: {}", timestamp);
        logger.info("Job Key: {}", jobExecutionContext.getJobDetail().getKey());
    }
}
