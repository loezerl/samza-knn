/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package evaluators;

import classifiers.Classifier;
import com.yahoo.labs.samoa.instances.Instance;
import moa.streams.ArffFileStream;
import org.apache.samza.system.IncomingMessageEnvelope;
import org.apache.samza.task.MessageCollector;
import org.apache.samza.task.StreamTask;
import org.apache.samza.task.TaskCoordinator;
import java.io.ByteArrayInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * Created by loezerl-fworks on 05/09/17.
 */
public class Prequential extends Evaluator implements StreamTask {

    private int confirm=0;
    private int miss=0;
    private int[][] confusion_matrix;

    private static  String OUTPUT_TOPIC = "results-output";

    public Prequential(Classifier _classifier, ArffFileStream data){ super(_classifier, data); }

    public void run(){}

    public void process(IncomingMessageEnvelope incomingMessageEnvelope,
                        MessageCollector messageCollector, TaskCoordinator taskCoordinator) throws Exception {
        Instance h2;
        ByteArrayInputStream bis = new ByteArrayInputStream((byte[])incomingMessageEnvelope.getMessage());
        ObjectInput in = new ObjectInputStream(bis);
        h2 = (Instance) in.readObject();
        System.err.println(h2.toString());

//        messageCollector.send(new OutgoingMessageEnvelope(OUTPUT_TOPIC, outgoingMap));

    }

}
