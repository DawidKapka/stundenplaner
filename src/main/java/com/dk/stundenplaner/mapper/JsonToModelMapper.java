package com.dk.stundenplaner.mapper;

import com.dk.stundenplaner.model.AbstractModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonToModelMapper {

    public static <T extends AbstractModel> List<T> mapToModel(String json, Class<T> modelClass) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            final JsonNode jsonNodes = objectMapper.readTree(json);
            final List<T> modelList = new ArrayList<>();
            for (JsonNode node : jsonNodes) {
                final T model = objectMapper.treeToValue(node, modelClass);
                modelList.add(model);
            }
            return modelList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
