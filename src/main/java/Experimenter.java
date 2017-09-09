import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yahoo.labs.samoa.instances.Instance;
import joptsimple.OptionSet;
import kafka.consumer.KafkaStream;
import moa.streams.ArffFileStream;
import moa.streams.InstanceStream;
import org.apache.avro.generic.GenericRecord;
import org.apache.samza.config.Config;
import org.apache.samza.runtime.LocalApplicationRunner;
import org.apache.samza.system.IncomingMessageEnvelope;
import org.apache.samza.system.OutgoingMessageEnvelope;
import org.apache.samza.system.SystemStream;
import org.apache.samza.task.MessageCollector;
import org.apache.samza.task.StreamTask;
import org.apache.samza.task.TaskCoordinator;



/**
 * Created by loezerl-fworks on 04/09/17.
 */

import org.apache.samza.task.MessageCollector;
import org.apache.samza.util.CommandLine;
import scala.annotation.meta.param;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.SerializedInstancesLoader;
import weka.core.converters.SerializedInstancesSaver;
import weka.core.json.JSONInstances;
import weka.core.json.JSONNode;


import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

public class Experimenter {
    /**
     * Experimenter is a Local Application Class. Executes using the local application runner.
     * It takes two required command line arguments
     *  config-factory: a fully {@link org.apache.samza.config.factories.PropertiesConfigFactory} class name
     *  config-path: path to application properties
     *  @param args command line arguments
     */

    public static void main(String args[]) {

//        CommandLine cmdLine = new CommandLine();
//        OptionSet options = cmdLine.parser().parse(args);
//        Config config = cmdLine.loadConfig(options);
//
//
////        PageViewCounter app = new PageViewCounter();
//        LocalApplicationRunner runner = new LocalApplicationRunner(config);
////        runner.run(app);
//        runner.waitForFinish();
//        String DIABETES_DATABASE = "/home/loezerl-fworks/IdeaProjects/Experimenter/diabetes.arff";
//
//        ArffFileStream file = new ArffFileStream(DIABETES_DATABASE, -1);
//
//        Instance example = file.nextInstance().getData();
//
//        Gson gson = new Gson();
//
//        String testao = gson.toJson(example);
//
//        TypeToken<Instance> token = new TypeToken<Instance>(){};
//
//       try {
//           Instance desa = gson.fromJson(testao, token.getType());
//       }catch(Exception e){
//           System.out.println(e.getMessage());
//       }

        System.out.println("Dummy print");
    }
}
