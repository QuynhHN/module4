package com.example.email.service;

import com.example.email.model.EmailBox;

public interface IEmailBoxService {
    EmailBox emailBox();
    void update(EmailBox emailBox1);

    String[] getLanguagesList();

    Integer[] getPagesizesList();
}
