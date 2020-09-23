package com.mayank.freedom_from_nested_if_else.badexample;

import com.mayank.freedom_from_nested_if_else.helper.Constants;
import com.mayank.freedom_from_nested_if_else.model.Age;
import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Salary;
import com.mayank.freedom_from_nested_if_else.model.TaxResponse;

public class TaxCalculatorNestedIfElse {

    public TaxResponse calculateTax(Request request) {
        Age age = (Age) request;
        if (Constants.NONSENIORCITIZEN.equals(age.getCategory())) {
            if (!(age.getAge() < 60)) {
                return new TaxResponse(-1, Constants.INVALIDCOMMAND);
            }
            Salary salary = age.getSalary();
            double tax;
            if (salary.getAmount() <= 250000) {
                tax = 0.0;
            } else if (salary.getAmount() > 250000 && salary.getAmount() <= 500000) {
                tax = 0.05 * (salary.getAmount() - 250000);
            } else if (salary.getAmount() > 500000 && salary.getAmount() <= 1000000) {
                tax = 0.05 * 250000 + 0.2 * (salary.getAmount() - 500000);
            } else {
                tax = 0.05 * 250000 + 0.2 * 500000 + 0.3 * (salary.getAmount() - 1000000);
            }
            return new TaxResponse(tax, Constants.SUCCESS);

        } else if (Constants.SENIORCITIZEN.equals(age.getCategory())) {
            if (!(age.getAge() >= 60 && age.getAge() <= 80)) {
                return new TaxResponse(-1, Constants.INVALIDCOMMAND);
            }
            Salary salary = age.getSalary();
            double tax;
            if (salary.getAmount() <= 300000) {
                tax = 0.0;
            } else if (salary.getAmount() > 300000 && salary.getAmount() <= 500000) {
                tax = 0.05 * (salary.getAmount() - 300000);
            } else if (salary.getAmount() > 500000 && salary.getAmount() <= 1000000) {
                tax = 0.05 * 200000 + 0.2 * (salary.getAmount() - 500000);
            } else {
                tax = 0.05 * 200000 + 0.2 * 500000 + 0.3 * (salary.getAmount() - 1000000);
            }
            return new TaxResponse(tax, Constants.SUCCESS);

        } else if (Constants.SUPERSENIORCITIZEN.equals(age.getCategory())) {
            if (!(age.getAge() > 80)) {
                return new TaxResponse(-1, Constants.INVALIDCOMMAND);
            }
            Salary salary = age.getSalary();
            double tax;
            if (salary.getAmount() <= 500000) {
                tax = 0.0;
            } else if (salary.getAmount() > 500000 && salary.getAmount() <= 1000000) {
                tax = 0.2 * (salary.getAmount() - 500000);
            } else {
                tax = 0.2 * 500000 + 0.3 * (salary.getAmount() - 1000000);
            }
            return new TaxResponse(tax, Constants.SUCCESS);

        } else {
            return new TaxResponse(-1, Constants.INVALIDCOMMAND);
        }
    }
}
