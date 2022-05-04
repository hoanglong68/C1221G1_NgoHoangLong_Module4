package com.codegym.service.impl;

import com.codegym.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    private final Integer RATE = 23000;

    @Override
    public float convert(float usd) {
        return usd * RATE;
    }
}
