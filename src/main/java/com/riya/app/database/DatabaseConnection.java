package com.riya.app.database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Collections.singletonList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import com.riya.app.model.Question;

public class DatabaseConnection {

    private MongoClient mongoClient;
    private static DatabaseConnection databaseConnection = null;

    private DatabaseConnection() {
        String uri = "mongodb://127.0.0.1:27017/?directConnection=true&serverSelectionTimeoutMS=2000&appName=mongosh+1.10.5";
        ConnectionString connectionString = new ConnectionString(uri);
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider
                .builder()
                .automatic(true)
                .build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        try {
            this.mongoClient = MongoClients.create(clientSettings);
            System.out.println("DatabaseConnection.DatabaseConnection()");
        } finally {
        }

    }

    public static DatabaseConnection getDatabaseConnection() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    public MongoClient getClient() {
        return this.mongoClient;
    }

}
