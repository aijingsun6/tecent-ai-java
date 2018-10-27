package org.alking.tecent.ai.face.identify;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class FaceGroupIdsReply extends BaseReply<FaceGroupIdsReply.Data> {

    public static class Data {

        @SerializedName("group_ids")
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

    public FaceGroupIdsReply() {
    }
}
