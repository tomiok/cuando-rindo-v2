package com.cuandorindov2.resources.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by tomaslingotti on 6/29/17.
 */
@Component
public class JsonConverterUtil<E> {

    private static final ObjectMapper OM = new ObjectMapper();

    public E convert(String path, Class<E> clazz) {
        E result;
        try {
            result = OM.readValue(new File(path), clazz);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return result;
    }

    public String toJsonString(Object o ) {
        try {
            return OM.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}
