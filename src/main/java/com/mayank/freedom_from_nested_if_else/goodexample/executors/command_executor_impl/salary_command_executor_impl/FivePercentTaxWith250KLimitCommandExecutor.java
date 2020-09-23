package com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.salary_command_executor_impl;

import com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.SalaryCommandExecutor;
import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Salary;
import com.mayank.freedom_from_nested_if_else.model.SalaryResponse;

public class FivePercentTaxWith250KLimitCommandExecutor extends SalaryCommandExecutor {
    @Override
    protected SalaryResponse executeValidCommand(Salary salary) {
        return new SalaryResponse(0.05 * Math.min(250000, salary.getAmount() - 250000));
    }

    @Override
    public Boolean isApplicable(Request request) {
        return ((Salary) request).getAmount() > 250000;
    }
}
