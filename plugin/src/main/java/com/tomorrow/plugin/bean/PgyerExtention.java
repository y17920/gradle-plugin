package com.tomorrow.plugin.bean;

/**
 * @author yuteng
 * @Description:
 * @date 2021/5/23 15:44
 * @Since version 2021/5/23
 */
public class PgyerExtention {


    /**
     *  (必填)API Key
     */
   private String pgyerApiKey;
    /**
     * (选填)应用安装方式，值为(1,2,3，4)。1：公开，2：密码安装，3：邀请安装，4：回答问题安装。默认为1公开
     */
    private  int buildInstallType = 1;
    /**
     * (选填) 设置App安装密码，如果不想设置密码，请传空字符串，或不传。
     */
    private String buildPassword = "";
    /**
     * (选填) 版本更新描述，请传空字符串，或不传。
     */
    private  String buildUpdateDescription = "";
    /**
     * (选填) 应用名称
     */
    private  String buildName = "";
    /**
     * (选填)如果安装方式为回答问题安装，填写安装问题
     */
    private  String buildInstallQuestoin = "";
    /**
     * (选填)如果安装方式为回答问题安装，填写安装问题的答案。
     */
    private String buildInstallAnswer = "";
    /**
     * (选填)是否设置安装有效期，值为：1 设置有效时间， 2 长期有效，如果不填写不修改上一次的设置
     */
    private  int buildInstallDate = 2;
    /**
     * (选填)安装有效期开始时间，字符串型，如：2018-01-01
     */
    private String buildInstallStartDate = "";
    /**
     * (选填)安装有效期结束时间，字符串型，如：2018-12-31
     */
    private  String buildInstallEndDate = "";
    /**
     *     buildChannelShortcut	String	(选填)所需更新的指定渠道的下载短链接，只可指定一个渠道，字符串型，如：abcd
     */
    private  String buildChannelShortcut = "";

    public String getPgyerApiKey() {
        return pgyerApiKey;
    }

    public void setPgyerApiKey(String pgyerApiKey) {
        this.pgyerApiKey = pgyerApiKey;
    }

    public int getBuildInstallType() {
        return buildInstallType;
    }

    public void setBuildInstallType(int buildInstallType) {
        this.buildInstallType = buildInstallType;
    }

    public String getBuildPassword() {
        return buildPassword;
    }

    public void setBuildPassword(String buildPassword) {
        this.buildPassword = buildPassword;
    }

    public String getBuildUpdateDescription() {
        return buildUpdateDescription;
    }

    public void setBuildUpdateDescription(String buildUpdateDescription) {
        this.buildUpdateDescription = buildUpdateDescription;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildInstallQuestoin() {
        return buildInstallQuestoin;
    }

    public void setBuildInstallQuestoin(String buildInstallQuestoin) {
        this.buildInstallQuestoin = buildInstallQuestoin;
    }

    public String getBuildInstallAnswer() {
        return buildInstallAnswer;
    }

    public void setBuildInstallAnswer(String buildInstallAnswer) {
        this.buildInstallAnswer = buildInstallAnswer;
    }

    public int getBuildInstallDate() {
        return buildInstallDate;
    }

    public void setBuildInstallDate(int buildInstallDate) {
        this.buildInstallDate = buildInstallDate;
    }

    public String getBuildInstallStartDate() {
        return buildInstallStartDate;
    }

    public void setBuildInstallStartDate(String buildInstallStartDate) {
        this.buildInstallStartDate = buildInstallStartDate;
    }

    public String getBuildInstallEndDate() {
        return buildInstallEndDate;
    }

    public void setBuildInstallEndDate(String buildInstallEndDate) {
        this.buildInstallEndDate = buildInstallEndDate;
    }

    public String getBuildChannelShortcut() {
        return buildChannelShortcut;
    }

    public void setBuildChannelShortcut(String buildChannelShortcut) {
        this.buildChannelShortcut = buildChannelShortcut;
    }

    @Override
    public String toString() {
        return "PgyerExtention{" +
                "pgyerApiKey='" + pgyerApiKey + '\'' +
                ", buildInstallType=" + buildInstallType +
                ", buildPassword='" + buildPassword + '\'' +
                ", buildUpdateDescription='" + buildUpdateDescription + '\'' +
                ", buildName='" + buildName + '\'' +
                ", buildInstallQuestoin='" + buildInstallQuestoin + '\'' +
                ", buildInstallAnswer='" + buildInstallAnswer + '\'' +
                ", buildInstallDate=" + buildInstallDate +
                ", buildInstallStartDate='" + buildInstallStartDate + '\'' +
                ", buildInstallEndDate='" + buildInstallEndDate + '\'' +
                ", buildChannelShortcut='" + buildChannelShortcut + '\'' +
                '}';
    }
}
