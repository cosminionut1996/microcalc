package com.microcalc.fe.controllers;

import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
public class AddController {
    private static final String URL = "http://proxy:9000/add";

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ResponseEntity add(@RequestBody Map<String, Object> payload) throws IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(URL);
        StringEntity stringEntity =new StringEntity(new JSONObject(payload).toString());
        httpPost.setEntity(stringEntity);
        stringEntity.setContentType("application/json");
        HttpResponse response = httpClient.execute(httpPost);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new JSONObject(response));
    }

}
