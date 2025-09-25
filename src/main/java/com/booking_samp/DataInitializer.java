//package com.booking_samp;
//
//import com.booking_samp_modal.Booking_samp_city;
//import com.booking_samp_modal.Booking_samp_movie;
//import com.booking_samp_modal.Booking_samp_show;
//import com.booking_samp_modal.Booking_samp_theater;
//import com.booking_samp_modal.Booking_samp_user;
//import com.booking_samp_repository.Booking_samp_cityRepository;
//import com.booking_samp_repository.Booking_samp_movieRepository;
//import com.booking_samp_repository.Booking_samp_showRepository;
//import com.booking_samp_repository.Booking_samp_theaterRepository;
//import com.booking_samp_repository.Booking_samp_userRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    @Autowired
//    private Booking_samp_cityRepository cityRepository;
//    @Autowired
//    private Booking_samp_theaterRepository theaterRepository;
//    @Autowired
//    private Booking_samp_movieRepository movieRepository;
//    @Autowired
//    private Booking_samp_userRepository userRepository;
//    @Autowired
//    private Booking_samp_showRepository showRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // This code will run on startup.
//    	
//    	
//        // It checks if data already exists to avoid adding duplicates.
//        if (cityRepository.count() == 0) {
//            System.out.println("Database is empty. Initializing sample data...");
//            Booking_samp_movie leo = new Booking_samp_movie();
//            leo.setTitle("Leo");
//            leo.setDescription("A mild-mannered cafe owner becomes a local hero.");
//            leo.setDurationInMinutes(164);
//            leo.setPosterUrl("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zbmmt62a9oao3ePRs8a66nL6goud.jpg");
//            // ADD NEW DATA
//            leo.setRating("8.1/10");
//            leo.setLikes("1.2M Likes");
//            leo.setGenre("Action/Thriller");
//            movieRepository.save(leo);
//
//            // 2. Create a Theater and link it to the City
//            Booking_samp_theater broadway = new Booking_samp_theater();
//            broadway.setName("Broadway Cinemas");
//            broadway.setAddress("123 Movie Lane");
//            Booking_samp_city coimbatore;
//			broadway.setCity(coimbatore);
//            theaterRepository.save(broadway);
//
//            // 3. Create Movies with posters
//            Booking_samp_movie leo1 = new Booking_samp_movie();
//            leo1.setTitle("Leo");
//            leo1.setDescription("A mild-mannered cafe owner becomes a local hero.");
//            leo1.setDurationInMinutes(164);
//            leo1.setPosterUrl("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zbmmt62a9oao3ePRs8a66nL6goud.jpg");
//            movieRepository.save(leo1);
//            
//            Booking_samp_movie vikram = new Booking_samp_movie();
//            vikram.setTitle("Vikram");
//            vikram.setDescription("A special agent investigates a series of murders.");
//            vikram.setDurationInMinutes(175);
//            vikram.setPosterUrl("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ha2C2s22Tz1z8d3m0p22i22yG2O.jpg");
//            movieRepository.save(vikram);
//            
//            // 4. Create a User
//            Booking_samp_user testUser = new Booking_samp_user();
//            testUser.setName("Test User");
//            testUser.setEmail("test@example.com");
//            testUser.setPassword("password123"); // Note: This password is NOT encrypted
//            userRepository.save(testUser);
//
//            // 5. Create Shows, linking Movies and Theaters
//            Booking_samp_show show1 = new Booking_samp_show();
//            show1.setMovie(leo1);
//            show1.setTheater(broadway);
//            show1.setShowTime(LocalDateTime.now().withHour(18).withMinute(30).withSecond(0).withNano(0));
//            showRepository.save(show1);
//            
//            Booking_samp_show show2 = new Booking_samp_show();
//            show2.setMovie(vikram);
//            show2.setTheater(broadway);
//            show2.setShowTime(LocalDateTime.now().withHour(21).withMinute(0).withSecond(0).withNano(0));
//            showRepository.save(show2);
//
//            System.out.println("Sample data initialization complete.");
//        } else {
//            System.out.println("Database already contains data. Skipping initialization.");
//        }
//    }
//}