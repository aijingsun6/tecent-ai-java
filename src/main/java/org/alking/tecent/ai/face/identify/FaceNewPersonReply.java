package org.alking.tecent.ai.face.identify;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FaceNewPersonReply extends BaseReply<FaceNewPersonReply.Data> {

    public static class Data {

        @SerializedName("suc_group")
        private Integer successGroups;

        @SerializedName("suc_face")
        private Integer successFaces;

        @SerializedName("person_id")
        private String personId;

        @SerializedName(" face_id")
        private String faceId;

        @SerializedName("group_ids")
        private List<String> groups;

        public Integer getSuccessGroups() {
            return successGroups;
        }

        public void setSuccessGroups(Integer successGroups) {
            this.successGroups = successGroups;
        }

        public Integer getSuccessFaces() {
            return successFaces;
        }

        public void setSuccessFaces(Integer successFaces) {
            this.successFaces = successFaces;
        }

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

        public List<String> getGroups() {
            return groups;
        }

        public void setGroups(List<String> groups) {
            this.groups = groups;
        }

        public Data() {
        }
    }

    public FaceNewPersonReply() {
    }
}
