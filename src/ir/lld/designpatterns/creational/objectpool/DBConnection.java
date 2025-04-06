package ir.lld.designpatterns.creational.objectpool;

public class DBConnection {

    Connection mysqlConnection;

    public DBConnection() {
        this.mysqlConnection = new Connection("abc","bcd","123");
    }
}
