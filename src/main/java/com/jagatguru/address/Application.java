package com.jagatguru.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.awt.*;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jagatguru.address"})
public class Application {

  public static void main(String[] args) {
    ConfigurableApplicationContext context =
        new SpringApplicationBuilder(Application.class).headless(false).run(args);
    EventQueue.invokeLater(() -> {

      GuiApplication screen = context.getBean(GuiApplication.class);
      screen.setVisible(true);
    });
    SpringApplication.run(Application.class, args);
  }
}