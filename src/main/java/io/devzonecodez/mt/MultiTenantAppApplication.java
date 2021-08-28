package io.devzonecodez.mt;

import io.devzonecodez.mt.config.web.TenantContextHolder;
import io.devzonecodez.mt.model.User;
import io.devzonecodez.mt.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"io.devzonecodez.mt"})
@EntityScan(basePackages = {"io.devzonecodez.mt.model"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MultiTenantAppApplication implements ApplicationRunner {

	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(MultiTenantAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// create default user for both the tenants ob startup
		createDefaultUsers(5, "tenantone");
		createDefaultUsers(5, "tenanttwo");
	}

	private void createDefaultUsers(int numberOfUsers, String tenant) {
		// set the tenant
		TenantContextHolder.setTenantId(tenant);

		List<User> users = new ArrayList<>(5);
		User user;
		for (int i = 0; i < numberOfUsers; i++) {
			user = new User();
			user.setFirstName(tenant+"-user-first-name-"+i);
			user.setLastName(tenant+"-user-last-name-"+i);
			user.setMobile(new Long(i));
			users.add(user);
		}
		userRepo.saveAll(users);

		// clear the tenant
		TenantContextHolder.clear();
	}
}
