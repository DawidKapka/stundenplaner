package ch.sp.stundenplaner.api.dto;

public abstract class AbstractDto {

    protected <T extends AbstractDto> AbstractDto fromJson(String json, Class<T> dtoClass) {
        return null;
    }
}
