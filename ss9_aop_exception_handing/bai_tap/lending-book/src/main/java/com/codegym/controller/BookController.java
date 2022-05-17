package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.BookLending;
import com.codegym.service.IBookLendingService;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    IBookLendingService iBookLendingService;

    @GetMapping(value = "/list")
    public String goList(Model model) {
        model.addAttribute("bookList", this.iBookService.findAll());
        return "list";
    }

    @GetMapping(value = "/detail")
    public String goDetailBook(@RequestParam String idBook, Model model) {
        Book book = this.iBookService.findById(idBook);
        model.addAttribute("book", book);
        return "detail";
    }

    @GetMapping(value = "/lend")
    public String doLendBook(@RequestParam String idBook, Model model,
                           RedirectAttributes redirectAttributes) {
        Book book = this.iBookService.findById(idBook);
        if (book.getQuantity() <= 0) {
            model.addAttribute("msg","library is out of book !");
            return "error";
        } else {
            book.setQuantity(book.getQuantity() - 1);
            BookLending bookLending = new BookLending();
            String idBookLend = String.valueOf(Math.round(Math.random() * 89999 + 10000));
            BookLending existBookLending = this.iBookLendingService.findById(idBookLend);
            while (existBookLending != null) {
                idBookLend = String.valueOf(Math.round(Math.random() * 89999 + 10000));
            }
            bookLending.setIdBookLending(idBookLend);
            bookLending.setBook(book);
            bookLending.setNameBookLend(book.getNameBook());
            iBookLendingService.save(bookLending);
            redirectAttributes.addFlashAttribute
                    ("message", "lend successful !" + bookLending.getNameBookLend() + ", please save your code lend book ! " + idBookLend);
            return "redirect:/list";
        }
    }

    @GetMapping(value = "/giveBack")
    public String doGiveBackBook(
            @RequestParam String idBookLend,
            Model model,
            RedirectAttributes redirectAttributes) {
        BookLending bookLending = this.iBookLendingService.findById(idBookLend);
        if (bookLending == null) {
            model.addAttribute("msg","code is not exist !");
            return "error";
        } else {
            Book book = bookLending.getBook();
            book.setQuantity(book.getQuantity() + 1);
            this.iBookLendingService.delete(bookLending);
            redirectAttributes.addFlashAttribute("message", "give back successful !");
            return "redirect:/list";
        }
    }
}
