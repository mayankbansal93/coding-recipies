package com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl;

import com.mayank.freedom_from_nested_if_else.goodexample.executors.CommandExecutor;
import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Response;
import com.mayank.freedom_from_nested_if_else.model.Salary;
import com.mayank.freedom_from_nested_if_else.model.SalaryResponse;

public abstract class SalaryCommandExecutor implements CommandExecutor {
    @Override
    public Response execute(final Request request) {
        final Salary salary = (Salary) request;
        return executeValidCommand(salary);
    }

    protected abstract SalaryResponse executeValidCommand(final Salary salary);
}
