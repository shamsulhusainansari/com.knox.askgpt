package com.knox.askgpt.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.Map;

@Getter
public class AskGptException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6907996719611457114L;
    HttpStatus statusCode= HttpStatus.BAD_REQUEST;

    private String code;
    private String fallbackMessage;
    private String[] args;

    private Map<String,String> intErrors;

    public AskGptException(String message){
        super(message);
    }
    public AskGptException(String code, String message){
        this(message);
        this.code = code;
    }

    public AskGptException(String code, String message, Map<String,String> intErrors){
        this(code, message);
        this.intErrors = intErrors;
    }
    public AskGptException(ErrorMessageEnum error) {
        this(error.getCode(), error.getMessage());
        this.statusCode = HttpStatus.valueOf(Integer.parseInt(error.getHttpCode()));
    }

    public AskGptException(String code, String message, Throwable th){
        super(message,th);
        this.code = code;

    }

    public AskGptException(String code, String message, Map<String,String> intErrors, Throwable th){
        super(message,th);
        this.code = code;
        this.intErrors = intErrors;
    }


    public AskGptException(String code, String message, String[] args){
        this(code,message,args,null,null,null);
    }
    public AskGptException(String code, String message, String[] args, Map<String,String> intErrors){
        this(code,message,args,intErrors,null,null);
    }


    public AskGptException(String code, String message, String[] args, String fallbackMessage){
        this(code,message,args,fallbackMessage,null);
    }

    public AskGptException(String code, String message, String[] args, Throwable th){
        this(code,message,args,null,null,th);
    }

    public AskGptException(String code, String message, String[] args, Map<String,String> intErrors, Throwable th){
        this(code,message,args,intErrors,null,th);
    }
    public AskGptException(String code, String message, String[] args, String fallbackMessage, Throwable th){
        this(code,message,args,null,fallbackMessage,null);
    }
    public AskGptException(String code, String message, String[] args, Map<String,String> intErrors, String fallbackMessage, Throwable th){
        super(message,th);
        this.code = code;
        this.args = args;
        this.intErrors = intErrors;
        this.fallbackMessage = fallbackMessage;
    }

}
