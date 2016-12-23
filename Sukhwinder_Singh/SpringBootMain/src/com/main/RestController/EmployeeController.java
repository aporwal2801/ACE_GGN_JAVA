package com.main.RestController;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String getEmp() {
		return "Get resoponse";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveEmp() {
		return "New Emp Record Saved";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String updateEmp() {

		if (true) {
			throw new IllegalArgumentException("Wrong Param");
		}
		return "EMP record Updated";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String delEmp() {
		return "Emp Deleted: Sukhwinder";
	}

	@ExceptionHandler
	void handleIllegalArgumentException(Exception e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}

}
