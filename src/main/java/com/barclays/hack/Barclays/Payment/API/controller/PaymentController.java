package com.barclays.hack.Barclays.Payment.API.controller;

import com.barclays.hack.Barclays.Payment.API.Model.Order;
import com.barclays.hack.Barclays.Payment.API.Model.OrderStatus;
import com.instamojo.wrapper.api.ApiContext;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.HTTPException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@RestController
@CrossOrigin
@Configuration
@PropertySource("classpath:application.properties")
public class PaymentController {

    ApiContext context = ApiContext.create("test_yRquvveB5ZRIusuZzI8ePW3zMiL0yrSQ6N2","test_kD2aNyUR7ojNk4qJ7T8G6ZAsJGikjuJoQQQtb276MYOCK0EOl1YUjpJjA9k0k8FTL52EzwgyOYuT08hG6cK4SHKdlTBguNldcVSnaIW5vHYWG4bswTfMTbc4Gyi",ApiContext.Mode.TEST);
    Instamojo api = new InstamojoImpl(context);

    @RequestMapping(value = "/payment/v1", method = RequestMethod.POST)
    public Object createPayment(@RequestBody Order request){
        UUID uuid=UUID.randomUUID(); //Generates random UUID
        PaymentOrder order = new PaymentOrder();
        order.setName(request.getName());
        order.setEmail(request.getEmail());
        order.setPhone(request.getPhone());
        order.setCurrency("INR");
        order.setAmount(request.getAmount());
        order.setDescription(request.getDescription());
        order.setRedirectUrl("https://barclays-bookstore.web.app/home");
        order.setTransactionId(uuid.toString());

        PaymentOrderResponse paymentOrderResponse = null;
        try {
            paymentOrderResponse = api.createPaymentOrder(order);
        } catch (ConnectionException connectionException) {
            connectionException.printStackTrace();
        } catch (HTTPException httpException) {
            httpException.printStackTrace();
        }
        return paymentOrderResponse;
    }


    //4f479392-610e-4e2c-9d47-1f819bafe572
    @RequestMapping(value="/order/{transactionID}/",method = RequestMethod.GET)
    public OrderStatus getOrderData(@PathVariable("transactionID") @NotBlank(message = "TransactionID cannot be blank") String transactionID){
        /*
         * Get details of payment order when transaction id is given
         */
        OrderStatus order=new OrderStatus();
        try {
            PaymentOrder paymentOrder = api.getPaymentOrderByTransactionId(transactionID);
            order.setID(paymentOrder.getId());
            order.setStatus(paymentOrder.getStatus());

        } catch (HTTPException e) {
            System.out.println(e.getStatusCode());
            System.out.println(e.getMessage());
            System.out.println(e.getJsonPayload());

        } catch (ConnectionException e) {
            System.out.println(e.getMessage());
        }
        return order;
    }


}
