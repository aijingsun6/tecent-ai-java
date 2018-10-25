package org.alking.tecent.ai.impl;

public abstract class BaseClient {

    private final String appId;

    private final String appKey;

    public String getAppId() {
        return appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public BaseClient(String appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
    }

    protected abstract String reqURL();
}
