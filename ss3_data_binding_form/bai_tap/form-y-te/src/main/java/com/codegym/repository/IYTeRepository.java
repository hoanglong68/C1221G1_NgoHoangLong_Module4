package com.codegym.repository;

import com.codegym.model.YTe;

public interface IYTeRepository {
    YTe getYTe();
    void saveYTe(YTe yTe);
}
