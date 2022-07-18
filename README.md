# Project 2 - Design a Multithreaded server

### Project on how non-blocking network communication is done in Java

1. Single-Threaded Blocking Server with old Java.IO
   * Once a client is connected, no other clients can connect until the first client is disconnected
2. Multi-Threaded Blocking Server
   * Multiple clients can connect if we create **new thread per client connection**, however: 
       * there is an OS limitation on how many threads can be created
       * creating many threads will hamper performance
3. ExecutorService Blocking Server
4. Java NIO Blocking Server with Channels
5. Polling Non-Blocking Server
6. Non-Blocking Server with Selector
7. Work-Pool for Transmogrifying