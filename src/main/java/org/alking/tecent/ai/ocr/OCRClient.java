package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.domain.Resource;

import java.io.IOException;

public interface OCRClient {
    
    int ID_CARD_TYPE_FRONT = 0;

    int ID_CARD_TYPE_BACK = 1;

    OCRGeneralReply general(Resource resource) throws IOException;

    OCRIDCardReply idCard(Resource resource, int type) throws IOException;

    OCRVehicleLicenseReply vehicleLicense(Resource resource) throws IOException;

    OCRDriveLicenseReply driveLicense(Resource resource)throws IOException;

    OCRBizReply biz(Resource resource) throws IOException;

    OCRBankCardReply bankCard(Resource resource) throws IOException;

}
