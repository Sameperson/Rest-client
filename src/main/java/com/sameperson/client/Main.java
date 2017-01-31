package com.sameperson.client;

import com.sameperson.client.entity.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class Main {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8080/webapi/messages/1").request().get();
        Message message = response.readEntity(Message.class);
        System.out.println(message.getMessage());

    }

}
