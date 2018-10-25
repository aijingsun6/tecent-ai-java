package org.alking.tecent.ai.ocr;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

public class OCRIDCardReply extends BaseReply<OCRIDCardReply.Data> {

    public static class Data {

        private String name;

        private String sex;

        private String nation;

        private String birth;

        private String address;

        private String id;

        @SerializedName("frontimage")
        private String frontImg;

        private String authority;

        @SerializedName("valid_date")
        private String validDate;

        @SerializedName("backimage")
        private String backImg;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFrontImg() {
            return frontImg;
        }

        public void setFrontImg(String frontImg) {
            this.frontImg = frontImg;
        }

        public String getAuthority() {
            return authority;
        }

        public void setAuthority(String authority) {
            this.authority = authority;
        }

        public String getValidDate() {
            return validDate;
        }

        public void setValidDate(String validDate) {
            this.validDate = validDate;
        }

        public String getBackImg() {
            return backImg;
        }

        public void setBackImg(String backImg) {
            this.backImg = backImg;
        }

        public Data() {
        }
    }

    public OCRIDCardReply() {
        super();
    }
}
