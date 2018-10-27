package org.alking.tecent.ai.face.identify;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

public class FacePersonInfoSetReply extends BaseReply<FacePersonInfoSetReply.Data> {

    public static class Data {

        @SerializedName("person_id")
        private String personId;

        public String getPersonId() {
            return personId;
        }

        public void setPersonId(String personId) {
            this.personId = personId;
        }

        public Data() {
        }
    }

    public FacePersonInfoSetReply() {
    }
}
