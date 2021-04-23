package rs.ac.ni.pmf.web.caching2021.cachingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class CachingDemoApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(CachingDemoApplication.class, args);
	}
}
