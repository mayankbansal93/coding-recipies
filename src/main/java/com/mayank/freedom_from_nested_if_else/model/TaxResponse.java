package com.mayank.freedom_from_nested_if_else.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TaxResponse extends Response {
    private double tax;
    private String status;
}
