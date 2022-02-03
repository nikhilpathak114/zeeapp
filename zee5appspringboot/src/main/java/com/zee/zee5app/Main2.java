package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.repository.MovieRepo;
import com.zee.zee5app.repository.RoleRepo;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.MovieServ;
import com.zee.zee5app.service.RoleServ;
import com.zee.zee5app.service.UserService;
@SpringBootApplication
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class, args);
		RoleRepo rolerepo = applicationContext.getBean(RoleRepo.class);
		Role role = new Role();
		role.setRoleName(EROLE.ROLE_ADMIN);
		rolerepo.save(role);
		Role role2 = new Role();
		role.setRoleName(EROLE.ROLE_USER);
		rolerepo.save(role2);
		
		RoleServ roleServ = applicationContext.getBean(RoleServ.class);
	
//		System.out.println(roleServ.addRole(role));
//		System.out.println(roleServ.addRole(role2));
		
		UserService service = applicationContext.getBean(UserService.class);
		Register register;
		try {
			register = new Register("ysh00022", "Hemant12", "shah12", "abc1236112@gmail.com", "pass@311221", new BigDecimal("7891261520"),null,null);	
			Set<Role> roles = new HashSet<>();
			roles.add(rolerepo.findById(1).get());
			roles.add(rolerepo.findById(4).get());
			register.setRoles(roles);
			System.out.println(service.addUser(register));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//		Register[] registers = service.getAllUsers();
//		for(int i = 0 ; i < registers.length;i++) {
//			System.out.println(registers[i]);
//		}
//		Optional<List<Register>> optional = service.getAllUsersDetails();
//		if (optional.isPresent()){
//			optional.get().forEach(e->System.out.println(e));
//		}
//		else {
//			System.out.println("No users found.");
//		}
//		String res = service.deleteUserById("register@10");
//		System.out.println(res);
//	} catch (InvalidNameException | IdInvalidLengthException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IdNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (InvalidPasswordException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (InvalidEmailException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		
		//------------------------------------Movies---------------------------------------//
//		MovieRepo movierepo = applicationContext.getBean(MovieRepo.class);
//		MovieServ movieservice = applicationContext.getBean(MovieServ.class);
////		Movies movie = new Movies("movie@10", "End Game", 
////				"https://www.youtube.com/watch?v=TcMBFSGVi1c&ab_channel=MarvelEntertainment",
////				 "2022-09-02", "location10",
////				"HINDI", "A,B,C",10, 10);
//		Optional<Movies> optional = movierepo.findByMovieNameAndLanguage("Movie1","Hindi");
//		if(optional.isPresent()) {
//			System.out.println(optional.get());
//		}else System.out.println("not found");
//		try {
//			Movies[] movies = movieservice.getAllMovies();
//			for(int i = 0 ; i < movies.length;i++) {
//				System.out.println(movies[i]);
//			}
//			Optional<List<Movies>> optional = movieservice.getAllMoviesDetails();
//			if (optional.isPresent()){
//				optional.get().forEach(e->System.out.println(e));
//			}
//			else {
//				System.out.println("No movies found.");
//			}
//			String res = movieservice.deleteMovieById("movie@10");
//			System.out.println(res);
//		} catch (InvalidNameException | IdInvalidLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidEmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		UserRepository userrepository = applicationContext.getBean(UserRepository.class);
//		MovieRepo movierepo = applicationContext.getBean(MovieRepo.class);
//		
//		System.out.println(userrepository.existsByEmailAndContactnumber("abc1376@gmail.com",new BigDecimal(6523458971.00)));
//		System.out.println();
//		System.out.println(movierepo.findByMovieName("Movie1"));
//		System.out.println();
//		System.out.println(movierepo.findByMovieNameAndLanguage("Movie1","Hindi"));
//		System.out.println();
//		System.out.println(movierepo.findByMovieNameAndReleaseDate("Movie1","2020-09-01"));
//		System.out.println();
//		System.out.println(movierepo.findByCast("hg,gh"));
		applicationContext.close();
		
	}

}
