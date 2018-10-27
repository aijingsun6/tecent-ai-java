package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class MultiFaceReply extends BaseReply<MultiFaceReply.Data> {

    public static class FaceItem {

        private Double x1;

        private Double y1;

        private Double x2;

        private Double y2;

        public Double getX1() {
            return x1;
        }

        public void setX1(Double x1) {
            this.x1 = x1;
        }

        public Double getY1() {
            return y1;
        }

        public void setY1(Double y1) {
            this.y1 = y1;
        }

        public Double getX2() {
            return x2;
        }

        public void setX2(Double x2) {
            this.x2 = x2;
        }

        public Double getY2() {
            return y2;
        }

        public void setY2(Double y2) {
            this.y2 = y2;
        }

        public FaceItem() {
        }
    }

    public static class Data {

        @SerializedName("face_list")
        private List<FaceItem> faces;

        public List<FaceItem> getFaces() {
            return faces;
        }

        public void setFaces(List<FaceItem> faces) {
            this.faces = faces;
        }

        public Data() {
        }
    }
}
