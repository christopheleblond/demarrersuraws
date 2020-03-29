import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DynamoDbClientWriter {

    public static Logger LOG = LoggerFactory.getLogger(DynamoDbClientWriter.class);

    public static void main(String[] args) throws InterruptedException {

        String tableName = "demoaws";

        // Client
        AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion("eu-west-3")
                //.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, "eu-west-3"))
                .build();

        DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);
        Table demoawsTable = null;

        try {
            dynamoDBClient.describeTable(tableName);

            demoawsTable = dynamoDB.getTable(tableName);

            LOG.info("Table {} already exists.", demoawsTable.getTableName());

        }catch(ResourceNotFoundException re) {

            demoawsTable = createTable(tableName, "id", dynamoDB);

            LOG.info("Table {} created !", demoawsTable.getTableName());
        }

        Movie[] movies = {
                new Movie(UUID.randomUUID().toString(), "Un nouvel espoir", 1979),
                new Movie(UUID.randomUUID().toString(), "L'empire contre attaque", 1980),
                new Movie(UUID.randomUUID().toString(), "Le Retour Du Jedi", 1983)
        };

        putMovies(tableName, Arrays.asList(movies), dynamoDB);

    }

    static Table createTable(String tableName, String key, DynamoDB dynamoDB) throws InterruptedException {
        // Set Partition Key
        ArrayList<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
        keySchema.add(new KeySchemaElement().withAttributeName(key).withKeyType(KeyType.HASH));

        // Define attributes
        ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
        attributeDefinitions.add(new AttributeDefinition().withAttributeName(key).withAttributeType(ScalarAttributeType.S));

        // Prepare request
        CreateTableRequest createTableRequest = new CreateTableRequest()
                .withTableName(tableName)
                .withAttributeDefinitions(attributeDefinitions)
                .withBillingMode(BillingMode.PAY_PER_REQUEST)
                .withKeySchema(keySchema);

        Table table = dynamoDB.createTable(createTableRequest);

        table.waitForActive();

        return table;
    }

    static void putMovies(String tableName, List<Movie> movies, DynamoDB dynamoDB) {

        Table table = dynamoDB.getTable(tableName);

        movies.stream().map(m -> new Item()
                .withPrimaryKey("id", m.getId())
                .withString("title", m.getTitle())
                .withInt("year", m.getYear()))
        .forEach(item -> {
            table.putItem(item);

            LOG.info("Put Movie: {}", item.toJSONPretty());
        });
    }
}
