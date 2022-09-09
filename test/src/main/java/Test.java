import com.mongodb.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Test {
    private static final String MONGO_HOST = "localhost";
    private static final Integer MONGO_PORT = 27017;
    private static final String MONGO_DB_NAME = "user201800301236";
    private static final String MONGO_COLLECTION_NAME = "teacher";
    private static final String path = "/Users/wangziteng/Desktop/nosql/dataresource/teacher.xlsx";
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(MONGO_HOST, MONGO_PORT);
        DB db = mongoClient.getDB(MONGO_DB_NAME);
        DBCollection collection = db.getCollection(MONGO_COLLECTION_NAME);
        importExcel imexcel = new importExcel();
        try {
            imexcel.importExcel(collection,path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}