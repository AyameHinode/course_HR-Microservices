package com.repliforce.hrpayroll.servces;

import com.repliforce.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Double workerId, int days){
        return new Payment("Axl", 150.00, days);

    }

}
