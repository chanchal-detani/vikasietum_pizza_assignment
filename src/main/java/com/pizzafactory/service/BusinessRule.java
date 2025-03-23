package com.pizzafactory.service;

import com.pizzafactory.model.Order;

public interface BusinessRule {
    boolean validate(Order order);
}
