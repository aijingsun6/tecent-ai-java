package org.alking.tecent.ai.face;

import org.alking.tecent.ai.HttpClient;
import org.alking.tecent.ai.domain.Resource;
import org.alking.tecent.ai.impl.BaseClient;

import java.io.IOException;
import java.util.TreeMap;

public class FaceClientImpl extends BaseClient implements FaceClient {

    private static final String FACE_DETECT_URL = "https://api.ai.qq.com/fcgi-bin/face/face_detectface";

    private static final String MULTI_FACE_DETECT_URL = "https://api.ai.qq.com/fcgi-bin/face/face_detectmultiface";

    private static final String CROSS_AGE_DETECT_URL = "https://api.ai.qq.com/fcgi-bin/face/face_detectcrossageface";

    private static final String SIGN_FIELD_MODE = "mode";

    private static final String SIGN_FIELD_SOURCE_IMAGE = "source_image";

    private static final String SIGN_FIELD_TARGET_IMAGE = "target_image";

    public FaceClientImpl(String appId, String appKey, HttpClient httpClient) {
        super(appId, appKey, httpClient);
    }

    @Override
    public FaceDetectReply detect(Resource resource, int type) throws IOException {
        if(type != FACE_DETECT_TYPE_NORMAL && type != FACE_DETECT_TYPE_BIG){
            throw new IllegalArgumentException("invalid param type ,should be 0 or 1");
        }
        final String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_MODE,String.valueOf(type));
        return normalReq(FACE_DETECT_URL,map,FaceDetectReply.class);
    }

    @Override
    public FaceMultiReply multiDetect(Resource resource) throws IOException {
        final String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        return normalReq(MULTI_FACE_DETECT_URL,map,FaceMultiReply.class);
    }

    @Override
    public FaceCrossAgeReply crossAge(Resource resource, Resource target) throws IOException {
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_SOURCE_IMAGE, this.parseSourceData(resource));
        map.put(SIGN_FIELD_TARGET_IMAGE,this.parseSourceData(target));
        return normalReq(CROSS_AGE_DETECT_URL,map,FaceCrossAgeReply.class);
    }
}
