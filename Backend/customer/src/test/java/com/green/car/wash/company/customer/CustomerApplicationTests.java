package com.green.car.wash.company.customer;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.green.car.wash.company.customer.models.Ratings;
import com.green.car.wash.company.customer.models.customerDetails;
import com.green.car.wash.company.customer.repository.CustomerRepo;
import com.green.car.wash.company.customer.repository.RatingRepo;
import com.green.car.wash.company.customer.service.CustomerService;
import com.green.car.wash.company.customer.service.RatingsService;

@SpringBootTest
@RunWith(SpringRunner.class)
class CustomerApplicationTests {
	@MockBean
	CustomerRepo customerrepo;
	@Autowired
	CustomerService service;
	@MockBean
	RatingRepo ratingrepo;
	@Autowired
	RatingsService service1;




//	@Test
//	public void CustomerSpecificTest() {
//		when(customerrepo.findAll()).thenReturn(Stream.of(new customerDetails("123","clean@gmail.com","password","cleanwash","234555", null, null),
//				new customerDetails("124","cccc@gmail.com","200","aaaa","2345678", null, "user")
//				).collect(Collectors.toList()));
//		assertEquals(2,service.CustomerSpecific("user").size());
//	}
	@Test
    public void deleteProfilebyidTest() {
        customerDetails customerDetail= new customerDetails("124","cccc@gmail.com","200","aaaa","2345678", null, null);
        String id = "123";
       service.deleteProfile(id);
        verify(customerrepo, times(1)).deleteById(id);
    }


	@Test
	void addRatingTest() {
		Ratings rating = new Ratings("123", "abc", "good", 5);
		when(ratingrepo.save(rating)).thenReturn(rating);
		Ratings res = service1.addRating(rating);
		assertEquals(rating,service1.addRating(rating));
	}



}
