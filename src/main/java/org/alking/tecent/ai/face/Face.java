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

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExpression() {
        return expression;
    }

    public void setExpression(Integer expression) {
        this.expression = expression;
    }

    public Integer getBeauty() {
        return beauty;
    }

    public void setBeauty(Integer beauty) {
        this.beauty = beauty;
    }

    public Integer getGlass() {
        return glass;
    }

    public void setGlass(Integer glass) {
        this.glass = glass;
    }

    public Integer getPitch() {
        return pitch;
    }

    public void setPitch(Integer pitch) {
        this.pitch = pitch;
    }

    public Integer getYaw() {
        return yaw;
    }

    public void setYaw(Integer yaw) {
        this.yaw = yaw;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public FaceShape getFaceShape() {
        return faceShape;
    }

    public void setFaceShape(FaceShape faceShape) {
        this.faceShape = faceShape;
    }

    public Face() {
    }
}
