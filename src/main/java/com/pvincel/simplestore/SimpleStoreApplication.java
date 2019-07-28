package com.pvincel.simplestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		SimpleStoreApplication.class,
		Jsr310JpaConverters.class
})

public class SimpleStoreApplication {

	private static final String UTC = "UTC";

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone(UTC));
	}


	public static void main(String[] args) {
		SpringApplication.run(SimpleStoreApplication.class, args);
	}
	@RestController
	@RequestMapping(value = "sample")
	public static class SampleController {

		@RequestMapping(value = "filter", method = {RequestMethod.GET, RequestMethod.POST})
		public String filter(@RequestBody(required = false) String filter) {
			return filter != null ? filter : "no input";
		}
	}

}
