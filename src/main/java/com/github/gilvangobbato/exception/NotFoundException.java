package com.github.gilvangobbato.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        this("Erro no processamento");
    }

    public NotFoundException(String message){
        super(message);
    }
}
