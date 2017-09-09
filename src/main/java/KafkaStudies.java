import org.apache.kafka.clients.producer.KafkaProducer;

/**
 * Created by loezerl-fworks on 09/09/17.
 */


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.common.io.Resources;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaStudies {
    public KafkaStudies(){}

    public static void main(String[] args) throws IOException{
        KafkaProducer<String, String> producer;
        try (InputStream props = Resources.getResource("producer.props").openStream()) {
            Properties properties = new Properties();
            properties.load(props);
            producer = new KafkaProducer<>(properties);
        }
        try{
            producer.send(new ProducerRecord<String, String>(
                    "ruk-topic1", "OLAR"));
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally {
            producer.close();
        }
    }
    public static class Consumer{
        public static void main(String[] args) throws IOException{

        }
    }
}
