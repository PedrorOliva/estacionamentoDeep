package org.example.service;

import java.util.Scanner;

public class MenuService {
  Scanner inputUser = new Scanner(System.in);
  InputService input = new InputService();
  boolean menu = true;

  public void userInteraction() {
    do {
      userMenu();
      int option = inputUser.nextInt();
      switch (option) {
        case 1:
          input.newCar();
          break;
        case 2:
          input.newCarEntry();
          break;
        case 3:
          input.showAllCarsOnParking();
          break;
        case 4:
          input.updateLenghtOfstay();
          break;
        case 5:
          input.findCar();
          break;
        case 6:
          input.showCarRegistration();
          break;
        case 7:
          input.disableCar();
          break;
        case 8:
          input.exitRegister();
          break;
        case 9:
          menu = false;
          System.out.println("Encerrando aplicação....");
          break;
        default:
          System.out.println("Opção inválida!!");
      }
    } while (menu);
  }

  public static void userMenu() {
    System.out.println("Qual operação deseja realizar? " +
        "\n1 - Registrar carro " +
        "\n2 - Registrar carro no estacionamento " +
        "\n3 - Mostrar todos os carros estacionados " +
        "\n4 - Atualizar permanência " +
        "\n5 - Encontrar um carro " +
        "\n6 - Registro de carros " +
        "\n7 - Registrar saida " +
        "\n8 - Registros de saídas " +
        "\n9 - Encerrar programa");
  }
}
