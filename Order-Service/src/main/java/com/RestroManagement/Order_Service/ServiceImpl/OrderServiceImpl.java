package com.RestroManagement.Order_Service.ServiceImpl;

import com.RestroManagement.Order_Service.DTO.OrderDTO;
import com.RestroManagement.Order_Service.Entity.Order;
import com.RestroManagement.Order_Service.Entity.OrderLineItems;
import com.RestroManagement.Order_Service.Repository.OrderRepository;
import com.RestroManagement.Order_Service.Service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        // Convert OrderDTO to Order entity
        Order order = modelMapper.map(orderDTO, Order.class);

        // Set the OrderLineItems for the Order
        List<OrderLineItems> orderLineItemsList = orderDTO.getOrderLineItemsList().stream()
                .map(orderLineItemsDTO -> modelMapper.map(orderLineItemsDTO, OrderLineItems.class))
                .collect(Collectors.toList());
        order.setOrderLineItemsList(orderLineItemsList);

        // Save the Order entity to the repository
        Order savedOrder = orderRepository.save(order);

        // Convert the saved Order entity back to OrderDTO
        return modelMapper.map(savedOrder, OrderDTO.class);
    }

    @Override

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }
}
