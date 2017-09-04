import moa.streams.ArffFileStream;
import org.apache.samza.application.StreamApplication;
import org.apache.samza.config.Config;
import org.apache.samza.operators.StreamGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by loezerl-fworks on 04/09/17.
 */
public class InstancesGenerator {
    ArffFileStream file;

    private static final Logger log = LoggerFactory.getLogger(InstancesGenerator.class);
    public InstancesGenerator(ArffFileStream file){this.file = file;}

    public void start(){
        while(file.hasMoreInstances()){

        }
    }

    public void stop(){

    }

}
