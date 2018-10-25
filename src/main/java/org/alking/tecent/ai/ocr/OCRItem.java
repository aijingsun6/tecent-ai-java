package org.alking.tecent.ai.ocr;

import com.google.gson.annotations.SerializedName;

public class OCRItem {

    @SerializedName("item")
    private String item;

    @SerializedName("itemstring")
    private String itemString;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemString() {
        return itemString;
    }

    public void setItemString(String itemString) {
        this.itemString = itemString;
    }

    public OCRItem() {
    }
}
