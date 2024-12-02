package edu.co.unicauca.learnmetrics.lm;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.services.CompetenciaServices.CompetenciaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"edu.co.unicauca.learnmetrics.lm"})

public class LmApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmApplication.class, args);
		/*ConfigurableApplicationContext context = SpringApplication.run(LmApplication.class,args);
		CompetenciaServiceImpl competenciaService = context.getBean(CompetenciaServiceImpl.class);
		competenciaService.findAllComps();*/
	}

}
