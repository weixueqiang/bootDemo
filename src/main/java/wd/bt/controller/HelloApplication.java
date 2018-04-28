package wd.bt.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@ComponentScan(basePackages= {"wd.bt.controller"})
@SpringBootApplication
@PropertySource(value= {"db.properties","application.properties"})
public class HelloApplication {

	  @Value("${url}")
	    private String jdbcUrl;

	    @Value("${driver}")
	    private String jdbcDriverClassName;

	    @Value("${username}")
	    private String jdbcUsername;

	    @Value("${password}")
	    private String jdbcPassword;

	    @Bean(destroyMethod = "close")
	    public DataSource dataSource() {
	        BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
	        boneCPDataSource.setDriverClass(jdbcDriverClassName);
	        boneCPDataSource.setJdbcUrl(jdbcUrl);
	        boneCPDataSource.setUsername(jdbcUsername);
	        boneCPDataSource.setPassword(jdbcPassword);
	        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
	        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
	        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
	        boneCPDataSource.setIdleMaxAgeInMinutes(30);
	        // 每个分区最大的连接数
	        boneCPDataSource.setMaxConnectionsPerPartition(100);
	        // 每个分区最小的连接数
	        boneCPDataSource.setMinConnectionsPerPartition(5);
	        return boneCPDataSource;
	    }
	
	
	    
	    
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HelloApplication.class);
//		app.setBannerMode(Mode.OFF);
		app.run(args);
//		SpringApplication.run(HelloApplication.class, args);
	}
}
