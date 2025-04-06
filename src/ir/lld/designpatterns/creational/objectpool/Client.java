package ir.lld.designpatterns.creational.objectpool;

public class Client {
    public static void main(String[] args) {
        DBConnectionPoolManager manager = new DBConnectionPoolManager();

        DBConnection connection1 = manager.getConnection();
        DBConnection connection2 = manager.getConnection();
        DBConnection connection3 = manager.getConnection();
        DBConnection connection4 = manager.getConnection();
        DBConnection connection5 = manager.getConnection();
        DBConnection connection6 = manager.getConnection();

        manager.getConnection();

        manager.releaseConnection(connection6);


    }
}
