package com.example.email.repository.impl;

import com.example.email.model.EmailBox;
import com.example.email.repository.IEmailBoxRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailBoxRepository implements IEmailBoxRepository {
    private static EmailBox emailBox;
    private  String [] languagesList= new String[]{"English","Vietnamese"," Japanese","Chinese"};
    private Integer [] pagesizesList= new Integer[]{5,10,15,25,50,100};
    {
        emailBox = new EmailBox("English", 25, false, "Thor, King, Asgard");

    }

    public String[] getLanguagesList() {
        return languagesList;
    }

    public Integer[] getPagesizesList() {
        return pagesizesList;
    }

    @Override
    public EmailBox emailBox() {
        return emailBox;
    }

    @Override
    public void update(EmailBox emailBox1) {
        emailBox.setLanguage(emailBox1.getLanguage());
        emailBox.setPageSize(emailBox1.getPageSize());
        emailBox.setSpamsFilter(emailBox1.getSpamsFilter());
        emailBox.setSignature(emailBox1.getSignature());


    }
}
