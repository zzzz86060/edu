package com.zz.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

public class MongoUtils2 {
	static Properties properties;
	static InputStream stream = null;
	static String host;
	static String port;
	static String dbname;
	static String username;
	static String password;
	static String source;
	
	static {
		if(properties == null)
			properties = new Properties();
		try {
			stream = MongoUtils.class.getClassLoader().getResourceAsStream("mongodb.properties");
			properties.load(stream);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		host = properties.getProperty("host");
		port = properties.getProperty("port");
		dbname = properties.getProperty("dbname");
		source = properties.getProperty("source");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
	}
	
	public static MongoClient getMongoClient() {
		MongoCredential credential = MongoCredential.createCredential(username, source,  password.toCharArray());
		MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder().applyToClusterSettings(
				builder->builder.hosts(Arrays.asList(new ServerAddress(host)))).credential(credential).build());
		return mongoClient;
	}
	
	public static GridFSBucket getGridFSConn() {
		MongoClient mongoClient = getMongoClient();
		MongoDatabase mongoDatabse = mongoClient.getDatabase(dbname);
		GridFSBucket gridFSBucket = GridFSBuckets.create(mongoDatabse);
		
		return gridFSBucket;
	}
}
