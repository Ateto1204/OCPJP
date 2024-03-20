package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
@RequestMapping("/api")
class ApiController {

	// GET請求示例
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello, SpringBoot!";
	}

	// POST請求示例
	@PostMapping("/user")
	public String createUser(@RequestBody User user) {
		// 創建用戶的邏輯
		return "User created: " + user.getName();
	}
}

class User {
	private String name;
	private int age;

	// getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}