package oshan2csd.springbootmongodbdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    //BASIC CRUD
    /*=========================================================================================*/
    @GetMapping("/all")
    public List<Hotel> getAll(){
         List<Hotel> hotels = this.hotelRepository.findAll();
         return hotels;
    }

    @PostMapping("/add")
    public void insert(@RequestBody Hotel hotel){
        this.hotelRepository.insert(hotel);// save() can be used also
    }

    @PutMapping("/update")
    public void update(@RequestBody Hotel hotel){

        //Save() method works like upsert
        //Insert or update
        //If Id exists -> update
        //If Id not exists -> insert
        //But Insert() just insert data
        this.hotelRepository.save(hotel);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") String id){
        this.hotelRepository.deleteById(id);
    }

    //Filtering
    //Need to modify interface (hotelRepository)
    /*=================================================================================================*/

    //Find a hotel by ID
    @GetMapping("get/{id}")
    public Optional<Hotel> findById(@PathVariable("id") String id){
        return this.hotelRepository.findById(id);
    }

    //Get hotels where pricePerNight < given Price
    @GetMapping("/findbyprice/{maxPrice}")
    public List<Hotel> findByPrice(@PathVariable("maxPrice") int maxPrice){
        return hotelRepository.findByPricePerNightLessThan(maxPrice);
    }

    //Advance filtering
    /*====================================================================================================*/
    








}
