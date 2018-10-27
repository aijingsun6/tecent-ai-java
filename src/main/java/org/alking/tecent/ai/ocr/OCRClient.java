package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.domain.Image;

import java.io.IOException;

public interface OCRClient {
    
    int ID_CARD_TYPE_FRONT = 0;

    int ID_CARD_TYPE_BACK = 1;

    OCRItemListReply general(final Image image) throws IOException;

    OCRIDCardReply idCard(final Image image, int type) throws IOException;

    OCRItemListReply vehicleLicense(final Image image) throws IOException;

    OCRItemListReply driveLicense(final Image image)throws IOException;

    OCRItemListReply biz(final Image image) throws IOException;

    OCRItemListReply bankCard(final Image image) throws IOException;

    OCRItemListReply handWrite(final Image image) throws IOException;

    OCRItemListReply carPlate(final Image image) throws IOException;

    OCRItemListReply businessCard(final Image image) throws IOException;

}
