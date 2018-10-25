package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.domain.Resource;

import java.io.IOException;

public interface OCRClient {
    
    int ID_CARD_TYPE_FRONT = 0;

    int ID_CARD_TYPE_BACK = 1;

    OCRItemListReply general(final Resource resource) throws IOException;

    OCRIDCardReply idCard(final Resource resource, int type) throws IOException;

    OCRItemListReply vehicleLicense(final Resource resource) throws IOException;

    OCRItemListReply driveLicense(final Resource resource)throws IOException;

    OCRItemListReply biz(final Resource resource) throws IOException;

    OCRItemListReply bankCard(final Resource resource) throws IOException;

    OCRItemListReply handWrite(final Resource resource) throws IOException;

    OCRItemListReply carPlate(final Resource resource) throws IOException;

    OCRItemListReply businessCard(final Resource resource) throws IOException;

}
