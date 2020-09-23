package com.mayank.freedom_from_nested_if_else.goodexample.command_pattern_impl;

import com.mayank.freedom_from_nested_if_else.goodexample.CommandPattern;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.CommandExecutor;
import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Response;
import com.mayank.freedom_from_nested_if_else.model.SalaryResponse;

import java.util.List;

public class MultipleApplicableRequestCommandPattern implements CommandPattern {
    List<CommandExecutor> commandExecutors;

    public MultipleApplicableRequestCommandPattern(List<CommandExecutor> commandExecutors) {
        this.commandExecutors = commandExecutors;
    }

    @Override
    public Response execute(Request request) {
        SalaryResponse salaryResponse = new SalaryResponse(0);
        for (CommandExecutor commandExecutor : commandExecutors) {
            if (commandExecutor.isApplicable(request)) {
                salaryResponse.setAmount(salaryResponse.getAmount() +
                        ((SalaryResponse) commandExecutor.execute(request)).getAmount());
            }
        }
        return salaryResponse;
    }
}
