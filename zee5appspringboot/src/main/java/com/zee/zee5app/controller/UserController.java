package com.zee.zee5app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.payload.request.LoginRequest;
import com.zee.zee5app.payload.request.SignupRequest;
import com.zee.zee5app.payload.response.JwtResponse;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.RoleRepo;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.security.jwt.JwtUtils;
import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.service.MovieServ;
import com.zee.zee5app.service.UserService;
import org.springframework.security.core.Authentication;
@RestController // 4 @ResponseBody @Controller
//REST API: RESPONSE wherever we have to share the response that method 
//must be marked with @ResponseBody
//100methods ---> @Responsebody ---> 1000times
@RequestMapping("/auth")
public class UserController {

	@Autowired
	UserService uservService;
	@Autowired
	MovieServ movieService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepo roleRepo;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), 
						loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		
		List<String> roles = userDetailsImpl.getAuthorities()
				.stream()
				.map(i->i.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
				userDetailsImpl.getId(), 
				userDetailsImpl.getUsername(), 
				userDetailsImpl.getEmail(), 
				roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {

		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// user's account

		User user = new User(signupRequest.getUsername(), signupRequest.getEmail(),
				passwordEncoder.encode(signupRequest.getPassword()), signupRequest.getFirstName(),
				signupRequest.getLastName());
		// retrieving the roles details

		Set<String> strRoles = signupRequest.getRole();

		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepo.findByRoleName(EROLE.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error:role not found"));
			roles.add(userRole);
		}

		else {
			strRoles.forEach(e -> {
				switch (e) {
				case "admin":
					Role roleAdmin = roleRepo.findByRoleName(EROLE.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error:role not found"));
					roles.add(roleAdmin);
					break;

				case "mod":
					Role roleMod = roleRepo.findByRoleName(EROLE.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error:role not found"));
					roles.add(roleMod);
					break;

				default:
					Role userRole = roleRepo.findByRoleName(EROLE.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error:role not found"));
					roles.add(userRole);
				}
			});

		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.status(201).body(new MessageResponse("user created successfully"));

	}
	// adding user info into the table
	// info will be shared by the client in terms of JSON object
	// do we need to read that json Object? ===> yes
	// where is this json object is available in request? ==> requestbody
	// do we need to read that requestbody content? yes
	// do we need to transform json object object to java object? yes ==>
	// @RequestBody

//	@PostMapping("/addUser")
//	public ResponseEntity<?> addUser(@Valid @RequestBody User register) throws SQLException, AlreadyExistsException {
//		User result = uservService.addUser(register);
//		// validation
//		return ResponseEntity.status(201).body(result);
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getUserById(@Valid @PathVariable("id") Long id) throws IdNotFoundException {
//		Optional<User> register = uservService.getUserById(id);
//		return ResponseEntity.ok(register);
//	}
//
//	@GetMapping("/all")
//	public ResponseEntity<?> getAllUsersDetails() {
//		Optional<List<User>> optional = uservService.getAllUserDetails();
//		if (optional.isEmpty()) {
//			Map<String, String> map = new HashMap<>();
//			map.put("message", "no record found");
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
//		}
//		return ResponseEntity.ok(optional.get());
//	}
//
//	@PostMapping("/addMovies")
//	public ResponseEntity<?> addMovies(@Valid @RequestBody Movies movie) throws AlreadyExistsException {
//		Movies movie2 = movieService.addMovie(movie);
//		return ResponseEntity.status(201).body(movie2);
//	}
//
//	@GetMapping("/allMovies")
//	public ResponseEntity<?> getAllMoviesDetails()
//			throws javax.naming.InvalidNameException, NameNotFoundException, InvalidIdLengthException {
//		Optional<List<Movies>> optional = movieService.getAllMovieDetails();
//		if (optional.isEmpty()) {
////			Map<String, String> map = new HashMap<>();
////			map.put("message","no record found" );
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("no record Found"));
//		}
//		return ResponseEntity.ok(optional.get());
//	}
}
