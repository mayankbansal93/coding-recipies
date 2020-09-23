package com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.age_command_executor_impl;

import com.google.common.collect.ImmutableList;
import com.mayank.freedom_from_nested_if_else.goodexample.CommandPattern;
import com.mayank.freedom_from_nested_if_else.goodexample.command_pattern_impl.MultipleApplicableRequestCommandPattern;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.CommandExecutor;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.AgeCommandExecutor;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.salary_command_executor_impl.FivePercentTaxWith250KLimitCommandExecutor;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.salary_command_executor_impl.ThirtyPercentTaxCommandExecutor;
import com.mayank.freedom_from_nested_if_else.goodexample.executors.command_executor_impl.salary_command_executor_impl.TwentyPercentTaxCommandExecutor;
import com.mayank.freedom_from_nested_if_else.helper.Constants;
import com.mayank.freedom_from_nested_if_else.model.*;

import java.util.List;

public class NonSeniorCitizenCommandExecutor extends AgeCommandExecutor {
    @Override
    protected Boolean isValid(Age age) {
        return age.getAge() < 60;
    }

    @Override
    protected TaxResponse executeValidCommand(Age age) {
        Salary salary = age.getSalary();
        List<CommandExecutor> commandExecutorList = ImmutableList.of(new FivePercentTaxWith250KLimitCommandExecutor(),
                new TwentyPercentTaxCommandExecutor(), new ThirtyPercentTaxCommandExecutor());
        CommandPattern commandPattern = new MultipleApplicableRequestCommandPattern(commandExecutorList);
        SalaryResponse response = (SalaryResponse) commandPattern.execute(salary);
        return new TaxResponse(response.getAmount(), Constants.SUCCESS);
    }

    @Override
    public Boolean isApplicable(Request request) {
        return Constants.NONSENIORCITIZEN.equals(((Age) request).getCategory());
    }
}
