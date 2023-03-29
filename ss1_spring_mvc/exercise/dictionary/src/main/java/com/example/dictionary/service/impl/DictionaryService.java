package com.example.dictionary.service.impl;

import com.example.dictionary.repository.IDictionaryRepository;
import com.example.dictionary.repository.impl.DictionaryRepository;
import com.example.dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
private IDictionaryRepository iDictionaryRepository= new DictionaryRepository();
    @Override
    public String list(String dictionary) {
        return iDictionaryRepository.list(dictionary);
    }
}
