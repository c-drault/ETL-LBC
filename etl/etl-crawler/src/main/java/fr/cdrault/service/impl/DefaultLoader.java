package fr.cdrault.service.impl;

import fr.cdrault.domain.Article;
import fr.cdrault.service.Loader;

public class DefaultLoader implements Loader {

    @Override
    public void load(Article article) {
        System.out.println("Article : \"" + article.getTitle() + "\" de " + article.getAuthor() + " a : " + article.getUrl() );
    }
}
