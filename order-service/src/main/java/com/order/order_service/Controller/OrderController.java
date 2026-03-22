package com.order.order_service.Controller;

import com.order.order_service.Model.Order;
import com.order.order_service.Model.ProductDTO;
import com.order.order_service.Model.UserDTO;
import com.order.order_service.Service.ProductClient;
import com.order.order_service.Service.UserClient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;



import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final UserClient userClient;
    private final ProductClient productClient;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {

        UserDTO user = userClient.getUser(order.getUserId());
        ProductDTO product = productClient.getProduct(order.getProductId());

        if (user == null || product == null) {
            return "Invalid user or product!";
        }

        return "Order placed successfully!";
    }
}
