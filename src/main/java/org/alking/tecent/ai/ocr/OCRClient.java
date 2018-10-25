package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.domain.Resource;

import java.io.IOException;

public interface OCRClient {

    GeneOCRReply geneocr(Resource resource) throws IOException;
}
