// TODO: Uncomment this when needed deep logging messages
//package com.torres.config;
//
//import java.util.logging.ConsoleHandler;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//@Configuration
//@PropertySource("classpath:logger.properties")
//public class LoggerConfig {
//	@Value("${root.logger.level}")
//	private String rootLoggerLevel;
//	@Value("${printed.logger.level}")
//	private String printedLoggerLevel;
//	
//	@PostConstruct
//	public void initLogger() {
//		Level rootLevel = Level.parse(rootLoggerLevel);
//		Level printedLevel = Level.parse(printedLoggerLevel);
//		
//		// Get the Logger for App Context
//		Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
//		// Get the Parent Logger
//		Logger parentLogger = applicationContextLogger.getParent();
//		// Set Root Logging Level
//		parentLogger.setLevel(rootLevel);
//		// Set Up Console Handler
//		ConsoleHandler consoleHandler = new ConsoleHandler();
//		consoleHandler.setLevel(printedLevel);
//		consoleHandler.setFormatter(new SimpleFormatter());
//		// Add Handler to the Logger
//		parentLogger.addHandler(consoleHandler);
//	}
//}