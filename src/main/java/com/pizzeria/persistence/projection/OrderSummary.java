package com.pizzeria.persistence.projection;

import java.time.LocalDate;

public interface OrderSummary {

    Integer getIdOrder();
    String getCustomerName();
    LocalDate getOrderDate();
    Double getTotalPrice();
    String getPizzaName();

}
