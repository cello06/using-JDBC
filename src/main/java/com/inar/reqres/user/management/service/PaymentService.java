package com.inar.reqres.user.management.service;

import com.inar.reqres.user.management.mappers.PaymentMapper;
import com.inar.reqres.user.management.model.Payment;
import com.inar.reqres.user.management.utils.DBUtils;

import java.util.List;

public class PaymentService {

    public List<Payment> getListOfAllPayments(){
        String query = "SELECT * FROM payment;";
        return DBUtils.executeQuery(query,new PaymentMapper());
    }

    public  Payment getAPaymentByPaymentId(int paymentId){
        String query = "SELECT * FROM payment WHERE payment_id = " + paymentId;
        List<Payment> paymnetList = DBUtils.executeQuery(query,new PaymentMapper());

        return paymnetList.isEmpty() ? null : paymnetList.get(0);
    }
}
