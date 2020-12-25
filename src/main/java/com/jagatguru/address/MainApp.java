package com.jagatguru.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

@SpringBootApplication
public class MainApp {

  public static void main(String[] args) {
    ConfigurableApplicationContext context =
        new SpringApplicationBuilder(MainApp.class).headless(false).run(args);
    EventQueue.invokeLater(() -> {

      GuiApplication screen = context.getBean(GuiApplication.class);
      screen.setVisible(true);
    });
    SpringApplication.run(MainApp.class, args);
  }
}
