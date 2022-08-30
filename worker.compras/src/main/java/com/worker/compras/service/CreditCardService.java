package com.worker.compras.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public class CreditCardService {
   public static String generateNumber() {
       var seq1 = new BigDecimal(1000 + Math.random() * 500);
       var seq2 = new BigDecimal(2000 + Math.random() * 500);
       var seq3 = new BigDecimal(3000 + Math.random() * 500);
       var seq4 = new BigDecimal(4000 + Math.random() * 500);
       return new StringBuilder()
               .append(seq1).append(" ")
               .append(seq2).append(" ")
               .append(seq3).append(" ")
               .append(seq4).append(" ")
               .toString();
   }
   public static BigDecimal generateLimit() {
       return new BigDecimal(1000 + Math.random() * 500);
   }
}
