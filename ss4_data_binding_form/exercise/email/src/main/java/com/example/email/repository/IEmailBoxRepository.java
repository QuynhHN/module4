package com.example.email.repository;

import com.example.email.model.EmailBox;

public interface IEmailBoxRepository {
    EmailBox emailBox();

    void update(EmailBox emailBox1);

    String[] getLanguagesList();

    Integer[] getPagesizesList();

}
