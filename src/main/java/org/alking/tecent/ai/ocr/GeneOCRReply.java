package org.alking.tecent.ai.ocr;

import com.google.gson.annotations.SerializedName;
import org.alking.tecent.ai.domain.BaseReply;

import java.util.List;

public class GeneOCRReply extends BaseReply<GeneOCRReply.Data> {

    public static class Data {

        @SerializedName("item_list")
        private List<Item> items;

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

        public Data() {
        }
    }

    public static class ItemCoord {

        private Integer x;

        private Integer y;

        private Integer width;

        private Integer height;

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public ItemCoord() {
        }
    }

    public static class Item {

        @SerializedName("itemstring")
        private String itemString;

        @SerializedName("itemcoord")
        private ItemCoord itemCoord;

        public String getItemString() {
            return itemString;
        }

        public void setItemString(String itemString) {
            this.itemString = itemString;
        }

        public ItemCoord getItemCoord() {
            return itemCoord;
        }

        public void setItemCoord(ItemCoord itemCoord) {
            this.itemCoord = itemCoord;
        }

        public Item() {
        }
    }
}
