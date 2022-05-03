package com.example.tfg.repositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.mongojack.JacksonMongoCollection;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class Repository<T> {
    protected final MongoCollection<T> collection;

    public Repository(String database, String collection, Class<T> cls) {
        this.collection = getCollection(database, collection, cls);
    }

    public static <T> JacksonMongoCollection<T> getCollection(String database, String collection, Class<T> valueType) {
        MongoClient mongoClient = getMongoClient();
        return JacksonMongoCollection.builder()
                .build(mongoClient, database, collection, valueType, UuidRepresentation.STANDARD);
    }

    public List<T> findAll() {
        List<T> documents = new ArrayList<>();
        this.collection.find().forEach(documents::add);
        return documents;
    }

    public T findOne(String id) {
        return this.collection.find(eq("_id", id)).first();
    }

    public void insertOne(T object) {
        this.collection.insertOne(object);
    }

    public void deleteOne(String id) {
        this.collection.deleteOne(eq("_id", id));
    }

    private static MongoClient getMongoClient() {
        String mongoHost = "localhost";
        Integer mongoPort = 27017;
        ConnectionString connString = new ConnectionString(String.format("mongodb://%s:%s", mongoHost, mongoPort));
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(
                PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .codecRegistry(codecRegistry)
                .retryWrites(true)
                .build();
        return MongoClients.create(settings);
    }
}

