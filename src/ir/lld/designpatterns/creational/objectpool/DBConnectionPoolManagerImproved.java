package ir.lld.designpatterns.creational.objectpool;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManagerImproved {

     private List<DBConnection> freeConnections = new ArrayList<>();
    private List<DBConnection> usedConnections = new ArrayList<>();
    static int INITIAL_POOL_SIZE = 3;
    static int MAX_POOL_SIZE = 6;

    public static DBConnectionPoolManagerImproved dbConnectionPoolManagerImproved = null;

    private DBConnectionPoolManagerImproved() {
        for(int i = 0; i< INITIAL_POOL_SIZE; i++) {
            DBConnection connection = new DBConnection();
            freeConnections.add(connection);
        }

    }

    public DBConnectionPoolManagerImproved getInstance(){
        if(dbConnectionPoolManagerImproved != null){
            synchronized(DBConnectionPoolManagerImproved.class){
                if(dbConnectionPoolManagerImproved == null){
                    return dbConnectionPoolManagerImproved = new DBConnectionPoolManagerImproved();
                }
            }
        }
        return dbConnectionPoolManagerImproved;
    }

    public synchronized DBConnection getConnection(){

        if(freeConnections.isEmpty() && usedConnections.size() < MAX_POOL_SIZE){
            freeConnections.add(new DBConnection());
            System.out.println("creating new connection and putting in pool, free pool size: " + freeConnections.size());

        } else if(freeConnections.isEmpty() && usedConnections.size() >= MAX_POOL_SIZE){
            System.out.println("cannot create new connection as max limit is reached");
            return null;
        }

        DBConnection connection = freeConnections.remove(freeConnections.size()-1);
        usedConnections.add(connection);
        System.out.println("Adding db connection into used poll size: " + usedConnections.size());

        return connection;
    }

    public synchronized void releaseConnection(DBConnection connection){
        if(connection != null) {
            usedConnections.remove(connection);
            System.out.println("removing db connection from used poll size: " + usedConnections.size());
            freeConnections.add(connection);
            System.out.println("Adding db connection into free poll size: " + freeConnections.size());
        }
    }
}
