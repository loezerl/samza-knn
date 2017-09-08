package evaluators;

import classifiers.Classifier;
import moa.streams.ArffFileStream;
import org.apache.samza.application.StreamApplication;
import org.apache.samza.config.Config;
import org.apache.samza.operators.StreamGraph;

/**
 * Created by loezerl-fworks on 05/09/17.
 */
public class Evaluator implements StreamApplication{
    public Classifier mClassifier;
    public ArffFileStream data_source;

    public Evaluator(Classifier _classifier, ArffFileStream _data){
        mClassifier = _classifier;
        data_source = _data;
    }

    public void run() throws Exception{}

    @Override
    public void init(StreamGraph streamGraph, Config config) {

    }
}