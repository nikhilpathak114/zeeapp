package com.zee.zee5app;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.MovieRepo;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.MovieRepoImpl;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;

public class MainSpring {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//we need to establish/create spring env.
		//this one will kick start of ur spring appli
		//application context
		//here we have to initialize the app. context container
		//java based config
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		MovieRepo repository = applicationContext.getBean(MovieRepo.class);
		MovieRepoImpl movieimpl = applicationContext.getBean(MovieRepoImpl.class);
		
		System.out.println(userRepository);
		UserRepository userRepository2 = applicationContext.getBean(UserRepository.class);
		System.out.println(userRepository2);
		
		System.out.println(userRepository.hashCode());
		System.out.println(userRepository.hashCode());
		System.out.println(repository.hashCode());
		System.out.println(movieimpl.hashCode());
		
		System.out.println(userRepository.equals(userRepository2));
		
		DataSource dataSource = applicationContext.getBean("dataSource",DataSource.class);
		System.out.println(dataSource != null);
		
		Register register;
		try {
			register = new Register("np00014","Yashraj","singh","any7@gmail.com","pass@12345");
			register.setContactnumber(new BigDecimal("7867890134"));
			System.out.println(userRepository.addUser(register));
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applicationContext.close();
	}

}
