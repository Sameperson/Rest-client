package com.sameperson.client;

import com.sameperson.client.entity.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class GenericMethod {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        List<Message> messages = client.target("http://localhost:8080/webapi/")
                .path("messages")
                .queryParam("year", 2017)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>() {});

        System.out.println(messages);

    }

}
