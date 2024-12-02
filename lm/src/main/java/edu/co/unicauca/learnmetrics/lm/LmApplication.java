package edu.co.unicauca.learnmetrics.lm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos" })
@EntityScan(basePackages = { "edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos" })
public class LmApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmApplication.class, args);
	}

}
