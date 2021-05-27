package com.tomorrow.plugin.bean;

/**
 * @author yuteng
2021/5/23 15:44
 */
public class JiaguExtention {


    private String jiaGuPluginPath;  // '/Users/we/Documents/360jiagubao_mac/jiagu/' //  加固保安装的路劲

    private String storeFilePath;  // file("../store.jks").absolutePath              // 签名文件位置

    private String storePassword;   //'123456'             //  密码

    private String keyAlias;   // = 'android'          // 别名

    private String keyPassword;  // '123456'

    private String jiaGuUserName;  //        //  360加固保用户名

    private String jiaGuPwd;   //

    public String getJiaGuPluginPath() {
        return jiaGuPluginPath;
    }

    public void setJiaGuPluginPath(String jiaGuPluginPath) {
        this.jiaGuPluginPath = jiaGuPluginPath;
    }

    public String getStoreFilePath() {
        return storeFilePath;
    }

    public void setStoreFilePath(String storeFilePath) {
        this.storeFilePath = storeFilePath;
    }

    public String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public String getJiaGuUserName() {
        return jiaGuUserName;
    }

    public void setJiaGuUserName(String jiaGuUserName) {
        this.jiaGuUserName = jiaGuUserName;
    }

    public String getJiaGuPwd() {
        return jiaGuPwd;
    }

    public void setJiaGuPwd(String jiaGuPwd) {
        this.jiaGuPwd = jiaGuPwd;
    }

    @Override
    public String toString() {
        return "JiaGuExt{" +
                ", jiaGuPluginPath='" + jiaGuPluginPath + '\'' +
                ", storeFilePath='" + storeFilePath + '\'' +
                ", storePassword='" + storePassword + '\'' +
                ", keyAlias='" + keyAlias + '\'' +
                ", keyPassword='" + keyPassword + '\'' +
                ", jiaGuUserName='" + jiaGuUserName + '\'' +
                ", jiaGuPwd='" + jiaGuPwd + '\'' +
                '}';
    }
}
