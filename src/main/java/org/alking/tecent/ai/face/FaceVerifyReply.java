package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

public class FaceVerifyReply extends BaseReply<FaceVerifyReply.Data> {

    public static class Data {

        @SerializedName("ismatch")
        private Integer isMatch;

        @SerializedName("confidence")
        private Double confidence;

        public Integer getIsMatch() {
            return isMatch;
        }

        public void setIsMatch(Integer isMatch) {
            this.isMatch = isMatch;
        }

        public Double getConfidence() {
            return confidence;
        }

        public void setConfidence(Double confidence) {
            this.confidence = confidence;
        }

        public Data() {
        }
    }

    public FaceVerifyReply() {
    }
}
