package com.harunsevinc.events;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.jboss.logging.Logger;
import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.models.KeycloakSession;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQEventListenerProvider implements EventListenerProvider {

    private static final Logger log = Logger.getLogger(RabbitMQEventListenerProvider.class);
    private final KeycloakSession keycloakSession;

    private final static String QUEUE_NAME = "YourQueueName";


    public RabbitMQEventListenerProvider(KeycloakSession keycloakSession) {
        this.keycloakSession = keycloakSession;
    }

    @Override
    public void onEvent(Event event) {
        //Check for event or add as Many events as you like
        if(event.getType() == EventType.REGISTER){

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");

            try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                // Your message could also be an object which need to be deserialized
                String message = "Some Message";
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
            } catch (IOException | TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onEvent(AdminEvent event, boolean includeRepresentation) {

    }

    @Override
    public void close() {

    }
}
