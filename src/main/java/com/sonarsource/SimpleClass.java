package com.sonarsource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleClass {

  public boolean authenticate(javax.servlet.http.HttpServletRequest request, java.sql.Connection connection) throws SQLException {

    Connection conn = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");

    String user = request.getParameter("user");
    String pass = request.getParameter("pass");

    String query = "SELECT * FROM users WHERE user = '" + user + "' AND pass = '" + pass + "'"; // Unsafe

    java.sql.Statement statement = connection.createStatement();
    java.sql.ResultSet resultSet = statement.executeQuery(query); // Noncompliant
    return resultSet.next();
  }


    int foo(int a) {

      java.util.regex.Pattern.compile("(a+)+").matcher(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
          "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
          "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
          "aaaaaaaaaaaaaaa!").matches(); // Sensitive

      java.util.regex.Pattern.compile("(h|h|ih(((i|a|c|c|a|i|i|j|b|a|i|b|a|a|j))+h)ahbfhba|c|i)*").matcher(
        "hchcchicihcchciiicichhcichcihcchiihichiciiiihhcchi"+
          "cchhcihchcihiihciichhccciccichcichiihcchcihhicchcciicchcccihiiihhihihihi"+
          "chicihhcciccchihhhcchichchciihiicihciihcccciciccicciiiiiiiiicihhhiiiihchccch"+
          "chhhhiiihchihcccchhhiiiiiiiicicichicihcciciihichhhhchihciiihhiccccccciciihh"+
          "ichiccchhicchicihihccichicciihcichccihhiciccccccccichhhhihihhcchchihih"+
          "iihhihihihicichihiiiihhhhihhhchhichiicihhiiiiihchccccchichci").matches(); // Sensitive


      java.util.regex.Pattern.compile("(a+)+").matcher(
        "aaaaaaaaaaaaabbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
          "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
          "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
          "aaaaaaaaaaaaaaa!").matches(); // Sensitive

      java.util.regex.Pattern.compile("(h|h|ih(((i|a|c|c|a|i|i|j|b|a|i|b|a|a|j))+h)ahbfhba|c|i)*").matcher(
        "hchcchicihcchciiicichhcichcihcchiihichiciiiihhcchi"+
          "cchhcihchcihiihciichhccciccichcichiihcchcihhicchcciicchcccihiiihhihihihi"+
          "chicihhcciccchihhhcchichzcsdgagasdfchciihiicihciihcccciciccicciiiiiiiiicihhhiiiihchccch"+
          "chhhhiiihchihcccchhhiiiiiiiicicichicihcciciihichhhhchihciiihhiccccccciciihh"+
          "ichiccchhicchicihihccichicciihcichccihhiciccccccccichhhhihihhcchchihih"+
          "iihhihihihicichihiiiihhhhihhhchhichiicihhiiiiihchccccchichci").matches(); // Sensitive
      
      int b = 12;
      if (a == 1) {
        return b;
      }
      return b;  // Noncompliant
    }
}
