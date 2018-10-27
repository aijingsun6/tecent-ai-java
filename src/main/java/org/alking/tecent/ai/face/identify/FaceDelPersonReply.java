package org.alking.tecent.ai.face.identify;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

public class FaceDelPersonReply extends BaseReply<FaceDelPersonReply.Data> {

    public static class Data {

        @SerializedName("deleted")
        private Integer deleted;

        @SerializedName("person_id")
        private String personId;

        public Integer getDeleted() {
            return deleted;
        }

        public void setDeleted(Integer deleted) {
            this.deleted = deleted;
        }

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public Data() {
        }
    }

    public FaceDelPersonReply() {
    }
}
