package com.mayank.freedom_from_nested_if_else.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Age extends Request {
    String category;
    int age;
    Salary salary;
}
