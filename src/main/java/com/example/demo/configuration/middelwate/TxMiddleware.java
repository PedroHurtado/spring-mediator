package com.example.demo.configuration.middelwate;

import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
public class TxMiddleware implements Command.Middleware {

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        R response = next.invoke();
        // end tx
        return response;
    }

}
