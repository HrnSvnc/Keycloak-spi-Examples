# Keycloak-spi-Examples
This repository contains some spi examples for keycloak.

## You can use SPI ([Service Provider Interfaces](https://www.keycloak.org/docs/latest/server_development/#_providers)) in Keycloak to react to certain events. In this repository i will try to cover some common possibilities to react to events and redirect these to your application. In this scenario i use a newly created Keycloak docker image.
To activate your events you need to build a jar file from your spi implementation and put it inside your keycloak server folder under "opt/keycloak/providers"

### This Repository covers the following implementations
- HTTP: User simple http calls to make a request to your applications endpoints 
- RabbitMQ: Sending messages to a queue on a certain event
