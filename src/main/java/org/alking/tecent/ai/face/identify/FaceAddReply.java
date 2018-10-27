package org.alking.tecent.ai.face.identify;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FaceAddReply extends BaseReply<FaceAddReply.Data> {

    public static class Data {

        @SerializedName("added")
        private Integer added;

        @SerializedName("face_ids")
        private List<String> faceIds;

        @SerializedName("ret_codes")
        private List<Integer> retCodes;

        public Integer getAdded() {
            return added;
        }

        public void setAdded(Integer added) {
            this.added = added;
        }

        public List<String> getFaceIds() {
            return faceIds;
        }

        public void setFaceIds(List<String> faceIds) {
            this.faceIds = faceIds;
        }

        public List<Integer> getRetCodes() {
            return retCodes;
        }

        public void setRetCodes(List<Integer> retCodes) {
            this.retCodes = retCodes;
        }

        public Data() {
        }
    }

    public FaceAddReply() {
    }
}
