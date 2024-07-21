package com.RestroManagement.Order_Service.Controller;

import com.RestroManagement.Order_Service.DTO.OrderDTO;
import com.RestroManagement.Order_Service.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/PlaceOrder")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO placedOrder = orderService.placeOrder(orderDTO);
        return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);
    }
    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> allOrders = orderService.getAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }



}
