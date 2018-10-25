package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.domain.Resource;
import org.alking.tecent.ai.impl.BaseClient;
import org.alking.tecent.ai.util.HttpUtil;
import org.alking.tecent.ai.util.JsonUtil;

import java.io.IOException;
import java.util.TreeMap;

public class GeneOCRClient extends BaseClient implements OCRClient {

    public GeneOCRClient(String appId, String appKey) {
        super(appId, appKey);
    }

    @Override
    protected String reqURL() {
        return "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";
    }
    @Override
    public GeneOCRReply geneocr(Resource resource) throws IOException {
        String base64 = this.parseSourceData(resource);
        final TreeMap<String,String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        this.calcSign(map);
        String json = HttpUtil.doPostFormString(reqURL(),map);
        return JsonUtil.fromJson(json,GeneOCRReply.class);
    }
}
