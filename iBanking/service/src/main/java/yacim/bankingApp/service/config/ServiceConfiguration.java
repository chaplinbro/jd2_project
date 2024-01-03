package yacim.bankingApp.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import yacim.bankingApp.data.config.DataConfiguration;

@Configuration
@ComponentScan(basePackages = "yacim.bankingApp.service")
@Import(DataConfiguration.class)
public class ServiceConfiguration {
}
