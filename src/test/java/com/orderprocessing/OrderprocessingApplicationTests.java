package com.orderprocessing;

import com.orderprocessing.models.Order;
import com.orderprocessing.services.BulkOrderService;
import com.orderprocessing.services.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderprocessingApplicationTests {

	@MockBean
	private OrderService orderService;

	@MockBean
	private BulkOrderService bulkOrderService;

	Order mockOrder1 = new Order(1, 1, 1, "3/1/2021", "3/2/2021", "ground");
	Order mockOrder2 = new Order(2, 2, 2, "3/1/2021", "3/2/2021", "freight");
	List<Order> orderList1 = Arrays.asList(mockOrder1, mockOrder2);
	List<Order> testList = new ArrayList<>();

	@Test
	public void getOrderByIdTest() {
		Mockito.when(orderService.getOrderById(1)).thenReturn(mockOrder1);
	}

	@Test
	public void deleteOrderTest() {
		Mockito.when(orderService.deleteOrder(1)).thenReturn(true);
		Mockito.when(orderService.deleteOrder(1)).thenReturn(false);
	}

	@Test
	public void createMultipleOrdersTest() {
		Mockito.when(bulkOrderService.createMultipleOrders(orderList1).size()).thenReturn(2);
	}
}
