import com.yahoo.labs.samoa.instances.Instance;
import kafka.consumer.KafkaStream;
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

public class Experimenter implements MessageCollector {
    public static void main(String args[]) {

        CommandLine cmdLine = new CommandLine();

        Config config = cmdLine.loadConfig(cmdLine.parser().parse(args));
//        PageViewCounter app = new PageViewCounter();
        LocalApplicationRunner runner = new LocalApplicationRunner(config);
//        runner.run(app);
        runner.waitForFinish();

        System.out.println("Dummy print");
    }

    public void send(OutgoingMessageEnvelope outgoingMessageEnvelope) {

    }
}
