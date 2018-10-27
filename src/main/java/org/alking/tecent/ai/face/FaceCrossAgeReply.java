package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

public class FaceCrossAgeReply extends BaseReply<FaceCrossAgeReply.Data> {

    public static class Data {

        @SerializedName("source_face")
        private FaceRect source;

        @SerializedName("target_face")
        private FaceRect target;

        @SerializedName("score")
        private Double score;

        @SerializedName("fail_flag")
        private int failFlag;

        public FaceRect getSource() {
            return source;
        }

        public void setSource(FaceRect source) {
            this.source = source;
        }

        public FaceRect getTarget() {
            return target;
        }

        public void setTarget(FaceRect target) {
            this.target = target;
        }

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public int getFailFlag() {
            return failFlag;
        }

        public void setFailFlag(int failFlag) {
            this.failFlag = failFlag;
        }

        public Data() {
        }
    }
}
