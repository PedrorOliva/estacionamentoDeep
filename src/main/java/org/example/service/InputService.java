package org.example.service;

import org.example.model.Car;
import org.example.model.Parking;

import java.util.Date;
import java.util.Scanner;

public class InputService {
  Scanner inputUser = new Scanner(System.in);
  Car newCar = new Car();
  CarService car = new CarService();
  Parking newEntry = new Parking();
  ParkingService parking = new ParkingService();

  public void newCar() {
    System.out.println("--- Registrando Carro ---\n");

    System.out.println("Dono do carro: ");
    String ownerCar = inputUser.next();
    newCar.setOwnerName(ownerCar);

    System.out.println("Marca ou modelo do carro: ");
    String carBrand = inputUser.next();
    newCar.setCarBrand(carBrand);

    System.out.println("Placa do carro: ");
    String licensePlate = inputUser.next();
    newCar.setLicensePlate(licensePlate);
    car.registerCar(newCar);
  }

  public void newCarEntry() {
    System.out.println("--- Registrando carro na vaga ---\n");
    System.out.println("Valores: \nAté 1h - 10 reais \nMeio periodo(12h) - 90 reais");

    System.out.println("ID do carro: ");
    int id = inputUser.nextInt();
    newEntry.setCar_id(id);
    newEntry.setEntry(new Date());
    newEntry.setDeparture(null);

    System.out.println("Valor a pagar: ");
    Double amountToPay = inputUser.nextDouble();
    newEntry.setAmountPaid(amountToPay);

    System.out.println("Tempo de permanência: ");
    Double lenghtStay = inputUser.nextDouble();
    newEntry.setPermanence(lenghtStay);
    parking.carEntrance(newEntry);
  }

  public void showAllCarsOnParking() {
    System.out.println("--- Todos os carros estacionados ---\n");
    parking.seeCarsInParking();
  }

  public void updateLenghtOfstay() {
    System.out.println("--- Adicional de tempo ---\n");
    System.out.println("Informe o ID do carro: ");
    int id = inputUser.nextInt();
    parking.updateStayTime(id);
  }

  public void showCarRegistration() {
    System.out.println("--- Todos os carros registrados ---\n");
    car.seeCars();
  }

  public void findCar() {
    System.out.println("--- Encontre um carro ---\n");
    System.out.println("Informe o ID do carro: ");
    int id = inputUser.nextInt();
    car.findCarByID(id);
  }

  public void disableCar() {
    System.out.println("--- Baixa no carro ---\n");
    System.out.println("informe o ID do carro: ");
    int id = inputUser.nextInt();
    car.disableCar(id);
    parking.carDeparture(id);
  }

  public void exitRegister(){
    System.out.println("--- Registro de saídas ---\n");
    parking.seeRegisterAllExit();
  }
}
