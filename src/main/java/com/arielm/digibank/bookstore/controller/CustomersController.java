package com.arielm.digibank.bookstore.controller;

import com.arielm.digibank.bookstore.controller.dto.CustomerDTO;
import com.arielm.digibank.bookstore.controller.dto.ErrorDTO;
import com.arielm.digibank.bookstore.service.CustomersService;
import com.arielm.digibank.bookstore.service.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "customers", produces = {APPLICATION_JSON_VALUE})
public class CustomersController {
    @Autowired
    CustomersService customersService;

    @RequestMapping(value = "/", method = RequestMethod.POST ,produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public long addCustomer(@RequestBody CustomerDTO customerDTO)
    {
        return customerDTO.getId() == 0 ? customersService.addCustomer(customerDTO.getName(), customerDTO.getDescription()) :
                customersService.addCustomer(customerDTO.getId(), customerDTO.getName(), customerDTO.getDescription());
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customersService.getById(id);
    }


    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ErrorDTO handleException(Exception ex) {
        return new ErrorDTO("Error Occurred: " + ex.getMessage());
    }
}
