package oshan2csd.springbootmongodbdemo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    public Optional<Hotel> findById(String id);

    public List<Hotel> findByPricePerNightLessThan(int maxPrice);



}
