package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FaceDetectReply extends BaseReply<FaceDetectReply.Data> {

    public static class Data {

        @SerializedName("image_width")
        private Integer imageWidth;

        @SerializedName("image_height")
        private Integer imageHeight;

        @SerializedName("face_list")
        private List<Face> faces;

    }
}
