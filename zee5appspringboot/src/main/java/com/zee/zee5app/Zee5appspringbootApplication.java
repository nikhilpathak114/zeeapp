package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeServ;
import com.zee.zee5app.service.MovieServ;
import com.zee.zee5app.service.SeriesServ;
import com.zee.zee5app.service.SubscriptionServ;
import com.zee.zee5app.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args)
			throws javax.naming.InvalidNameException, SQLException, InvalidNameException, InvalidIdLengthException,
			InvalidEmailException, InvalidPasswordException, IOException, IdNotFoundException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);

//		DataSource dataSource = applicationContext.getBean(DataSource.class);
//
//		UserService userservice = applicationContext.getBean(UserService.class);
//		try {
//			Register register = new Register("ysh00010", "Hitesh", "singh", "abc13361@gmail.com", "pass@3421", new BigDecimal("7894561230"));	
//			System.out.println(userservice.addUser(register));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		System.out.println(userservice.getUserById("ysh00007").get());
//		System.out.println();
//
//		userservice.getAllUsersDetails().get().forEach(e -> System.out.println(e));
//		System.out.println();
//
//		try {
//			System.out.println(userservice.deleteUserById("ysh00007"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//
//		for (Register register1 : userservice.getAllUsers()) {
//			System.out.println(register1);
//		}
//		System.out.println();
//
//		// -----------------------------------------MOVIES-------------------------------------------//
//
//		MovieServ movieService = applicationContext.getBean(MovieServ.class);
//		try {
//			Movies movie = new Movies("mv00002", "Movie1", 123, "Comedy", "2020-09-01", "www.youtube.com/yugufyg", "hg,gh", 15,
//					"Hindi");
//			System.out.println(movieService.addMovies(movie));
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//
//		try {
//			System.out.println(movieService.getMovieById("mv00001").get());
//		} catch (NameNotFoundException | IdNotFoundException | InvalidIdLengthException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//
//		try {
//			movieService.getAllMoviesDetails().get().forEach(e -> System.out.println(e));
//		} catch (javax.naming.InvalidNameException | NameNotFoundException | InvalidIdLengthException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//
//		try {
//			try {
//				System.out.println(movieService.deleteMovie("mv00001"));
//			} catch (javax.naming.InvalidNameException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (NameNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (InvalidIdLengthException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//
//		try {
//			for (Movies movie : movieService.getAllMovie()) {
//				System.out.println(movie);
//			}
//		} catch (javax.naming.InvalidNameException | NameNotFoundException | InvalidIdLengthException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//
//		// --------------------------------Subscription------------------------------------//
//		SubscriptionServ subService = applicationContext.getBean(SubscriptionServ.class);
//		try {
//			Subscription sub = new Subscription("sub00001","Monthly","2022-01-10","UPI",199,"Active","Yes","2022-02-09","ysh00008");
//			System.out.println(subService.addSubscription(sub));
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//
//		try {
//			System.out.println(subService.getSubscriptionById("sub00001").get());
//		} catch (IdNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//
//		subService.getAllSubscriptionDetails().get().forEach(e -> System.out.println(e));
//		System.out.println();
//
//		try {
//			System.out.println(subService.deleteSubscription("sub00001"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//
//		for (Subscription sub : subService.getAllSubscription()) {
//			System.out.println(sub);
//		}
//		System.out.println();
//		
//		//--------------------------------------------SERIES-------------------------------------//
//		SeriesServ seriesService = applicationContext.getBean(SeriesServ.class);
//		try {
//			Series sub = new Series("ser00001","seriesname","Action","2021-12-17","www.youtube.com/oduagku","ty,yt",15,"ENGLISH",12);
//			System.out.println(seriesService.addSeries(sub));
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//
//		try {
//			System.out.println(seriesService.getSeriesById("ser00001").get());
//		} catch (IdNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//
//		seriesService.getAllSeriesDetails().get().forEach(e -> System.out.println(e));
//		System.out.println();
//
//		try {
//			System.out.println(seriesService.deleteSeries("ser00001"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//
//		for (Series ser : seriesService.getAllSeries()) {
//			System.out.println(ser);
//		}
//		System.out.println();
//		
//		//---------------------------------Episodes--------------------------------------------//
//		EpisodeServ epService = applicationContext.getBean(EpisodeServ.class);
//		try {
//			Episodes sub = new Episodes("ep00001","ser00001","Epname1",67.00,"jgagfka","www.youtube.com/afiagf");
//			System.out.println(epService.addEpisode(sub));
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//
//		System.out.println(epService.getEpisodeById("ep00001").get());
//		System.out.println();
//
//		epService.getAllEpisodeDetails().get().forEach(e -> System.out.println(e));
//		System.out.println();
//
//		try {
//			System.out.println(epService.deleteEpisode("ep00001"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//
//		for (Episodes ep : epService.getAllEpisode()) {
//			System.out.println(ep);
//		}
//		System.out.println();
//		
//
//		System.out.println(dataSource != null);

		applicationContext.close();
	}

}
