package fr.cdrault.apilbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cdrault.apilbc.domain.Article;
import fr.cdrault.apilbc.repository.ArticleRepository;

@RestController
@RequestMapping("search")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    
    @GetMapping("/title/{searchWord}")
    public List<Article> titleSearch(@PathVariable String searchWord){
        System.out.println("Search for title containe " + searchWord);
        return this.articleRepository.findByTitleContaining(searchWord);
    }

    @GetMapping("/author/{searchWord}")
    public List<Article> authorSearch(@PathVariable String searchWord){
        return this.articleRepository.findByAuthorContaining(searchWord);
    }

    @GetMapping("/all")
    public List<Article> findAll(){
        List<Article> result = new ArrayList<Article>();
        for(Article a : this.articleRepository.findAll()){
            result.add(a);
        }
        return result;
    }
}
