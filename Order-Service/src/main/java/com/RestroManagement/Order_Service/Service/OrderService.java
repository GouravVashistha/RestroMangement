package com.RestroManagement.Order_Service.Service;


import com.RestroManagement.Order_Service.DTO.OrderDTO;

public interface OrderService {

    OrderDTO placeOrder(OrderDTO orderDTO);

}

