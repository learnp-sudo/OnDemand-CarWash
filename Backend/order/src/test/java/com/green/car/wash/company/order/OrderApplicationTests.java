package com.green.car.wash.company.order;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.green.car.wash.company.order.controller.OrderController;
import com.green.car.wash.company.order.model.Car;
import com.green.car.wash.company.order.model.OrderDetails;
import com.green.car.wash.company.order.repository.OrderRepo;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderApplicationTests {
	@MockBean
	OrderRepo or;
	@Autowired
	OrderController oc;


	@Test
	public void allOrdersTest() {
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City"))
				).collect(Collectors.toList()));
		assertEquals("This should return all the orders available and count them",6,oc.findallOrders().size());
	}

	@Test
	public void completedOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City"))
				).collect(Collectors.toList()));
		assertEquals("This should filter and count the number of completed orders",3,oc.getCompletedOrders().stream().count());
	}

	@Test
	public void PendingOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals("This should filter and count the number of Pending orders",3,oc.getPendingOrders().stream().count());
	}

	@Test
	public void CancelledOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",null, new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals(3,oc.getCancelledOrders().stream().count());
	}

	@Test
	public void getMyOrdersTest() {
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","x@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",null, new Car(1,"Honda","City")),
				new OrderDetails("a","y@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals("This should return all the orders for  single user",4,oc.getMyOrders("a@gmail.com").size());
	}

	@Test
	public void washerSpecificOrderTest() {
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Joel","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","x@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",null, new Car(1,"Honda","City")),
				new OrderDetails("a","y@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","James","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals("This should return all the orders done by a single washer",4,oc.getWasherSpecificOrders("Kenny").size());
	}
	@Test
	public void cancelOrderbySomeEntity() {
		OrderDetails od = new OrderDetails("a", "a@gmail.com", "NA", "All Clean", 191928363l, "110091", "Cancelled",
				null, new Car(1, "Honda", "City"));
		OrderDetails om = new OrderDetails("a", "a@gmail.com", "NA", "All Clean", 191928363l, "110091", "Pending",
				null, new Car(1, "Honda", "City"));
		when(or.findById(od.getOrderId())).thenReturn(Optional.of(om));
		assertEquals("The order with ID -> " + od.getOrderId() + " is cancelled successfully", oc.cancelOrder(od));
	}

	@Test
	public void UnassignedOrderTest(){
		when(or.findAll()).thenReturn(Stream.of(
				new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Cancelled",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Pending",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","NA","All Clean",191928363l,"110091","Cancelled",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Completed",null, new Car(1,"Honda","City")),
				new OrderDetails("a","a@gmail.com","Kenny","All Clean",191928363l,"110091","Cancelled",null, new Car(1,"Honda","City"))
		).collect(Collectors.toList()));
		assertEquals(4,oc.getUnassignedOrders().size());
	}
}
