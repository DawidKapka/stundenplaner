package ch.sp.stundenplaner.api.dto;

import com.google.gson.Gson;

public class JsonParser {

    public static String toJson(AbstractDto dto) {
        final Gson gson = new Gson();
        return gson.toJson(dto);
    }
}
