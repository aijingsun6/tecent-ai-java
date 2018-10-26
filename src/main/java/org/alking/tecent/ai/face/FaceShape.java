package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FaceShape {

    @SerializedName("face_profile")
    private List<FacePoint> profile;

    @SerializedName("left_eye")
    private List<FacePoint> leftEye;

    @SerializedName("right_eye")
    private List<FacePoint> rightEye;

    @SerializedName("left_eyebrow")
    private List<FacePoint> leftEyebrow;

    @SerializedName("right_eyebrow")
    private List<FacePoint> rightEyebrow;

    @SerializedName("mouth")
    private List<FacePoint> mouth;

    @SerializedName("nose")
    private List<FacePoint> nose;
}
