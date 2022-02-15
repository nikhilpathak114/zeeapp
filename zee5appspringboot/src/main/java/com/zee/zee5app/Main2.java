package com.zee.zee5app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class, args);
//		RoleRepo rolerepo = applicationContext.getBean(RoleRepo.class);
//		Role role = new Role();
//		role.setRoleName(EROLE.ROLE_ADMIN);
//		rolerepo.save(role);
//		Role role2 = new Role();
//		role.setRoleName(EROLE.ROLE_USER);
//		rolerepo.save(role2);
//		
//		RoleServ roleServ = applicationContext.getBean(RoleServ.class);
//	
//		System.out.println(roleServ.addRole(role));
//		System.out.println(roleServ.addRole(role2));
//		
//		UserService service = applicationContext.getBean(UserService.class);
//		Register register;
//		try {
//			register = new Register("ysh00021", "Hemant12", "shah12", "abc1236112@gmail.com", "pass@311221", new BigDecimal("7891261520"),null,null);	
//			Set<Role> roles = new HashSet<>();
//			roles.add(rolerepo.findById(1).get());
//			roles.add(rolerepo.findById(4).get());
//			register.setRoles(roles);
//			System.out.println(service.addUser(register));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		SubscriptionServ subscriberservice = applicationContext.getBean(SubscriptionServ.class);
//		
//		Subscription subscriber = new Subscription("sub00004","Monthly","2022-01-10","UPI",299,"Active","Yes","2022-07-09",null);
//		try {
//			subscriberservice.addSubscription(subscriber);
//		} catch (InvalidAmountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Register reg2 = new Register("ysh00028", "Hemant18", "shah18", "abc1236118@gmail.com", "pass@311821", new BigDecimal("7891861520"),roles,subscriber);
//		try {
//			String res = service.addUser(reg2);
//		} catch (SQLException | AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
//		MovieServ movieservice = applicationContext.getBean(MovieServ.class);
//		Movies movie = new Movies();
//		movie.setId("mv00002");
//		movie.setAgeLimit(18);
//		movie.setCast("Allu Arjun");
//		movie.setLanguage("Hindi");
//		movie.setLength(140);
//		movie.setMovieName("Moviename1");
//		movie.setGenre("Action");
//		movie.setReleaseDate("2022-01-15");
//		FileInputStream fileinputstream = null;
//		FileOutputStream fileOutputStream = null;
//		try {
//			fileinputstream = new FileInputStream("C:\\Users\\nikhil.pathak\\Downloads\\movies\\Song.mp4");
//			File file = new File("C:\\Users\\nikhil.pathak\\Downloads\\movies\\Song.mp4");
//			long filesize = file.length();
//			byte[] allBytes = new byte[(int) filesize];
//			
//			fileinputstream.read(allBytes);
//			movie.setTrailer("C:\\Users\\nikhil.pathak\\Downloads\\movies\\moviestore\\"+file.getName());
//			String result = movieservice.addMovies(movie);
//			
//			if(result.equals("Success")) {
//				fileOutputStream = new FileOutputStream("C:\\Users\\nikhil.pathak\\Downloads\\movies\\moviestore\\"+file.getName());
//				byte[] data = new byte[(int) file.length()];
//				
//				fileinputstream.read(data);
//				fileOutputStream.write(data);
//			}
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				fileinputstream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
		
		
//		FileOutputStream fileOutputStream = null;
//		
//		try {
//			Optional<Movies> optional = movieservice.getMovieById("mv00002");
//			if(optional.isEmpty()) {
//				System.out.println("not found");
//			}
//			else {
//				Movies movie = optional.get();
//				fileOutputStream = new FileOutputStream("C:\\Users\\nikhil.pathak\\Downloads\\movies\\Song.mp4");
//				fileOutputStream.write(movie.getTrailer());
//			}
//		} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				fileOutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		
//		Movies movie = new Movies();

//		movie.setId("mv00002");
//		movie.setAgeLimit(18);
//		movie.setCast("Allu Arjun");
//		movie.setLanguage("Hindi");
//		movie.setLength(140);
//		movie.setMovieName("Moviename1");
//		movie.setGenre("Action");
//		movie.setReleaseDate("2022-01-15");
//		FileInputStream fileinputstream = null;
//		try {
//			fileinputstream = new FileInputStream("C:\\Users\\nikhil.pathak\\Downloads\\Song.mp4");
//			long filesize = new File("C:\\Users\\nikhil.pathak\\Downloads\\Song.mp4").length();
//			byte[] allBytes = new byte[(int) filesize];
//			
//			fileinputstream.read(allBytes);
//			movie.setTrailer(allBytes);
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				fileinputstream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		movieservice.addMovies(movie);
		
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
//		applicationContext.close();
		
	}

}
