package cn.rdlts.jobs;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GitRetrieveJob {
	
	
	@Scheduled(cron = "0/10 * * * * *")  
	public void printMessage() {
		System.out.println("Print message for Git RetrieveJobs");
	}
	
	public static void main(String[] args) throws InterruptedException {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext-jobs.xml");
        for (int i = 0; i < 10; i++) {
            System.out.println("main running...");  
            Thread.sleep(10000);  
        }
    }  
}
