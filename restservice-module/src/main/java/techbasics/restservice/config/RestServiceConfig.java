package techbasics.restservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import techbasics.common.aspect.UncaughtRestExceptionHandlerAspect;
import techbasics.common.manager.PersonManager;
import techbasics.common.manager.PersonManagerImpl;
import techbasics.restservice.aspect.RestBoundaryLoggerAspect;

@Configuration
public class RestServiceConfig {

	@Bean
	public RestBoundaryLoggerAspect restBoundaryLoggerAspect() {
		return new RestBoundaryLoggerAspect();
	}

	@Bean
	public UncaughtRestExceptionHandlerAspect uncaughtRestExceptionHandlerAspect() {
		return new UncaughtRestExceptionHandlerAspect();
	}

	@Bean
	public PersonManager personManager() {
		return new PersonManagerImpl();
	}

}
