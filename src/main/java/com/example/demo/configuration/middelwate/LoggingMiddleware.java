package com.example.demo.configuration.middelwate;

import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
public class LoggingMiddleware implements Command.Middleware {

    @Override
    public <R, C extends Command<R>> R invoke(C comamnd, Next<R> next) {
        R response = next.invoke();        
        return response;
    }

}
