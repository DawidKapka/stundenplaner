package ch.sp.stundenplaner.api.dto;

import com.google.gson.Gson;

public abstract class AbstractDto {

    protected static <T extends AbstractDto> T fromJson(String json, Class<T> dtoClass) {
        final Gson gson = new Gson();
        return gson.fromJson(json, dtoClass);
    }
}
