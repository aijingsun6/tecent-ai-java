package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.domain.Resource;
import org.alking.tecent.ai.impl.BaseClient;
import org.alking.tecent.ai.util.HttpUtil;
import org.alking.tecent.ai.util.JsonUtil;

import java.io.IOException;
import java.util.TreeMap;

public class OCRClientImpl  extends BaseClient implements OCRClient {

    private static final String OCR_GENERIC_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";

    public OCRClientImpl(String appId, String appKey) {
        super(appId, appKey);
    }

    @Override
    public GeneOCRReply general(Resource resource) throws IOException {
        String base64 = this.parseSourceData(resource);
        final TreeMap<String,String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        this.calcSign(map);
        String json = HttpUtil.doPostFormString(OCR_GENERIC_URL,map);
        return JsonUtil.fromJson(json,GeneOCRReply.class);
    }

    @Override
    public IDCardOCRReply idCard(Resource resource) throws IOException {
        return null;
    }
}
