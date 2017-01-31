package com.sameperson.client;

import com.sameperson.client.entity.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Main {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        WebTarget baseTarget = client.target("http://localhost:8080/webapi/");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messagesTarget.path("{messageId}");

        Message message = singleMessageTarget
                .resolveTemplate("messageId", 1)
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);
        System.out.println(message.getMessage());

    }

}
