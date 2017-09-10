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

import org.apache.samza.application.StreamApplication;
import org.apache.samza.config.Config;
import org.apache.samza.operators.MessageStream;
import org.apache.samza.operators.StreamGraph;

/**
 * Created by loezerl-fworks on 04/09/17.
 */

public class Experimenter implements StreamApplication {
    /**
     * Experimenter is a Local Application Class. Executes using the local application runner.
     * It takes two required command line arguments
     *  config-factory: a fully {@link org.apache.samza.config.factories.PropertiesConfigFactory} class name
     *  config-path: path to application properties
     *  @param args command line arguments
     */

    private static  String INPUT_TOPIC = "Instances";
    private static  String OUTPUT_TOPIC = "Results";

    public static void main(String[] args) {
        System.out.println("Dummy print");
    }

    @Override
    public void init(StreamGraph streamGraph, Config config) {
        MessageStream<byte[]> Instances = streamGraph.getInputStream(INPUT_TOPIC, (k, v) -> (byte[]) v);
    }
}
