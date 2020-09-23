package com.mayank.freedom_from_nested_if_else;

import com.mayank.freedom_from_nested_if_else.badexample.TaxCalculatorNestedIfElse;
import com.mayank.freedom_from_nested_if_else.helper.Constants;
import com.mayank.freedom_from_nested_if_else.model.Age;
import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Salary;
import com.mayank.freedom_from_nested_if_else.model.TaxResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorNestedIfElseTest {
    TaxCalculatorNestedIfElse taxCalculatorNestedIfElse;

    @BeforeEach
    void setUp() {
        taxCalculatorNestedIfElse = new TaxCalculatorNestedIfElse();
    }

    @Test
    void calculateTaxTest() {
        Request request1 = new Age(Constants.NONSENIORCITIZEN, 35, new Salary(1500000));
        TaxResponse taxResponse1 = taxCalculatorNestedIfElse.calculateTax(request1);
        assertEquals(Constants.SUCCESS, taxResponse1.getStatus());
        assertEquals(262500, taxResponse1.getTax());

        Request request2 = new Age(Constants.SENIORCITIZEN, 65, new Salary(1500000));
        TaxResponse taxResponse2 = taxCalculatorNestedIfElse.calculateTax(request2);
        assertEquals(Constants.SUCCESS, taxResponse2.getStatus());
        assertEquals(260000, taxResponse2.getTax());

        Request request3 = new Age(Constants.SENIORCITIZEN, 30, new Salary(1500000));
        TaxResponse taxResponse3 = taxCalculatorNestedIfElse.calculateTax(request3);
        assertEquals(Constants.INVALIDCOMMAND, taxResponse3.getStatus());
        assertEquals(-1, taxResponse3.getTax());
    }
}
