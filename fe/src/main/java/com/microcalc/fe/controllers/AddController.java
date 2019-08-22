package com.microcalc.fe.controllers;

import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
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

import javax.swing.text.StringContent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.sun.org.apache.xml.internal.serialize.OutputFormat.Defaults.Encoding;

@Controller
public class AddController {
    private static final String URL = "http://proxy:9000/add";


    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ResponseEntity add(@RequestBody Map<String, Object> payload) throws IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        StringEntity requestEntity = new StringEntity(
                new JSONObject(payload).toString(),
                ContentType.APPLICATION_JSON);
        HttpPost postMethod = new HttpPost(URL);
        postMethod.setEntity(requestEntity);

        HttpResponse response = httpClient.execute(postMethod);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(EntityUtils.toString(response.getEntity()));
    }

}
