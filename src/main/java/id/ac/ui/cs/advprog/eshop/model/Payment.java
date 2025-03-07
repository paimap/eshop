package id.ac.ui.cs.advprog.eshop.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
class Payment {
    String id;
    String method;
    String status;
    Map<String, String> paymentData;

    Payment(String id, String method, String status) {
    }

    Payment(String id, String method, String status, Map<String, String> paymentData) {
    }

}