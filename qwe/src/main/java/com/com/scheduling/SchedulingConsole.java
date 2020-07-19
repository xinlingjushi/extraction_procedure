package com.com.scheduling;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.com.service.TestService;


@Configuration
@Component("SchedulingConsole")
@PropertySource(value = "classpath:config.properties")
public class SchedulingConsole {

	
	// 日志
	private final static Logger log = (Logger) LoggerFactory.getLogger(SchedulingConsole.class);
	
	  
    @Autowired
    TestService tsbzwycgtzb;    
	
	private List<Integer> index = Arrays.asList(8000,6000,7000);

    private AtomicInteger atomicInteger = new AtomicInteger(0);
   
    
	/**
     * 此处设定的是0,5,15,25...秒时执行
     *
     * @throws InterruptedException  :0/30 * * * * ?
     */
    @Scheduled(cron = "${system.cron}")
    public void cron() throws InterruptedException {
        int i = atomicInteger.get();
        if (i < 3) {
            log.info("开始执行时间 {}", System.currentTimeMillis());
            log.info("第{}此执行，执行时间为{}ms", i, index.get(i));
            Thread.sleep(index.get(i));
            atomicInteger.getAndIncrement();
        }
    }
    
    @Scheduled(cron = "${tsbzwycgtzb.cron}")
    public void cron1() throws InterruptedException {
    	log.info("开始执行杆塔和线路坐标", System.currentTimeMillis());
    	tsbzwycgtzb.testSelect();
    	log.info("结束执行杆塔和线路坐标", System.currentTimeMillis());
    }
    
  

}
