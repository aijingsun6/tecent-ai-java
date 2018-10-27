package org.alking.tecent.ai.face.identify;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;
import org.alking.tecent.ai.face.Face;

public class FaceInfoReply extends BaseReply<FaceInfoReply.Data> {

    public static class Data {

        @SerializedName("face_info")
        private Face faceInfo;

        public Face getFaceInfo() {
            return faceInfo;
        }

        public void setFaceInfo(Face faceInfo) {
            this.faceInfo = faceInfo;
        }

        public Data() {
        }
    }

    public FaceInfoReply() {
    }
}
