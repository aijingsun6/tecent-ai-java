package org.alking.tecent.ai.face.identify;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FaceIdsReply extends BaseReply<FaceIdsReply.Data> {

    public static class Data {

        @SerializedName("face_ids")
        private List<String> ids;

        public List<String> getIds() {
            return ids;
        }

        public void setIds(List<String> ids) {
            this.ids = ids;
        }

        public Data() {
        }
    }

    public FaceIdsReply() {
    }
}
