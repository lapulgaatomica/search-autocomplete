package com.pulga.searchautocomplete;

import com.pulga.searchautocomplete.trie.Trie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class SearchController {

    private final Trie trie;

    public SearchController(Trie trie) {
        this.trie = trie;
    }

    @GetMapping
    public String homePage(Model model){
        model.addAttribute("insertDTO", new InsertDTO());
        return "index";
    }

    @PostMapping("/insert")
    public String insertWord(@ModelAttribute InsertDTO insertDTO, Model model){
        model.addAttribute("insertDTO", new InsertDTO());
        trie.insert(insertDTO.getWord());
        return "index";
    }
}
