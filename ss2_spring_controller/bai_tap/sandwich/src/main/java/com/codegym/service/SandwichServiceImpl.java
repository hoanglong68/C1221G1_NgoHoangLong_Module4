package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class SandwichServiceImpl implements ISandwichService {
    @Override
    public String[] check(String[] condiment) {
        String[] condimentList;
        if (condiment.length > 1) {
            condimentList = condiment;
        } else {
            condimentList = new String[]{"khong co gi"};
        }
        return condimentList;
    }
}
