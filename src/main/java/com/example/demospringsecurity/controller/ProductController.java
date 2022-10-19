package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.mapper.ProductMapper;
import com.example.demospringsecurity.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    /**
     * All products
     */
    @GetMapping
    public String homePageView(Model model) {
        List<Product> products = productMapper.selectAll();
        model.addAttribute("products", products);
        return "products/index";
    }
    /**
     * A certain products
     */
    @GetMapping(value = "{id}")
    public String getProduct(@PathVariable(name = "id") Long id, Model model) {
        Product product = productMapper.select(id);
        model.addAttribute("product", product);
        return "products/show";
    }
    /**
     *Display of new creation screen
     */
    @GetMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "products/new";
    }
    /**
     *Create new product
     */
    @PostMapping(value = "/save")
    public String postProductCreate(@ModelAttribute("product") @Valid Product product,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "products/new";
        }
        productMapper.insert(product);
        return "redirect:/";
    }

    /**
     *Display of new edit screen
     */
    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable Long id, Model model) {
        Product product = productMapper.select(id);
        model.addAttribute("product", product);
        return "products/edit";
    }
    /**
     *Edit
     */
    @PutMapping("/update")
    public String putProductEdit(@ModelAttribute @Valid Product product,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "products/edit";
        }
        productMapper.update(product);
        return "redirect:/";
    }
    /**
     *Delete product
     */
    @GetMapping(value = "delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productMapper.delete(id);
        return "redirect:/";
    }


    @GetMapping("/403")
    public String errore403(){
        return "products/403";
    }


//    john - password1234 - editor
//    patrick - codeJava - user
//    namhm - metallica - creator/editor
//    admin - hdhd999 - admin
//    alex - springsecurity - creator



}

