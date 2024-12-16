package com.example.monumentosv2.errors;

public class MonumentoNotFoundException extends RuntimeException {
    public MonumentoNotFoundException(Long id) {
        super("No hay monumentos con ese ID: %d".formatted(id));
    }

    public  MonumentoNotFoundException (String msg){
        super(msg);
    }

    public MonumentoNotFoundException() {
        super("No hay monumentos con esos requisitos de búsqueda");
    }
}
