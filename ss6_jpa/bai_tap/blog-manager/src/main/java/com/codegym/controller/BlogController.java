package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/home")
    public String goHome(Model model,
                         @PageableDefault(value = 4) Pageable pageable
            , @RequestParam Optional<String> name
    ) {
        String keyword = name.orElse("");
        model.addAttribute("keywordVal", keyword);
        model.addAttribute("blogList", this.iBlogService.findAllByName(keyword, pageable));
//        model.addAttribute("blogList",this.iBlogService.findAll(pageable));
        return "home";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createBlog(Blog blog,
                             RedirectAttributes redirectAttributes) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "create successful !");
        return "redirect:/home";
    }

//    @GetMapping(value = "/search")
//    public String searchBlog(Model model, @RequestParam(value = "search") String name) {
//        model.addAttribute("blogList", this.iBlogService.findByName(name));
//        return "home";
//    }

    @GetMapping(value = "/detail")
    public String detailBlog(Model model,
                             @RequestParam(value = "id") String id) {
        model.addAttribute("blog", this.iBlogService.findById(Integer.parseInt(id)));
        return "detail";
    }

    @GetMapping(value = "/edit")
    public String goEditForm(Model model,
                             @RequestParam(value = "id") String id) {
        model.addAttribute("blog", this.iBlogService.findById(Integer.parseInt(id)));
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editBlog(Blog blog,
                           RedirectAttributes redirectAttributes) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "update successful !");
        return "redirect:/home";
    }

    @PostMapping(value = "/delete")
    public String deleteBlog(@RequestParam String id,
                             RedirectAttributes redirectAttributes) {
        Blog blog = this.iBlogService.findById(Integer.parseInt(id));
        this.iBlogService.delete(blog);
        redirectAttributes.addFlashAttribute("message", "delete successful !");
        return "redirect:/home";
    }
}
