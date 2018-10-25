package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.domain.Resource;
import org.alking.tecent.ai.impl.BaseClient;
import org.alking.tecent.ai.util.HttpUtil;
import org.alking.tecent.ai.util.JsonUtil;

import java.io.IOException;
import java.util.TreeMap;

public class OCRClientImpl  extends BaseClient implements OCRClient {

    private static final String OCR_GENERIC_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";

    private static final String OCR_ID_CARD_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_idcardocr";

    private static final String OCR_DRIVE_LICENSE_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_driverlicenseocr";

    private static final String SIGN_FIELD_CARD_TYPE = "card_type";

    private static final String SIGN_FIELD_TYPE = "type";

    private static final int TYPE_VEHICLE_LICENSE = 0;

    private static final int TYPE_DRIVE_LICENSE = 1;


    public OCRClientImpl(String appId, String appKey) {
        super(appId, appKey);
    }

    @Override
    public OCRGeneralReply general(Resource resource) throws IOException {
        String base64 = this.parseSourceData(resource);
        final TreeMap<String,String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        this.calcSign(map);
        String json = HttpUtil.doPostFormString(OCR_GENERIC_URL,map);
        return JsonUtil.fromJson(json,OCRGeneralReply.class);
    }

    @Override
    public OCRIDCardReply idCard(Resource resource, int type) throws IOException {
        if(type != ID_CARD_TYPE_FRONT && type != ID_CARD_TYPE_BACK){
            throw new IllegalArgumentException("type invalid");
        }
        String base64 = this.parseSourceData(resource);
        final TreeMap<String,String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        map.put(SIGN_FIELD_CARD_TYPE,String.valueOf(type));
        this.calcSign(map);
        String json = HttpUtil.doPostFormString(OCR_ID_CARD_URL,map);
        return JsonUtil.fromJson(json,OCRIDCardReply.class);
    }

    @Override
    public OCRVehicleLicenseReply vehicleLicense(Resource resource) throws IOException {
        String base64 = this.parseSourceData(resource);
        final TreeMap<String,String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        map.put(SIGN_FIELD_TYPE,String.valueOf(TYPE_VEHICLE_LICENSE));
        this.calcSign(map);
        String json = HttpUtil.doPostFormString(OCR_DRIVE_LICENSE_URL,map);
        return JsonUtil.fromJson(json,OCRVehicleLicenseReply.class);
    }

    @Override
    public OCRDriveLicenseReply driveLicense(Resource resource) throws IOException {
        return null;
    }
}
