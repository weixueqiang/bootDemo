package wd.bt.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"wd.bt.demo"})

public class DemoConfiguration {

	@Bean
	public DemoDao getDemoDao() {
		return new DemoDao();
	}
}
