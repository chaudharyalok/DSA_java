package ir.lld.designpatterns.creational.objectpool;

public class Connection {

    private String connectionUrl;
    private String userName;
    private String password;

    public Connection(String connectionUrl, String userName, String password) {
        this.connectionUrl = connectionUrl;
        this.userName = userName;
        this.password = password;
    }
}
