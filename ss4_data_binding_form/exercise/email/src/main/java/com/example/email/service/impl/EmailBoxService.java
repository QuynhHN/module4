package com.example.email.service.impl;

import com.example.email.model.EmailBox;
import com.example.email.repository.IEmailBoxRepository;
import com.example.email.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailBoxService implements IEmailBoxService {
    @Autowired
    private IEmailBoxRepository iEmailBoxRepository;


    @Override
    public EmailBox emailBox() {
        return iEmailBoxRepository.emailBox();
    }

    @Override
    public void update(EmailBox emailBox1) {
        iEmailBoxRepository.update(emailBox1);
    }

    @Override
    public String[] getLanguagesList() {
        return iEmailBoxRepository.getLanguagesList();
    }

    @Override
    public Integer[] getPagesizesList() {
        return iEmailBoxRepository.getPagesizesList();
    }
}
