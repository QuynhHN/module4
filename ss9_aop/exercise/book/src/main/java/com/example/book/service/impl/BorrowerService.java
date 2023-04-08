package com.example.book.service.impl;

import com.example.book.model.Borrower;
import com.example.book.repository.IBorrowerRepository;
import com.example.book.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("borrowerService")
public class BorrowerService implements IBorrowerService {
    @Autowired
    private IBorrowerRepository iBorrowerRepository;

    @Override
    public List<Borrower> findAll() {
        return iBorrowerRepository.findAll();
    }

    @Override
    public Borrower findById(int idBorrower) {
        return iBorrowerRepository.findById(idBorrower);
    }
}
