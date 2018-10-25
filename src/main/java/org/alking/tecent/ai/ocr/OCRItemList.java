package org.alking.tecent.ai.ocr;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OCRItemList {

    @SerializedName("item_list")
    private List<OCRItem> items;

    public List<OCRItem> getItems() {
        return items;
    }

    public void setItems(List<OCRItem> items) {
        this.items = items;
    }

    public OCRItemList() {
    }
}
