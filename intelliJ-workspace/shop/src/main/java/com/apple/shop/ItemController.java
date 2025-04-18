package com.apple.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
    private final ItemRepository itemRepository;
    @Autowired
    public ItemController(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;
    }

    @GetMapping("/list")
    String list(Model model){
        model.addAttribute("name", "이정민");
        return "list.html";
    }
}
