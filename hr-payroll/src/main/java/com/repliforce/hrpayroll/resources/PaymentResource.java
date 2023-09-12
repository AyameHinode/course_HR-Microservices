package com.repliforce.hrpayroll.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.repliforce.hrpayroll.entities.Payment;
import com.repliforce.hrpayroll.servces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(
            @PathVariable long workerId, @PathVariable Integer days){
        Payment payment = paymentService.getPayment(workerId, days);
        return  ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment>getPaymentAlternative(long workerID, Integer days){

        Payment payment = new Payment("Sigma", 1000.0, days);
        return ResponseEntity.ok(payment);

    }

}
