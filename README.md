# samza-knn

- Storm and Samza use different words for similar concepts: spouts in Storm are similar to stream consumers in Samza, bolts are similar to tasks, and tuples are similar to messages in Samza. 
- Storm also has some additional building blocks which don’t have direct equivalents in Samza.
Notas:
Eu acho que vc deve criar as classes implementando as interfaces. E configurar o que é o que no arquivo config.

Minha estrutura é (acho):
- Stream input -> TASK (Classification) -> Stream output(Results)


Ler:
https://samza.apache.org/learn/documentation/latest/api/javadocs/org/apache/samza/system/SystemProducer.html

https://samza.apache.org/learn/documentation/latest/api/javadocs/org/apache/samza/system/SystemConsumer.html

https://samza.apache.org/learn/documentation/latest/api/javadocs/org/apache/samza/system/SystemFactory.html


**Documentação:**
https://samza.apache.org/learn/documentation/latest/

**Configuração:**
https://samza.apache.org/learn/documentation/latest/jobs/configuration-table.html

**Assistir:**
https://www.youtube.com/watch?v=7YBmUKjzg7c

https://www.youtube.com/watch?v=ZWez6hOpirY

https://www.youtube.com/watch?v=fU9hR3kiOK0

**Tutorial:**
https://samza.apache.org/learn/tutorials/latest/hello-samza-high-level-code.html


### Notas:
- Toda classe que implementa ou extende uma classe do Samza, por exemplo: `Streamtask`, `InitableTask`, `WindowableTask`,
deve ter um arquivo `.properties`.
- A classe que implementar a classe `StreamApplication`, será a que vai estruturar toda a topologia do experimento. Essa topologia
é definida na reimplementação do método `public void init(StreamGraph graph, Config config)`.
Para declarar as `input streams` eu devo utilizar a variável `graph` da classe que implementa `StreamApplication`.
Exemplo:
```java
 MessageStream<WikipediaFeedEvent> wikipediaEvents = graph.getInputStream(WIKIPEDIA_STREAM_ID, (k, v) -> (WikipediaFeedEvent) v);
```

- Nessa chamada de função eu declaro qual canal minha aplicação vai consumir.
- `MessageStream` is the in-memory representation of a stream in Samza. It uses generics to ensure type safety across the streams and operations.
- `graph.getInputStream(WIKIPEDIA_STREAM_ID, (k, v) -> (WikipediaFeedEvent) v)` Gets the input MessageStream corresponding to the streamId.
    - K - the type of key in the incoming message
    - V - the type of message in the incoming message
    - M - the type of message in the input MessageStream `(WikipediaFeedEvent)`
- A constante `WIKIPEDIA_STREAM_ID` deve ser a mesma presente no arquivo de configuração.


### Kafka Notes:
- Kafka centralizes communication between producers of data and consumers of that data.
- The basic architecture of Kafka is organized around a few key terms: _topics, producers, consumers, and brokers_.
    - All Kafka messages are organized into _topics_. If you wish to send a message you send it to a specific topic and if you wish to read a message you read it from a specific topic.
    - A _consumer_ pulls messages off of a Kafka topic while _producers_ push messages into a Kafka topic.
    - Lastly, Kafka, as a distributed system, runs in a cluster. Each node in the cluster is called a Kafka _broker_.
- Kafka topics are divided into a number of _partitions_.
- Partitions allow you to **parallelize** a topic by splitting the data in a particular topic across multiple brokers — each partition can be placed on a separate machine to allow for multiple consumers to read from a topic in parallel.
- Consumers can also be parallelized so that multiple consumers can read from multiple partitions in a topic allowing for very high message processing throughput.
More: https://sookocheff.com/post/kafka/kafka-in-a-nutshell/

### WATDO:
- Criar uma função que escreve para strings para um kakfa-topic. (Producer feito, Criar um Consumer e testar) **OK**
    - [Pesquisa 1](https://mapr.com/blog/getting-started-sample-programs-apache-kafka-09/)
- Dar um jeito de escrever para um kafka-topic as instances. **OK**
- Se não tiver como escrever o objeto, criar métodos para serializar/deserializar as instancias. **OK**
    - [Pesquisa 1](https://stackoverflow.com/questions/41141924/send-custom-java-objects-to-kafka-topic)
- A classe `Instance` do MOA já implementa o Serializable do Java. **OK**
- O meu samza job (`StreamTask`) vai ler do meu kafka-topic e processar as streams. Os resultados serão mandados para outro kafka-topic.
    - [Pesquisa 1](https://stackoverflow.com/questions/44936037/consume-remote-kafka-topic-with-samza)
- Acredito que meu Samza `StreamApplication` vai consumir apenas um OutputStream e processa-lo.
- Criar um arquivo de configuração semelhante ao `/home/loezerl-fworks/samza/hello-samza/src/main/config/pageview-filter.properties`. **OK**
- Ver como criar um Factory e como funciona. **OK**.

   
Código para serializar um objeto para ByteArray:
```java
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(baos);
oos.writeObject(example);
oos.close();
byte[] b = baos.toByteArray();
```

Código para deserializar um objeto para ByteArray:
```java
Instance h2;
ByteArrayInputStream bis = new ByteArrayInputStream(b);
ObjectInput in = new ObjectInputStream(bis);
h2 = (Instance) in.readObject();
```




