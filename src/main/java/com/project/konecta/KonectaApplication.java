package com.project.konecta;

import com.project.konecta.model.InventarioModel;
import com.project.konecta.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class KonectaApplication {

    @Autowired InventarioService service;

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-5"));
        List<InventarioModel> save = new InventarioModel().registrosPorDefecto();
        save.forEach(data->{
            service.save(data);
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(KonectaApplication.class, args);
    }

}
