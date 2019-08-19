package com.microcalc.mul.controllers;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class MultiplicationController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity doMultiplication(@RequestBody Map<String, Object> payload) {
        Integer x, y, result;

        try{
            x = Integer.parseInt((String) payload.get("x"));
            y = Integer.parseInt((String) payload.get("y"));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid payload!");
        }

        result = x * y;

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new JSONObject().put("result", result).toString());

    }
}
