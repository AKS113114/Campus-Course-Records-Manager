package edu.ccrm.config;

public class AppConfig {
    private static AppConfig instance;
    private String backupDir = "backups";

    private AppConfig(){}

    public static synchronized AppConfig getInstance(){
        if(instance==null) instance = new AppConfig();
        return instance;
    }

    public String getBackupDir(){ return backupDir; }
    public void setBackupDir(String d){ this.backupDir = d; }
}
