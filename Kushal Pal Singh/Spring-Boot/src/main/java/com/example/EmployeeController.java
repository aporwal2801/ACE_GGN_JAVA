package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{

	@Value("${resource.location}")
	private String resourcePath;

	@RequestMapping(method = RequestMethod.GET, value = "/{employeeName}")
	public Employee getEmployee(@PathVariable String employeeName) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Employee employee = deserializeObject(employeeName);
		return employee;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public List<Employee> getEmployee() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File folder = new File(resourcePath);
		File[] files = folder.listFiles();
		List<Employee> employees = new ArrayList<>();
		for (File file : files)
		{
			employees.add(getObject(file));
		}
		return employees;
	}

	private static Employee getObject(File file)
	{
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)))
		{
			Employee updatedEmployee = (Employee) in.readObject();
			return updatedEmployee;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createEmployee(@RequestBody Employee employee) throws IOException
	{

		serializeObject(employee);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{employeeName}")
	public void deleteEmployee(@PathVariable String employeeName)
	{

		File file = new File(resourcePath + File.separator + employeeName + ".txt");
		if (file.exists())
		{
			FileUtils.deleteQuietly(file);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateEmployee(@RequestBody Employee employee) throws ClassNotFoundException, IOException
	{
		Employee updatedEmployee = deserializeObject(employee.getEmployeeName());
		updatedEmployee.setAddress(employee.getAddress());
		updatedEmployee.setAge(employee.getAge());
		serializeObject(updatedEmployee);
	}

	private Employee deserializeObject(String employeeName) throws IOException, FileNotFoundException, ClassNotFoundException
	{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(resourcePath + File.separator + employeeName + ".txt"));
		Employee updatedEmployee = (Employee) in.readObject();
		in.close();
		return updatedEmployee;
	}

	private void serializeObject(Employee employee) throws FileNotFoundException, IOException
	{
		String filePath = resourcePath + File.separator + employee.getEmployeeName() + ".txt";
		File file = new File(filePath);
		file.createNewFile();
		FileOutputStream fout = new FileOutputStream(filePath);
		ObjectOutputStream out = new ObjectOutputStream(fout);

		out.writeObject(employee);
		out.flush();
		out.close();
	}

	public String getResourcePath()
	{
		return resourcePath;
	}

	public void setResourcePath(String resourcePath)
	{
		this.resourcePath = resourcePath;
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorInfo errorResponse(Exception ex, HttpServletResponse response)
	{
		return new ErrorInfo(ex.getMessage());
	}
}
