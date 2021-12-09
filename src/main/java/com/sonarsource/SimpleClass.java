package com.sonarsource;

public class SimpleClass {

  public boolean authenticate(javax.servlet.http.HttpServletRequest request, java.sql.Connection connection) throws SQLException {

    Connection conn = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");

    String user = request.getParameter("user");
    String pass = request.getParameter("pass");

    String query = "SELECT * FROM users WHERE user = '" + user + "' AND pass = '" + pass + "'"; // Unsafe

    // If the special value "foo' OR 1=1 --" is passed as either the user or pass, authentication is bypassed
    // Indeed, if it is passed as a user, the query becomes:
    // SELECT * FROM users WHERE user = 'foo' OR 1=1 --' AND pass = '...'
    // As '--' is the comment till end of line syntax in SQL, this is equivalent to:
    // SELECT * FROM users WHERE user = 'foo' OR 1=1
    // which is equivalent to:
    // SELECT * FROM users WHERE 1=1
    // which is equivalent to:
    // SELECT * FROM users

    java.sql.Statement statement = connection.createStatement();
    java.sql.ResultSet resultSet = statement.executeQuery(query); // Noncompliant
    return resultSet.next();
  }

  public User getUser(Connection con, String user) throws SQLException {

    Statement stmt1 = null;
    Statement stmt2 = null;
    PreparedStatement pstmt;
    try {
      stmt1 = con.createStatement();
      ResultSet rs1 = stmt1.executeQuery("GETDATE()"); // No issue; hardcoded query

      stmt2 = con.createStatement();
      ResultSet rs2 = stmt2.executeQuery("select FNAME, LNAME, SSN " +
        "from USERS where UNAME=" + user);  // Sensitive

      pstmt = con.prepareStatement("select FNAME, LNAME, SSN " +
        "from USERS where UNAME=" + user);  // Sensitive
      ResultSet rs3 = pstmt.executeQuery();

      //...
    }

    public User getUserHibernate(org.hibernate.Session session, String data) {

      org.hibernate.Query query = session.createQuery(
        "FROM students where fname = " + data);  // Sensitive
      // ...
    }

    int foo(int a) {
      int b = 12;
      if (a == 1) {
        return b;
      }
      return b;  // Noncompliant
    }
}
