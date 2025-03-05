package com.studyGuide.project;

import com.studyGuide.project.entitys.User;
import com.studyGuide.project.repositories.UserRepo;
import com.studyGuide.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class ProjectApplication {




	public static void main(String[] args) {
		 SpringApplication.run(ProjectApplication.class, args);
	}



}
