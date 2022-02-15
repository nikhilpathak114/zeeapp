package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;
import com.zee.zee5app.service.impl.MovieServImpl;
import com.zee.zee5app.service.impl.SeriesServImpl;
import com.zee.zee5app.service.impl.SubscriptionServImpl;
import com.zee.zee5app.service.SubscriptionServ;
import com.zee.zee5app.service.MovieServ;
import com.zee.zee5app.service.SeriesServ;

public class Main {

	public static void main(String[] args) throws InvalidEmailException, InvalidPasswordException, IOException, InvalidIdLengthException, InvalidNameException, NameNotFoundException, javax.naming.InvalidNameException {
		// TODO Auto-generated method stub
		
//		UserService service;
//		try {
//			service = UserServiceImpl.getInstance();
//			Optional<List<Register>> optional = service.getAllUserDetails();
//			
//			if(optional.isEmpty()) {
//				System.out.println("there is no records");
//			}
//			else {
//				optional.get().forEach(e->System.out.println(e));
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		Register register = null;
//		
//		try {
//            register = new Register("np00001","nikhil","pathak","nikhil@gmail.com","pass@12345");
//            register.setContactnumber(new BigDecimal("7894561230"));
//            UserService userservice = UserServiceImpl.getInstance();
//            userservice.addUser(register);
//        } catch (InvalidNameException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InvalidIdLengthException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InvalidEmailException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InvalidPasswordException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
		
		//------------------------ MOVIES -----------------------//
		
		Movies movie = null;
		MovieServ service;
		
//		try {
//			movie = new Movies("mv00005","SomeMovie",12,"HG,GH","Comedy",132.00,"www.youtube.com/ddhiga","2014-12-14","English");
//			service = MovieServImpl.getInstance();
//            service.addMovies(movie);
//		} catch (NameNotFoundException | InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
		
//		try {
//			service = MovieServImpl.getInstance();
//			Optional optional = service.getMovieById("mv00001");
//			System.out.println(optional.get());
//		} catch (IOException | IdNotFoundException | InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			service = MovieServImpl.getInstance();
//			Optional<List<Movies>> optional = service.getAllMoviesDetails();
//			
//			if(optional.isEmpty()) {
//				System.out.println("there is no records");
//			}
//			else {
//				optional.get().forEach(e->System.out.println(e));
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			service = MovieServImpl.getInstance();
//			service.deleteMovie("mov00005");
//		} catch (javax.naming.InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			service = MovieServImpl.getInstance();
//			movie = new Movies("Somemovie");
//			service.modifyMovie("mv00001", movie);
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}