package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.domain.Resource;
import org.alking.tecent.ai.impl.BaseClient;

public class GeneOCRClient extends BaseClient implements OCRClient {

    public GeneOCRClient(String appId, String appKey) {
        super(appId, appKey);
    }

    @Override
    protected String reqURL() {
        return "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";
    }

    @Override
    public GeneOCRReply geneocr(Resource resource) {
        return null;
    }
}
