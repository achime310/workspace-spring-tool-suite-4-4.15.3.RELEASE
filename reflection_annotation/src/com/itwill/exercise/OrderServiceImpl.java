package com.itwill.exercise;
@Service(value = "orderService")
public class OrderServiceImpl {
	@Autowire
	@Qualifier("orderDao")
	private OrderDaoImpl orderDaoImpl;
	
	public OrderServiceImpl() {

	}
	@Autowire
	public OrderServiceImpl(@Qualifier(value = "orderDao") OrderDaoImpl orderDaoImpl) {
		super();
		this.orderDaoImpl = orderDaoImpl;
	}

	public OrderDaoImpl getOrderDaoImpl() {
		return orderDaoImpl;
	}
	@Autowire(value = "orderDao")
	
	public void setOrderDaoImpl(OrderDaoImpl orderDaoImpl) {
		this.orderDaoImpl = orderDaoImpl;
	}
	
	
}
