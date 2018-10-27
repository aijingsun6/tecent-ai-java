package org.alking.tecent.ai.face.identify;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FacePersonInfoReply extends BaseReply<FacePersonInfoReply.Data> {

    public static class Data {

        @SerializedName("person_id")
        private String personId;

        @SerializedName("person_name")
        private String personName;

        @SerializedName("tag")
        private String tag;

        @SerializedName("face_ids")
        private List<String> faceIds;

        @SerializedName("group_ids")
        private List<String> groupIds;

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public List<String> getFaceIds() {
            return faceIds;
        }

        public void setFaceIds(List<String> faceIds) {
            this.faceIds = faceIds;
        }

        public List<String> getGroupIds() {
            return groupIds;
        }

        public void setGroupIds(List<String> groupIds) {
            this.groupIds = groupIds;
        }

        public Data() {
        }
    }

    public FacePersonInfoReply() {
    }
}
