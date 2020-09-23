package com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl;

import com.mayank.freedom_from_nested_if_else.goodexample.executors.CommandExecutor;
import com.mayank.freedom_from_nested_if_else.helper.Constants;
import com.mayank.freedom_from_nested_if_else.model.Age;
import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Response;
import com.mayank.freedom_from_nested_if_else.model.TaxResponse;

public abstract class AgeCommandExecutor implements CommandExecutor {

    @Override
    public Response execute(final Request request) {
        final Age age = (Age) request;
        if (!isValid(age)) {
            return new TaxResponse(-1, Constants.INVALIDCOMMAND);
        }
        return executeValidCommand(age);
    }

    protected abstract Boolean isValid(final Age age);

    protected abstract TaxResponse executeValidCommand(final Age age);
}
