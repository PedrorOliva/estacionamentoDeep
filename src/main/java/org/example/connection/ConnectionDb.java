package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
  public static Connection getConnection() {
//    try {
//      return DriverManager.getConnection("jdbc:postgresql://localhost:5432/parkingdeepdevelopment",
//          "postgres", "07092417");
//    } catch (SQLException e) {
//      e.printStackTrace();
//      return null;
//    }

    try {
      return DriverManager.getConnection("jdbc:postgresql://estacionamento-aws.cek2nmi2tmwz.sa-east-1.rds" +
              ".amazonaws.com/estacionamentodeep",
          "postgres", "root1234");
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
