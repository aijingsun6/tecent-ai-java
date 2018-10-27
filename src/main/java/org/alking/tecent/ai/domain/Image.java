package org.alking.tecent.ai.domain;

public class Image {

    public static final int RES_TYPE_LOCAL = 1;

    public static final int RES_TYPE_HTTP = 2;

    public static final int RES_TYPE_BASE64 = 3;

    private final int type;

    private final String uri;

    public int getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public Image(int type, String uri) {
        this.type = type;
        this.uri = uri;
    }

    @Override
    public String toString() {
        return String.format("(%d,%s)",type,uri);
    }

}
