package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.domain.Resource;

public interface OCRClient {

    GeneOCRReply geneocr(Resource resource);
}
