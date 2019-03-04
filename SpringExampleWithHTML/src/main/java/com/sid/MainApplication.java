
package com.sid;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sid.controller.FileUploadController;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class MainApplication {

	public static void main(String[] args) { 
		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(MainApplication.class, args);

	}

}
