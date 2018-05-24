package com.mitraiscdc.databasedemo;

import com.mitraiscdc.databasedemo.dao.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private PersonDao personDao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        logger.info("all person -> {}", personDao.findAll());
        logger.info("person id 100 -> {}", personDao.findById(100));
//        logger.info("deleted id 100 -> {}", personDao.deletebyId(100));
    }


}
