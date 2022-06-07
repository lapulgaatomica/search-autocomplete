package com.pulga.searchautocomplete;

import com.pulga.searchautocomplete.trie.Trie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.PriorityQueue;
import java.util.Queue;

@RestController
@RequestMapping("/v1/search")
public class RestSearchController {

    private final Trie trie;

    public RestSearchController(Trie trie) {
        this.trie = trie;
    }

    @GetMapping
    public ResponseEntity<Queue<String>> search(@RequestParam("prefix") String prefix){
        Queue<String> relatedWords = trie.getWords(prefix).orElse(new PriorityQueue<>());
        return ResponseEntity.ok().body(relatedWords);
    }
}
