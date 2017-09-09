import com.yahoo.labs.samoa.instances.Instance;
import moa.streams.ArffFileStream;
import org.apache.hadoop.hdfs.util.ByteArray;
import org.apache.kafka.clients.producer.KafkaProducer;

/**
 * Created by loezerl-fworks on 09/09/17.
 */


import java.io.*;
import java.util.Properties;

import com.google.common.io.Resources;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaStudies {
    public static String DATABASE;
    public static String KAFKA_TOPIC;

    public KafkaStudies(){}

    public static void main(String[] args) throws IOException{


        DATABASE = args[0];
        KAFKA_TOPIC = args[1];

        ArffFileStream file = new ArffFileStream(DATABASE, -1);


        KafkaProducer<String, byte[]> producer;
        try (InputStream props = Resources.getResource("producer.props").openStream()) {
            Properties properties = new Properties();
            properties.load(props);
            producer = new KafkaProducer<>(properties);
        }
        try{
            while(file.hasMoreInstances()){
                Instance example = file.nextInstance().getData();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(example);
                oos.close();

                byte[] b = baos.toByteArray();
                producer.send(new ProducerRecord<String, byte[]>(KAFKA_TOPIC, b));
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally {
            producer.close();
        }
    }
}
