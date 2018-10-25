package org.alking.tecent.ai.domain;

public class Resource {

    public enum ResourceType {
        /**
         * 本地资源
         */
        LOCAL,

        /**
         *  HTTP资源
         */
        HTTP,

        /**
         * base64资源
         */
        BASE64,
    }

    private final ResourceType type;

    private final String uri;

    public ResourceType getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public Resource(ResourceType type, String uri) {
        this.type = type;
        this.uri = uri;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)",type,uri);
    }

}
