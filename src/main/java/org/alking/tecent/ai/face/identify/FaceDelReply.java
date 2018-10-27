package org.alking.tecent.ai.face.identify;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FaceDelReply extends BaseReply<FaceDelReply.Data> {

    public static class Data {

        @SerializedName("deleted")
        private Integer delete;

        @SerializedName("face_ids")
        private List<String> faceIds;

        public Integer getDelete() {
            return delete;
        }

        public void setDelete(Integer delete) {
            this.delete = delete;
        }

        public List<String> getFaceIds() {
            return faceIds;
        }

        public void setFaceIds(List<String> faceIds) {
            this.faceIds = faceIds;
        }

        public Data() {
        }
    }

    public FaceDelReply() {
    }
}
