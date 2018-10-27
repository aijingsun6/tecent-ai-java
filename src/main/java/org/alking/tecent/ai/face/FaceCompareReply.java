package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

public class FaceCompareReply extends BaseReply<FaceCompareReply.Data> {

    public static class Data {

        @SerializedName("similarity")
        private Double similarity;

        @SerializedName("fail_flag")
        private Integer failFlag;

        public Double getSimilarity() {
            return similarity;
        }

        public void setSimilarity(Double similarity) {
            this.similarity = similarity;
        }

        public Integer getFailFlag() {
            return failFlag;
        }

        public void setFailFlag(Integer failFlag) {
            this.failFlag = failFlag;
        }

        public Data() {
        }
    }

    public FaceCompareReply() {
    }
}
