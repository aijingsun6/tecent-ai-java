package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;

public class Face {

    @SerializedName("face_id")
    private String faceId;

    private Integer x;

    private Integer y;

    private Integer width;

    private Integer height;

    private Integer gender;

    private Integer age;

    private Integer expression;

    private Integer beauty;

    private Integer glass;

    private Integer pitch;

    private Integer yaw;

    private Integer roll;

    @SerializedName("face_shape")
    private FaceShape faceShape;

}
