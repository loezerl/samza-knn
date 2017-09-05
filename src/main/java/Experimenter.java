import com.yahoo.labs.samoa.instances.Instance;
import joptsimple.OptionSet;
import kafka.consumer.KafkaStream;
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

public class Experimenter {
    /**
     * Experimenter is a Local Application Class. Executes using the local application runner.
     * It takes two required command line arguments
     *  config-factory: a fully {@link org.apache.samza.config.factories.PropertiesConfigFactory} class name
     *  config-path: path to application properties
     *  @param args command line arguments
     */

    public static void main(String args[]) {

        CommandLine cmdLine = new CommandLine();
        OptionSet options = cmdLine.parser().parse(args);
        Config config = cmdLine.loadConfig(options);


//        PageViewCounter app = new PageViewCounter();
        LocalApplicationRunner runner = new LocalApplicationRunner(config);
//        runner.run(app);
        runner.waitForFinish();

        System.out.println("Dummy print");
    }
}
