package mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.varia.NullAppender;
import org.bson.Document;
import java.util.List;

public class MongoUtils {

    private static final String mongoServer = "172.20.0.6";

    public static void exportOnMongo(List<?> jsons) {

        org.apache.log4j.BasicConfigurator.configure(new NullAppender());
        MongoClient mongoClient = new MongoClient(mongoServer, 27017);
        MongoDatabase database = mongoClient.getDatabase("myMongoDb");
        if (database.getCollection("SABDProject1") == null)
            database.createCollection("SABDProject1", null);
        MongoCollection collection = database.getCollection("SABDProject1");
        System.out.println(jsons);
        for (Object json : jsons) {
            Document document = Document.parse(json.toString());
            collection.insertOne(document);
        }

        MongoCursor cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

        mongoClient.close();
    }
}
