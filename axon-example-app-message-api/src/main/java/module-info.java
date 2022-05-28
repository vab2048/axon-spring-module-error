module io.github.vab2048.axon.example_bug.message_api {
    opens io.github.vab2048.axon.example_bug.message_api.command;
    opens io.github.vab2048.axon.example_bug.message_api.query;


    exports io.github.vab2048.axon.example_bug.message_api.command;
    exports io.github.vab2048.axon.example_bug.message_api.query;

    requires org.axonframework.modelling;
}