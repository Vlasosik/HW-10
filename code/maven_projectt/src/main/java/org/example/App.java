package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonProcessingException {
        Map<String, String> info = new HashMap<>();
        info.put("name","Vlas");
        info.put("lastname","Pototskyi");

        ObjectMapper objectMapper = new ObjectMapper();
        String text = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(info);
        System.out.println(text);
    }
}
