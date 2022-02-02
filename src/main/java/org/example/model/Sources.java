package org.example.model;

public class Sources {
    private String sourceName;
    private String connectionUrl;
    private String driverClass;
    private String userName;
    private String password;

    public Sources(String sourceName, String connectionUrl, String driverClass, String userName, String password) {
        this.sourceName = sourceName;
        this.connectionUrl = connectionUrl;
        this.driverClass = driverClass;
        this.userName = userName;
        this.password = password;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
