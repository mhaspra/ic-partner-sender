package ch.mhaspra.insurancecase.icpartnersender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IcPartnerSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcPartnerSenderApplication.class, args);
	}

}
