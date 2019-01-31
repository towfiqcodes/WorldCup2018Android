package com.aiub.worldcup2018androidsix.ModelClasses;

public class NotificationItem {

    private String flagUrl;
    private String name;
    private boolean isNotified;

    //press ALT+INSERT

    public NotificationItem(String flagUrl, String name, boolean isNotified) {
        this.flagUrl = flagUrl;
        this.name = name;
        this.isNotified = isNotified;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNotified() {
        return isNotified;
    }

    public void setNotified(boolean notified) {
        isNotified = notified;
    }
}
