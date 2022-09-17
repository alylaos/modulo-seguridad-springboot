package pe.isil.moduloseguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModuloSeguridadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloSeguridadApplication.class, args);
		int a= 2;
		int b= 10;
		int resultado= (a+b);
		System.out.print("este es el resultado de mi suma"+resultado);
	}

}
