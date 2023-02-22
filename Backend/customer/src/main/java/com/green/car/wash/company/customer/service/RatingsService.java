package com.green.car.wash.company.customer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.car.wash.company.customer.models.Ratings;
import com.green.car.wash.company.customer.repository.RatingRepo;

@Service
public class RatingsService {
    @Autowired
    RatingRepo ratingrepo;

    //To get all the ratings
    public List<Ratings> getallRatings(){
        return ratingrepo.findAll();
    }
    //To add a rating
    public Ratings addRating(Ratings ratings){
        return ratingrepo.save(ratings);
    }
    //To get ratings of specific washer
    public List<Ratings> washerSpecific(String washerName){
        List<Ratings> washerSpecificRatings=ratingrepo.findAll().stream().filter(x -> x.getWasherName().contains(washerName)).collect(Collectors.toList());
        return washerSpecificRatings;
    }
    //To delete a rating
    public String deleteRating(String id){
        ratingrepo.deleteById(id);
        return "Rating with ID -> "+id+" deleted successfully";
    }

}
