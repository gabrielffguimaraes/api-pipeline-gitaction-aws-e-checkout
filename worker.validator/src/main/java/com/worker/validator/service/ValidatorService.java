package com.worker.validator.service;

import com.worker.validator.exceptions.LimitNotValidException;
import com.worker.validator.exceptions.MoneyNotEnoughException;
import com.worker.validator.model.CreditCard;
import com.worker.validator.model.Order;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    public void validOrder(Order order) {
        checkAnyAvailableLimit(order.getCreditCard());
        checkAvailableLimit(order);
    }
    private void checkAnyAvailableLimit(CreditCard creditCard) throws MoneyNotEnoughException {
        if(creditCard.availableLimit.doubleValue() <= 0)
            throw new MoneyNotEnoughException("Ooh no , sorry but it seems your credit card limit is not available");
    }
    private void checkAvailableLimit(Order order) {
        if(order.getValue().doubleValue() > order.getCreditCard().availableLimit.doubleValue())
            throw new LimitNotValidException("Ooh no , sorry but it seems your credit card limit is not enough . ",order);
    }
}
