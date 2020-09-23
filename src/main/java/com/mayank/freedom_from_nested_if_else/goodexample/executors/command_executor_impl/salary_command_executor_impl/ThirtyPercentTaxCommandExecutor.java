package com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.salary_command_executor_impl;

import com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.SalaryCommandExecutor;
import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Salary;
import com.mayank.freedom_from_nested_if_else.model.SalaryResponse;

public class ThirtyPercentTaxCommandExecutor extends SalaryCommandExecutor {
    @Override
    protected SalaryResponse executeValidCommand(Salary salary) {
        return new SalaryResponse(0.3 * (salary.getAmount() - 1000000));
    }

    @Override
    public Boolean isApplicable(Request request) {
        return ((Salary) request).getAmount() > 1000000;
    }
}
