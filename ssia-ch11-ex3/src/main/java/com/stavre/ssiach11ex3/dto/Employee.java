package com.stavre.ssiach11ex3.dto;

import java.util.List;

public record Employee(
        String name,
        List<String> books,
        List<String> roles
) {}
