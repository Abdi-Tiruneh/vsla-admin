package vsla_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VslaAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(VslaAdminApplication.class, args);
	}

}
