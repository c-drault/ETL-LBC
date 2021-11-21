package fr.cdrault;

import java.io.IOException;

import fr.cdrault.dao.ArticleDAO;
import fr.cdrault.dao.utils.MongoDBConnection;
import fr.cdrault.service.Loader;
import fr.cdrault.service.Transformer;
import fr.cdrault.service.impl.ArticleTransformer;
import fr.cdrault.service.impl.CrawlerExtracter;
import fr.cdrault.service.impl.DefaultLoader;

public class App 
{
    public static void main( String[] args ) throws IOException{
        MongoDBConnection connection = new MongoDBConnection();
        ArticleDAO adao = new ArticleDAO(connection);
        Loader loader = new DefaultLoader(adao);
        Transformer transformer = new ArticleTransformer(loader);
        CrawlerExtracter extracter = new CrawlerExtracter("https://www.theguardian.com", transformer, 2000); //Variabiliser
        extracter.extract();
    }
}
