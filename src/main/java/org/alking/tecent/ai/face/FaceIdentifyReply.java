package org.alking.tecent.ai.face;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FaceIdentifyReply extends BaseReply<FaceIdentifyReply.Data> {

    public static class Data {

        @SerializedName("group_size")
        private Integer groupSize;
        @SerializedName("time_ms")
        private Integer timeMs;
        @SerializedName("candidates")
        private List<FaceCandidate> candidates;

        public Integer getGroupSize() {
            return groupSize;
        }

        public void setGroupSize(Integer groupSize) {
            this.groupSize = groupSize;
        }

        public Integer getTimeMs() {
            return timeMs;
        }

        public void setTimeMs(Integer timeMs) {
            this.timeMs = timeMs;
        }

        public List<FaceCandidate> getCandidates() {
            return candidates;
        }

        public void setCandidates(List<FaceCandidate> candidates) {
            this.candidates = candidates;
        }

        public Data() {
        }
    }

    public FaceIdentifyReply() {
    }
}
