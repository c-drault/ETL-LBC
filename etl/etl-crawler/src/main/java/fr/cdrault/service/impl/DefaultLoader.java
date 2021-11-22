package fr.cdrault.service.impl;

import fr.cdrault.dao.ArticleDAO;
import fr.cdrault.domain.Article;
import fr.cdrault.service.Loader;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefaultLoader implements Loader {
    private ArticleDAO articleDAO;

    @Override
    public void load(Article article) {
        articleDAO.addArticle(article);
        // System.out.println("Article : \"" + article.getTitle() + "\" de " + article.getAuthor() + " a : " + article.getUrl() );
    }
}
