package evaluators;

import classifiers.Classifier;
import com.yahoo.labs.samoa.instances.Instance;
import moa.core.InstanceExample;
import moa.streams.ArffFileStream;
import org.apache.samza.application.StreamApplication;
import org.apache.samza.config.Config;
import org.apache.samza.operators.MessageStream;
import org.apache.samza.operators.StreamGraph;
import org.apache.samza.system.IncomingMessageEnvelope;
import org.apache.samza.task.MessageCollector;
import org.apache.samza.task.StreamTask;
import org.apache.samza.task.TaskCoordinator;

/**
 * Created by loezerl-fworks on 05/09/17.
 */
public class Prequential extends Evaluator implements StreamApplication{

    private int confirm=0;
    private int miss=0;
    private int[][] confusion_matrix;

    public Prequential(Classifier _classifier, ArffFileStream data){ super(_classifier, data); }

    @Override
    public void run(){}

    public void init(StreamGraph streamGraph, Config config) {

        //Inputs
        MessageStream<Instance> File_instances = streamGraph.getInputStream("arff-file-instances", (k, v) -> (Instance) v);

        //Outputs

    }
}
