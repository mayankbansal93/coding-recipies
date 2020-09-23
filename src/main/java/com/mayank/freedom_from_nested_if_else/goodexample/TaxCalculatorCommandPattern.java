package com.mayank.freedom_from_nested_if_else.goodexample;


import com.google.common.collect.ImmutableList;
import com.mayank.freedom_from_nested_if_else.goodexample.command_pattern_impl.SingleApplicableRequestCommandPattern;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.CommandExecutor;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.age_command_executor_impl.NonSeniorCitizenCommandExecutor;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.age_command_executor_impl.SeniorCitizenCommandExecutor;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.age_command_executor_impl.SuperSeniorCitizenCommandExecutor;
import com.mayank.freedom_from_nested_if_else.helper.Constants;
import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Response;
import com.mayank.freedom_from_nested_if_else.model.TaxResponse;

import java.util.List;

public class TaxCalculatorCommandPattern {

    public TaxResponse calculateTax(Request request) {
        List<CommandExecutor> commandExecutorList = ImmutableList.of(new NonSeniorCitizenCommandExecutor(),
                new SeniorCitizenCommandExecutor(), new SuperSeniorCitizenCommandExecutor());
        CommandPattern commandPattern = new SingleApplicableRequestCommandPattern(commandExecutorList);
        Response response = commandPattern.execute(request);
        if (response == null) {
            return new TaxResponse(-1, Constants.INVALIDCOMMAND);
        }
        return (TaxResponse) response;
    }
}
