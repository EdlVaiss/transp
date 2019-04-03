package com.senlainc.miliuta.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Tuple;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.senlainc.miliuta.controller.exceptions.NoSuchItemException;
import com.senlainc.miliuta.dao.*;
import com.senlainc.miliuta.dto.*;

import com.senlainc.miliuta.model.*;
import com.senlainc.miliuta.services.AbstractService;
import com.senlainc.miliuta.services.CarService;
import com.senlainc.miliuta.services.DriverService;
import com.senlainc.miliuta.services.api.ICarService;
import com.senlainc.miliuta.services.api.IDriverService;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("control-servlet.xml");
		
		CredentialsController credsController = (CredentialsController) context.getBean("credentialsController");
		DriverExpenseTypeController detController = (DriverExpenseTypeController) context
				.getBean("driverExpenseTypeController");
		CarExpenseTypeController cetController = (CarExpenseTypeController) context.getBean("carExpenseTypeController");

		CarController carController = (CarController) context.getBean("carController");
		DriverController driverController = (DriverController) context.getBean("driverController");

		CarDAO carDAO = (CarDAO) context.getBean("carDAO");
		DriverDAO driverDAO = (DriverDAO) context.getBean("driverDAO");

		ICarService<CarDTO> carService = (ICarService<CarDTO>) context.getBean("carService");

		IDriverService<DriverDTO> driverService = (IDriverService<DriverDTO>) context.getBean("driverService");

		CarExpenseController carExpenseController = (CarExpenseController) context.getBean("carExpenseController");
		CarExpenseDAO cexpDAO = (CarExpenseDAO) context.getBean("carExpenseDAO");

		/*
		try {
			carController.getCar(1);
		} catch (NoSuchItemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			driverController.getDriver(4);
		} catch (NoSuchItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		CarExpenseDTO c=new CarExpenseDTO();
			System.out.println( carExpenseController.deleteCarExpense(10));
	
		
		/*ReportPrefs rp = new ReportPrefs();
		List<String> list=new ArrayList<>();
				list.add("Driver");
				list.add("Car");
		rp.setEntities(list);
		System.out.println(rp.getEntities());*/
		
		/*List<Object[]> list = repDAO.getData();
		for (Object[] tuple : list) {
			System.out.println(String.format("car: %d, driver: %d", ( ((Car)tuple[0]).getId(),
					( tuple.get(1, Driver.class)).getId()));
			
			System.out.println(String.format("%s,  %d", tuple.get(0), tuple.get(1)));
		}*/
		
		/*
		List<Object[]> list1 = carExpenseController.getAll();
		for (Object[] objects : list1) {
			System.out.println(String.format("carExpID:%d, car: %s, expenseType: %s", objects.getId(), 
					objects.getCar().getModel(),objects.getExpenseType().getExpenseType()));
		}*/
		
		// CarExpenseTypeDTO cetDTO=new CarExpenseTypeDTO(null, "type2");
		// cetController.saveCarExpenseType(cetDTO);

		/*
		 * List<CarExpenseTypeDTO> list = cetController.getAll(); for (CarExpenseTypeDTO
		 * carExpenseTypeDTO : list) {
		 * System.out.println(carExpenseTypeDTO.getExpenseType()); }
		 */
		// carController.deleteCar(3);
		/*
		 * Car car1=carDAO.getById(5); Set<Car> cars=new HashSet<>(); cars.add(car1);
		 * 
		 * Driver driver1=driverDAO.getById(3); driver1.setCars(cars);
		 * driverService.save(driver1);
		 */
		// driverService.deleteById(1);

		// Set<Driver> drivers = new HashSet<>();
		// drivers.add(driver1);

		// car1.setDrivers(drivers);

		// carService.save(car1);
		// DriverDTO driverDTO = new DriverDTO(5, "Sam", "+37525689477");

		// driverController.saveDriver(driverDTO);
		// drivers.add(driverDTO.toModel());
		// CredentialsDTO credsDTO = new CredentialsDTO("edlVaiss2", "qwerty", false,
		// "Sergey", "programer");
		// credsController.saveCredentials(credsDTO);
		/*
		 * CarDTO carDTO = new CarDTO(3, "1234", "renault", "megane"); CarExpenseTypeDTO
		 * cexpTypeDTO=new CarExpenseTypeDTO(2, "gasoline"); CarExpenseDTO cexpDTO=new
		 * CarExpenseDTO(null, 200, LocalDate.now(), 20, "zapravka");
		 * cexpDTO.setCar(carDTO.toModel());
		 * cexpDTO.setExpenseType(cexpTypeDTO.toModel());
		 * 
		 * carExpenseController.saveCarExpense(cexpDTO);
		 */
		// CarExpenseTypeDTO cexpTypeDTO=new CarExpenseTypeDTO(null, "gasoline");
		// cetController.saveCarExpenseType(cexpTypeDTO);
		// System.out.println(carExpenseController.getCarExpense(1));

		/*
		 * Set<Car> cars=new HashSet<>(); cars.add(carDTO.toModel());
		 * driverDTO.setCars(cars);
		 */

		// driverController.updateDriver(driverDTO);
		// driverController.deleteDriver(3);
		// carController.deleteCar(5);
		// carDTO.setDrivers(drivers);
		// carController.updateCar(carDTO);

		/*
		 * CarExpenseTypeDTO cetDTO = new CarExpenseTypeDTO();
		 * cetDTO.setExpenseType("brakes repair");
		 * cetController.saveCarExpenseType(cetDTO);
		 */

		/*
		 * User user1 = new User(); user1.setName("Rob"); user1.setPosition("Zomb");
		 * 
		 * //UserDTO user1DTO = userController.getUser(6);
		 * 
		 * Credentials creds1 = new Credentials(); creds1.setIsAdmin(true);
		 * creds1.setLogin("login6"); creds1.setPassword("qwertyu6");
		 * //creds1.setUser(user1DTO.toModel());
		 * 
		 * //CredentialsDTO credsDTO = (new CredentialsDTO(creds1));
		 * //credsDTO.setUser(user1DTO.toModel());
		 * 
		 * //CredentialsDTO credsDTO = credsController.getCredentials(7);
		 * //credsController.deleteCredentials(6); Set<Credentials> credsSet = new
		 * HashSet<>(); credsSet.add(creds1);
		 * 
		 * UserDTO user1DTO = new UserDTO(user1); user1DTO.setCredentials(credsSet);
		 * 
		 * //credsController.saveCredentials(credsDTO);
		 * userController.saveUser(user1DTO);
		 */
			 context.close();
	}

}
