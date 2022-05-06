package com.codegym.service;

import com.codegym.model.YTe;
import com.codegym.repository.IYTeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YTeServiceImpl implements IYTeService {
    @Autowired
    IYTeRepository iyTeRepository;

    @Override
    public YTe getYTe() {
        return iyTeRepository.getYTe();
    }

    @Override
    public void saveYTe(YTe yTe) {
        iyTeRepository.saveYTe(yTe);
    }
}
