package oshan2csd.springbootmongodbdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//To insert some data(documents to database)
@Component
public class DbSeeder implements CommandLineRunner {

    /*
     * No need to annotate with @Autowired, with new version of Spring Boot
     * If there is only one constructor
     */
    @Autowired
    private HotelRepository hotelRepository;


    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    //This will be run at the start of the application
    //To enter values through CMD
    @Override
    public void run(String... args) throws Exception {

        Hotel mariot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )
        );

        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                new Address("Rome", "Italy"),
                new ArrayList<>()
        );

        /*
        * 1. Drop DB first
        * 2. Add above data to the DB
        * */

        //drop all hotel data
        this.hotelRepository.deleteAll();

        //add our hotel to the database
        List<Hotel> hotels = Arrays.asList(mariot, ibis, sofitel);
        this.hotelRepository.saveAll(hotels);


    }
}
