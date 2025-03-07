package id.ac.ui.cs.advprog.eshop.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Builder
@Getter
class Payment {
    String id;
    String method;
    String status;
    Map<String, String> paymentData;

    Payment(String id, String method, String status) {
        this.id = id;

        String [] statusArray = {"REJECTED", "SUCCESS"};
        if(Arrays.stream(statusArray).noneMatch(x -> x.equals(status))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }

        String [] methodArray = {"bankTransfer", "voucherCode"};
        if(Arrays.stream(methodArray).noneMatch(x -> x.equals(method))) {
            throw new IllegalArgumentException();
        }else {
            this.method = method;
        }
    }

    Payment(String id, String method, String status, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.status = status;
        this.paymentData = paymentData;
    }

}