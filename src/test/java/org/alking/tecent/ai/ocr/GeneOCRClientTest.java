package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.BaseTest;
import org.alking.tecent.ai.domain.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GeneOCRClientTest extends BaseTest {

    @Test
    public void testHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/gene_ocr_APPLE.png";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        GeneOCRClient client = new GeneOCRClient(APP_ID,APP_KEY);
        GeneOCRReply reply = client.geneocr(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
        Assert.assertEquals(1,reply.getData().getItems().size());
        Assert.assertEquals("APPLE",reply.getData().getItems().get(0).getItemString());
    }

    @Test
    public void testBase64() throws IOException {
        String base64 = "iVBORw0KGgoAAAANSUhEUgAAAIAAAAAgCAIAAABVQOdyAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAHWSURBVGhD7ZXrkcMgDIRdVwpyPa4mzaQYnwMIMHqcBR4rzGj/HVoTdj98XnaXqRyAsRyAsRyAsRyAsRyAsRyAsRyAse4A8F6XZXltn/SnS6NhAJ/tddTPEchTRus7Gb9SmQm3cAfCHRFldYFGAVQ1nPuplD21ozx4jq4y58GV+sidy6oRgUEApZlDHAG2pXwvqydVZt5NiPfGrW0IDAI4vdpcAj45TKpSVWbBjSV5w+zKJrdrDEDsf91SNOYVEJIDwDJSmW8DYKchADHSUTtUQxP4ZQBhT+biPKIRADHRN4/cAz+FSVWByvzPD59FeqcGEA4f44hFsEO40pcqpcyjANLSpACq/ks9VBaypdxnU57K3AUAa04AsZR8doEAn5zoTWXuAlB506GnBBDjlKMLVWha0plVbsob12YEAGmwcBpVpyqzyk16wzswI4Bw8FOUjATF+WUA5uoEgPsXAjoAQX0A4serverpk4YSGgEIs2og7tyaH1MXgBgFHxcINGTE5K1UZsmNLong5QI9oB4AkAT9swcAzQT8+AFCKjNXKrkJs3NeNulfDwCOG1UOnXOAQky0KsVUmQk3Vn4+Xw1eNv33foRdd8kBGMsBGMsBGMsBmGrf/wCkj+MGY4xxygAAAABJRU5ErkJggg==";
        Resource resource = new Resource(Resource.RES_TYPE_BASE64,base64);
        GeneOCRClient client = new GeneOCRClient(APP_ID,APP_KEY);
        GeneOCRReply reply = client.geneocr(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
        Assert.assertEquals(1,reply.getData().getItems().size());
        Assert.assertEquals("APPLE",reply.getData().getItems().get(0).getItemString());
    }

}
