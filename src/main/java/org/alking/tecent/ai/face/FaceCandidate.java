package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;

public class FaceCandidate {

    @SerializedName("person_id")
    private String personId;

    @SerializedName("face_id")
    private String faceId;

    @SerializedName("confidence")
    private Double confidence;

    @SerializedName("tag")
    private String tag;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public FaceCandidate() {
    }
}
