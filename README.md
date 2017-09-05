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
