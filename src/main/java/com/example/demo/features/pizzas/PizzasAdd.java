package com.example.demo.features.pizzas;



import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dominio.Pizza;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Configuration
public class PizzasAdd {

    
    public record Request(String id,String name) implements Command<Pizza> {}

    @RestController
    @RequestMapping("/pizzas")
    public class Controller{    
        private final Pipeline pipeline;
        public Controller(final Pipeline pipeline){
            this.pipeline = pipeline;
        }    
        @PostMapping()
        public ResponseEntity<?> action(@RequestBody Request request){            
            var response = this.pipeline.send(request);
            return ResponseEntity.status(201).body(response);
        }
    }
    @Component
    public class Service implements Command.Handler<Request, Pizza>{

        @Override
        public Pizza handle(Request request) {     
            /*var pizza = Pizza.create(request.id, request.name);*/
            Pizza pizza = Pizza.create(request.id, request.name); 
            return pizza;
        }

    }
}
