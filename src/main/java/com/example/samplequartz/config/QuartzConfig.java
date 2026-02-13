package com.example.samplequartz.config;

import com.example.samplequartz.job.FirstSampleJob;
import com.example.samplequartz.job.SecondSampleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail firstSampleJobDetail() {
        return JobBuilder.newJob(FirstSampleJob.class)
                .withIdentity("firstSampleJob", "sampleGroup")
                .withDescription("First sample job that log messages")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger firstSampleJobTrigger(JobDetail firstSampleJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(firstSampleJobDetail)
                .withIdentity("firstSampleJobTrigger", "sampleGroup")
                .withDescription("Trigger for first sample job - runs every 30 seconds")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
                .build();
    }

    @Bean
    public JobDetail secondSampleJobDetail() {
        return JobBuilder.newJob(SecondSampleJob.class)
                .withIdentity("secondSampleJob", "sampleGroup")
                .withDescription("Second sample job that log messages")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger secondSampleJobTrigger(JobDetail secondSampleJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(secondSampleJobDetail)
                .withIdentity("secondSampleJobTrigger", "sampleGroup")
                .withDescription("Trigger for second sample job - runs every 30 seconds")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
                .build();
    }
}
