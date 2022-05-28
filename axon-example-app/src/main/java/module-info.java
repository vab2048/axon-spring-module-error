module io.github.vab2048.axon.example_bug.app {

    // Jackson specific (serialization/deserialization).
    opens io.github.vab2048.axon.example_bug.app.controller.dto;
    exports io.github.vab2048.axon.example_bug.app.controller.dto to com.fasterxml.jackson.databind;
    opens io.github.vab2048.axon.example_bug.app.query.account; // Does not stop the error.
    exports io.github.vab2048.axon.example_bug.app.query.account;
    /* ****************************************
     * Opens - For reflection
     * ****************************************/
    opens io.github.vab2048.axon.example_bug.app to spring.beans, spring.core;
    opens io.github.vab2048.axon.example_bug.app.command.account to spring.beans, spring.core, org.axonframework.messaging;
    opens io.github.vab2048.axon.example_bug.app.config to spring.beans, spring.core;
    opens io.github.vab2048.axon.example_bug.app.controller to spring.beans, spring.core, com.fasterxml.jackson.databind;

//    opens io.github.vab2048.axon.example_bug.app.query.account to spring.beans, spring.core, org.axonframework.messaging;

    /* ****************************************
     * Exports - For package access
     * ****************************************/
    exports io.github.vab2048.axon.example_bug.app to spring.context;
    exports io.github.vab2048.axon.example_bug.app.config to spring.context;
    exports io.github.vab2048.axon.example_bug.app.controller to spring.beans, spring.web;


    /* ****************************************
     * Requires - For own module's access to others
     * ****************************************/
    requires io.github.vab2048.axon.example_bug.message_api;
    requires io.swagger.v3.oas.annotations;
    requires io.swagger.v3.oas.models;
    requires java.sql;
    requires org.axonframework.config;
    requires org.axonframework.eventsourcing;
    requires org.axonframework.messaging;
    requires org.axonframework.modelling;
    requires org.axonframework.spring;
    requires org.postgresql.jdbc;
    requires org.slf4j;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.core;
    requires spring.context;
    requires spring.data.commons;
    requires spring.data.jdbc;
    requires spring.data.relational;
    requires spring.web;
    requires spring.webmvc;
}