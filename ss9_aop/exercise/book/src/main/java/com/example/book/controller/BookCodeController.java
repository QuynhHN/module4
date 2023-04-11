package com.example.book.controller;

import com.example.book.exception.QuantityLowerThanZeroException;
import com.example.book.model.Book;
import com.example.book.model.BookCode;
import com.example.book.model.Borrower;
import com.example.book.service.IBookCodeService;
import com.example.book.service.IBookService;
import com.example.book.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/code")
public class BookCodeController {
    @Autowired
    @Qualifier("bookCodeService")
    private IBookCodeService iBookCodeService;
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowerService iBorrowerService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("bookCodeList", iBookCodeService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        model.addAttribute("borrowerList", iBorrowerService.findAll());
        model.addAttribute("bookCodeList", new BookCode());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate(@ModelAttribute BookCode bookCode) {
        iBookCodeService.save(bookCode);
        return "redirect:/code";
    }

    @GetMapping("/update/{idBookCode}")
    public String showUpdate(@PathVariable int idBookCode, Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        model.addAttribute("borrowerList", iBorrowerService.findAll());
        model.addAttribute("bookCodeList", iBookCodeService.findById(idBookCode));
        return "update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute BookCode bookCode) {
        iBookCodeService.save(bookCode);
        return "redirect:/code";
    }

    @GetMapping("/delete")
    public String performDelete(@RequestParam(required = false) Integer deleteId) {
        iBookCodeService.delete(deleteId);
        return "redirect:/code";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam(name = "idBook") Integer id, @RequestParam(name = "idBorrower") Integer idBorrower, RedirectAttributes redirectAttributes) throws QuantityLowerThanZeroException {
        Borrower borrower = iBorrowerService.findById(idBorrower);
        if (borrower == null) {
            redirectAttributes.addAttribute("msg", "Borrower not found");
            return "redirect:/list";
        }else if (iBookService.findById(id).getQuantity()==0){
            throw new QuantityLowerThanZeroException();
        }else {
            iBookService.borrow(id,idBorrower);
        }
        return "redirect:/code";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam(required = false) Integer codeBook) {
//        iBookService.returnBook(codeBook);
//        iBookCodeService.remove(codeBook);
        return "redirect:/code";
    }
    @ExceptionHandler(Exception.class)
    public String handel(){
        return "/error";
    }
}
