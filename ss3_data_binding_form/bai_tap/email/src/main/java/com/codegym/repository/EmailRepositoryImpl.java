package com.codegym.repository;

import com.codegym.model.Email;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepositoryImpl implements IEmailRepository {
   public static List<Email> emailList = new ArrayList<>();
    static {
        emailList.add(new Email("English","5",true,"long"));
    }

    @Override
    public List<Email> getList() {
        return emailList;
    }

    @Override
    public void save(Email email) {
        emailList.add(email);
    }
}
