package fr.cdrault.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.cdrault.domain.Article;
import fr.cdrault.service.Loader;
import fr.cdrault.service.Transformer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArticleTransformer implements Transformer{
    private Loader loader;

    @Override
    public void transform(String data) {
        Article article = new Article();
        article.setAuthor(this.pattern(data, "<a rel=\"author\" data-link-name=\"auto tag link\" href=\"[^\"]*\">([^<]*)</a>"));
        if(article.getAuthor() == null){
            return;
        }
        article.setTitle(this.pattern(data, "<h1[^>]*>([^<]*)</h1>"));
        article.setUrl(this.pattern(data, "<websiteuri>([^<]*)</websiteuri>"));
        this.loader.load(article);
    }


    public String pattern(String data, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        while(matcher.find()){
            return(matcher.group(1));
        }
        return null;
    }
}
