package fr.cdrault;

import java.io.IOException;

import fr.cdrault.service.Loader;
import fr.cdrault.service.Transformer;
import fr.cdrault.service.impl.ArticleTransformer;
import fr.cdrault.service.impl.CrawlerExtracter;
import fr.cdrault.service.impl.DefaultLoader;

public class App 
{
    public static void main( String[] args ) throws IOException{
        Loader loader = new DefaultLoader();
        Transformer transformer = new ArticleTransformer(loader);
        CrawlerExtracter extracter = new CrawlerExtracter("https://www.theguardian.com", transformer, 10); //Variabiliser
        extracter.extract();
    }
}
