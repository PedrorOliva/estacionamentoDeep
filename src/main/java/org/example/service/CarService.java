package org.example.service;

import org.example.connection.ConnectionDb;
import org.example.model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarService {
  public void registerCar(Car car) {
    String sql = "INSERT INTO tb_carro(nomedono, marcacarro, placa, estado, usuario)" +
        "VALUES ('" + car.getOwnerName() + "', '" + car.getCarBrand() + "', '" + car.getLicensePlate() +
        "', true, 'Pedro')";
    try {
      Statement statement = ConnectionDb.getConnection().createStatement();
      statement.executeUpdate(sql);
      System.out.println("Carro registrado!!\n");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void seeCars() {
    String sql = "SELECT * FROM tb_carro ORDER BY id";
    try {
      Statement statement = ConnectionDb.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println("ID: " + rs.getInt("id") +
            "\tDono: " + rs.getString("nomedono") +
            "\tMarca: " + rs.getString("marcacarro") +
            "\tPlaca: " + rs.getString("placa") +
            "\tStatus: " + rs.getBoolean("estado"));
      }
      System.out.println();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void findCarByID(Integer id) {
    String sql = "SELECT * FROM tb_carro WHERE id = " + id + " AND estado = true";
    try {
      Statement statement = ConnectionDb.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println("ID: " + rs.getInt("id") +
            "\nDono: " + rs.getString("nomedono") +
            "\nMarca: " + rs.getString("marcacarro") +
            "\nPlaca: " + rs.getString("placa") +
            "\nStatus: " + rs.getBoolean("estado"));
        System.out.println();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void disableCar(Integer id) {
    String sql = "UPDATE tb_carro SET estado = false WHERE id = " + id;
    try {
      Statement statement = ConnectionDb.getConnection().createStatement();
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
