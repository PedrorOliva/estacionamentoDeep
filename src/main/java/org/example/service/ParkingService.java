package org.example.service;

import org.example.connection.ConnectionDb;
import org.example.model.Parking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ParkingService {
  String dateTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
  public void carEntrance(Parking parking) {

    String sql = "INSERT INTO tb_estacionamento (carroid, entrada, valorpago, permanencia)" +
        "VALUES ('" + parking.getCar_id() + "', '" +  dateTime +
        "', '" + parking.getAmountPaid() + "', '" + parking.getPermanence() +
        "')";
    try {
      Statement statement = ConnectionDb.getConnection().createStatement();
      statement.executeUpdate(sql);
      System.out.println("Estacionamento registrado!!\n");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void seeCarsInParking() {
    String sql = "SELECT tb_carro.id, tb_carro.marcacarro, tb_carro.nomedono, tb_estacionamento.carroid, " +
        "tb_estacionamento.valorpago, tb_estacionamento.permanencia " +
        "FROM tb_carro " +
        "INNER JOIN tb_estacionamento ON tb_estacionamento.carroid = tb_carro.id AND estado = true";
    try {
      Statement statement = ConnectionDb.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println("Marca: " + rs.getString("marcacarro") +
            "\tDono: " + rs.getString("nomedono") +
            "\tPermanência: " + rs.getString("permanencia") +
            "\tValor pago: " + rs.getString("valorpago"));
      }
      System.out.println();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void updateStayTime(Integer id) {
    String sql =
        "UPDATE tb_estacionamento SET valorpago = valorpago + 2.00, permanencia = permanencia + 0.15" +
            " WHERE carroid = " + id;
    try {
      Statement statement = ConnectionDb.getConnection().createStatement();
      statement.executeUpdate(sql);
      System.out.println("Adicional de 15 minutos!!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void carDeparture(Integer id) {
    String sql =
        "UPDATE tb_estacionamento SET saida = '" + dateTime + "' WHERE id = " + id;
    String sql2 = "UPDATE tb_carro SET estado = false WHERE id = " + id;
    try {
      Statement statement = ConnectionDb.getConnection().createStatement();
      statement.executeUpdate(sql);
      statement.executeUpdate(sql2);
      System.out.println("Carro saiu!!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void seeRegisterAllExit() {
    String sql = "SELECT tb_carro.id, tb_carro.marcacarro, tb_carro.nomedono, tb_estacionamento.carroid, " +
        "tb_estacionamento.entrada, tb_estacionamento.saida, tb_estacionamento.valorpago, tb_estacionamento.permanencia " +
        " FROM tb_carro " +
        " INNER JOIN tb_estacionamento ON tb_estacionamento.carroid = tb_carro.id";
    try {
      Statement statement = ConnectionDb.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println("Marca: " + rs.getString("marcacarro") +
            "\nNome do dono: " + rs.getString("nomedono") +
            "\nEntrada: " + rs.getString("entrada") +
            "\nSaída: " + rs.getString("saida") +
            "\nValor pago: " + rs.getString("valorpago") +
            "\nPermanência: " + rs.getString("permanencia"));
        System.out.println();
      }
      System.out.println();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
