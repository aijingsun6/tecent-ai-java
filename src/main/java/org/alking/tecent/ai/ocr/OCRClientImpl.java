package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.HttpClient;
import org.alking.tecent.ai.domain.Resource;
import org.alking.tecent.ai.impl.BaseClient;

import java.io.IOException;
import java.util.TreeMap;

public class OCRClientImpl extends BaseClient implements OCRClient {

    private static final String OCR_GENERIC_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";

    private static final String OCR_ID_CARD_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_idcardocr";

    private static final String OCR_DRIVE_LICENSE_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_driverlicenseocr";

    private static final String OCR_BIZ_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_bizlicenseocr";

    private static final String OCR_BANK_CARD_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_creditcardocr";

    private static final String OCR_HAND_WRITE_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_handwritingocr";

    private static final String OCR_CAR_PLATE_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_plateocr";

    private static final String OCR_BC_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_bcocr";

    private static final String SIGN_FIELD_CARD_TYPE = "card_type";

    private static final String SIGN_FIELD_TYPE = "type";

    private static final int TYPE_VEHICLE_LICENSE = 0;

    private static final int TYPE_DRIVE_LICENSE = 1;

    public OCRClientImpl(String appId, String appKey, HttpClient httpClient) {
        super(appId, appKey, httpClient);
    }

    @Override
    public OCRItemListReply general(final Resource resource) throws IOException {
        final String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        return normalReq(OCR_GENERIC_URL, map, OCRItemListReply.class);
    }

    @Override
    public OCRIDCardReply idCard(Resource resource, int type) throws IOException {
        if (type != ID_CARD_TYPE_FRONT && type != ID_CARD_TYPE_BACK) {
            throw new IllegalArgumentException("type invalid");
        }
        String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_CARD_TYPE, String.valueOf(type));
        return normalReq(OCR_ID_CARD_URL, map, OCRIDCardReply.class);
    }

    @Override
    public OCRItemListReply vehicleLicense(Resource resource) throws IOException {
        String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_TYPE, String.valueOf(TYPE_VEHICLE_LICENSE));
        return normalReq(OCR_DRIVE_LICENSE_URL, map, OCRItemListReply.class);
    }

    @Override
    public OCRItemListReply driveLicense(Resource resource) throws IOException {
        String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_TYPE, String.valueOf(TYPE_DRIVE_LICENSE));
        return normalReq(OCR_DRIVE_LICENSE_URL, map, OCRItemListReply.class);
    }

    @Override
    public OCRItemListReply biz(Resource resource) throws IOException {
        String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        return normalReq(OCR_BIZ_URL, map, OCRItemListReply.class);
    }

    @Override
    public OCRItemListReply bankCard(Resource resource) throws IOException {
        String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        return normalReq(OCR_BANK_CARD_URL, map, OCRItemListReply.class);
    }

    @Override
    public OCRItemListReply handWrite(Resource resource) throws IOException {
        final TreeMap<String, String> map = new TreeMap<>();
        if (Resource.RES_TYPE_HTTP == resource.getType()) {
            map.put(SIGN_FIELD_IMAGE_URL, resource.getUri());
        } else {
            String base64 = this.parseSourceData(resource);
            map.put(SIGN_FIELD_IMAGE, base64);
        }
        return normalReq(OCR_HAND_WRITE_URL, map, OCRItemListReply.class);
    }

    @Override
    public OCRItemListReply carPlate(Resource resource) throws IOException {
        final TreeMap<String, String> map = new TreeMap<>();
        boolean useImageUrl = false;
        if (useImageUrl) {
            if (Resource.RES_TYPE_HTTP == resource.getType()) {
                map.put(SIGN_FIELD_IMAGE_URL, resource.getUri());
            } else {
                String base64 = this.parseSourceData(resource);
                map.put(SIGN_FIELD_IMAGE, base64);
            }
        } else {
            String base64 = this.parseSourceData(resource);
            map.put(SIGN_FIELD_IMAGE, base64);
        }

//        TODO:why use image_url param return error code 16399
        return normalReq(OCR_CAR_PLATE_URL, map, OCRItemListReply.class);
    }

    @Override
    public OCRItemListReply businessCard(Resource resource) throws IOException {
        String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        return normalReq(OCR_BC_URL, map, OCRItemListReply.class);
    }
}
