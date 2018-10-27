package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FaceMultiReply extends BaseReply<FaceMultiReply.Data> {

    public static class Data {

        @SerializedName("face_list")
        private List<FaceRect> faces;

        public List<FaceRect> getFaces() {
            return faces;
        }

        public void setFaces(List<FaceRect> faces) {
            this.faces = faces;
        }

        public Data() {
        }
    }
}
