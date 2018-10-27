package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FaceShapeReply extends BaseReply<FaceShapeReply.Data> {

    public static class Data {

        @SerializedName("image_width")
        private Integer imageWidth;

        @SerializedName("image_height")
        private Integer imageHeight;

        @SerializedName("face_shape_list")
        private List<FaceShape> faces;

        public Integer getImageWidth() {
            return imageWidth;
        }

        public void setImageWidth(Integer imageWidth) {
            this.imageWidth = imageWidth;
        }

        public Integer getImageHeight() {
            return imageHeight;
        }

        public void setImageHeight(Integer imageHeight) {
            this.imageHeight = imageHeight;
        }

        public List<FaceShape> getFaces() {
            return faces;
        }

        public void setFaces(List<FaceShape> faces) {
            this.faces = faces;
        }

        public Data() {
        }
    }
    public FaceShapeReply() {
    }
}
