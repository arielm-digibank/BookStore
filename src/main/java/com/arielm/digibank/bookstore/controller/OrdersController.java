package com.arielm.digibank.bookstore.controller;

import com.arielm.digibank.bookstore.controller.dto.ErrorDTO;
import com.arielm.digibank.bookstore.controller.dto.OrderDTO;
import com.arielm.digibank.bookstore.service.OrdersService;
import com.arielm.digibank.bookstore.service.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "orders", produces = {APPLICATION_JSON_VALUE})
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @RequestMapping(value = "/", method = RequestMethod.POST ,produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public long addOrder(@RequestBody OrderDTO orderDTO)
    {
        return ordersService.addOrder(orderDTO.getBookId(), orderDTO.getCustomerId());
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id) {
        return ordersService.getOrder(id);
    }

    @GetMapping("/customer/{id}")
    public List<Order> getOrderByCustomerId(@PathVariable long id) {
        return ordersService.getOrdersByCustomer(id);
    }


    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ErrorDTO handleException(Exception ex) {
        return new ErrorDTO("Error Occurred: " + ex.getMessage());
    }
}
