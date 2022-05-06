package com.codegym.repository;

import com.codegym.model.YTe;
import org.springframework.stereotype.Repository;

@Repository
public class YTeRepositoryImpl implements IYTeRepository {
    public YTe yTe = null;

    @Override
    public YTe getYTe() {
        return yTe;
    }

    public void setyTe(YTe yTe) {
        this.yTe = yTe;
    }

    @Override
    public void saveYTe(YTe yTe) {
        setyTe(yTe);
    }
}
