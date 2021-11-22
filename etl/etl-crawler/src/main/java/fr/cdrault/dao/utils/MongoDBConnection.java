package fr.cdrault.dao.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;


public class MongoDBConnection implements Connection {
    private MongoDatabase mongoDatabase;

    public MongoDBConnection(){
        //TODO Variabiliser (Parametre)
        MongoClient mongoClient = MongoClients.create("mongodb://root:example@127.0.0.1:27017");
        this.mongoDatabase = mongoClient.getDatabase("etl");
    }

    public MongoCollection<Document> getCollection(String collectionName){
        return this.mongoDatabase.getCollection(collectionName);
    }




}
