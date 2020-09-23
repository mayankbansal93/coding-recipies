package com.mayank.freedom_from_nested_if_else.goodexample.command_pattern_impl;

import com.mayank.freedom_from_nested_if_else.goodexample.CommandPattern;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.CommandExecutor;
import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Response;

import java.util.List;

public class SingleApplicableRequestCommandPattern implements CommandPattern {
    List<CommandExecutor> commandExecutors;

    public SingleApplicableRequestCommandPattern(List<CommandExecutor> commandExecutors) {
        this.commandExecutors = commandExecutors;
    }

    @Override
    public Response execute(Request request) {
        for (CommandExecutor commandExecutor : commandExecutors) {
            if (commandExecutor.isApplicable(request)) {
                return commandExecutor.execute(request);
            }
        }
        return null;
    }
}
