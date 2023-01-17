package com.harunsevinc.events;

import org.jboss.logging.Logger;
import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.models.KeycloakSession;

public class RabbitMQEventListenerProvider implements EventListenerProvider {

    private static final Logger log = Logger.getLogger(RabbitMQEventListenerProvider.class);
    private final KeycloakSession keycloakSession;

    public RabbitMQEventListenerProvider(KeycloakSession keycloakSession) {
        this.keycloakSession = keycloakSession;
    }

    @Override
    public void onEvent(Event event) {
        if(event.getType() == EventType.LOGIN){
            //Do something here
            log.info("User has logged in!");
        }

    }

    @Override
    public void onEvent(AdminEvent event, boolean includeRepresentation) {

    }

    @Override
    public void close() {

    }
}
