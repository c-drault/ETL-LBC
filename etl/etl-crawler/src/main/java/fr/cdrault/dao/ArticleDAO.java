package fr.cdrault.dao;

import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.bson.types.ObjectId;

import fr.cdrault.dao.utils.MongoDBConnection;
import fr.cdrault.domain.Article;

public class ArticleDAO {
    private MongoCollection<Document> articleCollection;

    public ArticleDAO(MongoDBConnection connection){
        this.articleCollection = connection.getCollection("article");
    }

    public void addArticle(Article article){
        Document articleDoc = new Document("_id", new ObjectId());
        articleDoc.append("author", article.getAuthor())
                    .append("title", article.getTitle())
                    .append("url", article.getUrl());

        this.articleCollection.insertOne(articleDoc);
    }    
}
