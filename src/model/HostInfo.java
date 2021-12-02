package model;

public class HostInfo {
    private String hostID;
    private String hostName;
    private boolean isSuperHost;

    public HostInfo(String email, String name, boolean superHost) {
        hostID = email;
        hostName = name;
        isSuperHost = superHost;
    }

    public String getHostID() {
        return hostID;
    }

    public String getHostName() {
        return hostName;
    }

    public boolean getSuperHost() {
        return isSuperHost;
    }
}
