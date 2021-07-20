package com.example.demo.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

//Esta clase nos ayuda a configurar la libreria Jersey.

@ApplicationPath("/api")  //Ruta base a la aplicación
@Component    //Con esto Spring crea los objetos automáticamente

public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		// Declaramos las clases controladoras
		this.packages("com.example.demo.rest");

	}

}
