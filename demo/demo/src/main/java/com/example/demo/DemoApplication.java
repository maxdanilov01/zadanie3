package com.example.demo;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping(value = "/test", method = RequestMethod.POST, consumes = "application/json")
	public String getData(@RequestBody Person person){
		String personName = person.getName();
		Integer personAge = person.getAge();
		Integer personSalary = person.getSalary();
		Integer personId = person.getId();
		String personSolve = "";
		if ((personAge > 20 && personAge < 50) && (personSalary > 20000)) {
			personSolve = "odobreno";
		} else {
			personSolve = "otkazano";
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", personName);
		jsonObject.put("id", personId);
		jsonObject.put("solve", personSolve);
		return String.valueOf(jsonObject);
	}
}