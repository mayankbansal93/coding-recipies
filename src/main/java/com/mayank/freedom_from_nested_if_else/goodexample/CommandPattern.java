package com.mayank.freedom_from_nested_if_else.goodexample;

import com.mayank.freedom_from_nested_if_else.model.Request;
import com.mayank.freedom_from_nested_if_else.model.Response;

public interface CommandPattern {
    Response execute(Request request);
}
