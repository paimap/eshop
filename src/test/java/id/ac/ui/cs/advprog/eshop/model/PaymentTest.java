package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTest {
    @Test
    void testCreatePaymentSuccessStatus(){
        Payment payment = new Payment(
                "123456789",
                "voucherCode",
                "SUCCESS"
        );

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentRejectedStatus (){
        Payment payment = new Payment(
                "123456789",
                "voucherCode",
                "REJECTED"
        );

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentInvalidStatus (){
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment(
                    "123456789",
                    "voucherCode",
                    "CAPEK"
            );
        });
    }

    @Test
    void testCreatePaymentVoucherCodeMethod(){
        Payment payment = new Payment(
                "123456789",
                "voucherCode",
                "REJECTED"
        );
        assertEquals("voucherCode", payment.getMethod());
    }

    @Test
    void testCreatePaymentBankTransferMethod(){
        Payment payment = new Payment(
                "123456789",
                "bankTransfer",
                "REJECTED"
        );
        assertEquals("bankTransfer", payment.getMethod());
    }

    @Test
    void testCreatePaymentInvalidMethod (){
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment(
                    "123456789",
                    "capek",
                    "REJECTED"
            );
        });
    }
}