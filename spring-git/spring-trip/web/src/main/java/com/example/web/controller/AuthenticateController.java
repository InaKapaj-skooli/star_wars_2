package com.example.web.controller;

import com.example.service.entity.*;
import com.example.service.repository.FlightRepository;
import com.example.service.repository.TripRepository;
import com.example.service.repository.UserRepository;
import com.example.service.security.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticateController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping
    @RequestMapping("/login")
    public ResponseEntity<String> save(@RequestBody Authentication userDto) {
        authenticationManager.authenticate(userDto);
        logger.info("The user is successfully logged in........");
        return ResponseEntity.ok("Successfully");
    }

    @PostMapping
    @RequestMapping("/insert-user-db")
    public ResponseEntity<String> save() {
        UserEntity user = new UserEntity();
        Role role = new Role();
        role.setRole("USER");
        role.setUsers(List.of(user));

        user.setUserName("user1");
        user.setPassword(passwordEncoder.encode("user1"));
        user.setRoles(List.of(role));
        userRepository.save(user);
        logger.info("The user is successfully inserted........");
        return ResponseEntity.ok("Successfully");
    }

    @PostMapping
    @RequestMapping("/insert-trip-db")
    public ResponseEntity<String> insertTrip() {
        Date today = Calendar.getInstance().getTime();
        Trip trip = new Trip();
        TripReason tripReason = new TripReason();
        trip.setFromTrip("A");
        trip.setToTrip("B");
        trip.setDepartureDate(today);
        trip.setArrivalDate(today);
        trip.setTripDescription("Make a trip for work");
        tripReason.setTripReason("WORK");

        tripRepository.save(trip);
        logger.info("The trip is successfully inserted........");
        return ResponseEntity.ok("Successfully");
    }

    @PostMapping
    @RequestMapping("/status-trip")
    public ResponseEntity<String> statusTrip() {
        Trip trip = new Trip();
        TripStatus tripStatus = new TripStatus();
        tripStatus.setTripStatus("APPROVED");

        tripRepository.save(trip);
        logger.info("The status is successfully given........");
        return ResponseEntity.ok("Successfully");
    }

    @PostMapping
    @RequestMapping("/insert-flight-db")
    public ResponseEntity<String> insertFlight() {
        Date today = Calendar.getInstance().getTime();
        UserEntity user = new UserEntity();
        Flight flight = new Flight();
        flight.setFromFlight("A");
        flight.setToFlight("B");
        flight.setDepartureDate(today);
        flight.setArrivalDate(today);

        flightRepository.save(flight);
        logger.info("The flight is successfully inserted........");
        return ResponseEntity.ok("Successfully");
    }

    @PostMapping
    @RequestMapping("/update-db")
    public ResponseEntity<String> update() {
        UserEntity user = new UserEntity();

        user.setUserName("user3");
        user.setEmail("user3@yahoo.com");
        user.setPassword(passwordEncoder.encode("user3"));
        userRepository.save(user);
        logger.info("The user is successfully updated........");
        return ResponseEntity.ok("Successfully updated");
    }

    //soft delete
    @PostMapping
    @RequestMapping("/delete-db")
    public ResponseEntity<String> delete() {
        UserEntity user = new UserEntity();

        user.setDeleted(true);
        logger.info("The user is successfully deleted........");
        return ResponseEntity.ok("Successfully deleted");
    }

    @GetMapping
    @RequestMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        logger.info("The user is successfully logged out........");
        return "redirect:/auth";
    }
}
