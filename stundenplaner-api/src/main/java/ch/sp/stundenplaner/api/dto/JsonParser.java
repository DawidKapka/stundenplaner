package ch.sp.stundenplaner.api.dto;

import com.dk.stundenplaner.model.AbstractModel;
import com.google.gson.Gson;

public class JsonParser {

    public static String toJson(Object dto) {
        final Gson gson = new Gson();
        return gson.toJson(dto);
    }
}
