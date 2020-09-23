package com.mayank.freedom_from_nested_if_else.goodexample.executors;


import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Response;

public interface CommandExecutor {
    Response execute(final Request request);

    Boolean isApplicable(final Request request);

}
