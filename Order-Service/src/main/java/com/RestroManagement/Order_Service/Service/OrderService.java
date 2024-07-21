package com.RestroManagement.Order_Service.Service;


import com.RestroManagement.Order_Service.DTO.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO placeOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
}

