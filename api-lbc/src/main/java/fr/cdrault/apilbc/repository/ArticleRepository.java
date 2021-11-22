package fr.cdrault.apilbc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.cdrault.apilbc.domain.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer>{
    List<Article> findByTitleContaining(String string);
    List<Article> findByAuthorContaining(String string);
}