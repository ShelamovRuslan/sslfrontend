package com.example.sslfrontend.userproduct;


import com.example.sslfrontend.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.sslfrontend.userproducts.UserProductService;

import java.util.List;

@RestController
public class UserProductController {

    private final UserProductService service;
    @Autowired
    public UserProductController(UserProductService service) {
        this.service = service;
    }

    @GetMapping("/user_products")
    public String getUserProductPage (Model model) {
        List<Product> list = service.allUserProducts();
        if (list.isEmpty()){
            return "redirect:/user-page";
        }
        model.addAttribute("AllUserProducts",
                list);
        return "result";
    }

}
