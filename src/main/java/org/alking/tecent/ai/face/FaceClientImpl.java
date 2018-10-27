package org.alking.tecent.ai.face;

import org.alking.tecent.ai.HttpClient;
import org.alking.tecent.ai.domain.Resource;
import org.alking.tecent.ai.impl.BaseClient;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.TreeMap;

public class FaceClientImpl extends BaseClient implements FaceClient {

    private static final String FACE_DETECT_URL = "https://api.ai.qq.com/fcgi-bin/face/face_detectface";

    private static final String MULTI_FACE_DETECT_URL = "https://api.ai.qq.com/fcgi-bin/face/face_detectmultiface";

    private static final String CROSS_AGE_DETECT_URL = "https://api.ai.qq.com/fcgi-bin/face/face_detectcrossageface";

    private static final String FACE_SHAPE_URL = "https://api.ai.qq.com/fcgi-bin/face/face_faceshape";

    private static final String FACE_COMPARE_URL = "https://api.ai.qq.com/fcgi-bin/face/face_facecompare";

    private static final String FACE_IDENTIFY_URL = "https://api.ai.qq.com/fcgi-bin/face/face_faceidentify";

    private static final String SIGN_FIELD_MODE = "mode";

    private static final String SIGN_FIELD_SOURCE_IMAGE = "source_image";

    private static final String SIGN_FIELD_TARGET_IMAGE = "target_image";

    private static final String SIGN_FIELD_IMAGE_A = "image_a";

    private static final String SIGN_FIELD_IMAGE_B = "image_b";

    private static final String SIGN_FIELD_GROUP_ID = "group_id";

    private static final String SIGN_FIELD_TOP_N = "topn";

    public static final int TOP_N_MIN = 1;

    public static final int TOP_N_MAX = 10;

    public FaceClientImpl(String appId, String appKey, HttpClient httpClient) {
        super(appId, appKey, httpClient);
    }

    @Override
    public FaceDetectReply detect(Resource resource, int mode) throws IOException {
        if(mode != FACE_MODE_NORMAL && mode != FACE_MODE_BIG){
            throw new IllegalArgumentException("invalid param type ,should be 0 or 1");
        }
        final String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_MODE,String.valueOf(mode));
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

    @Override
    public FaceShapeReply shape(Resource resource,int mode) throws IOException {
        if(mode != FACE_MODE_NORMAL && mode != FACE_MODE_BIG){
            throw new IllegalArgumentException("invalid param type ,should be 0 or 1");
        }
        final String base64 = this.parseSourceData(resource);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_MODE,String.valueOf(mode));
        return normalReq(FACE_SHAPE_URL,map,FaceShapeReply.class);
    }

    @Override
    public FaceCompareReply compare(Resource a, Resource b) throws IOException {
        if(a == null || b == null){
            throw new IllegalArgumentException("resource can not be null.");
        }
        final String base64A = parseSourceData(a);
        final String base64B = parseSourceData(b);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE_A,base64A);
        map.put(SIGN_FIELD_IMAGE_B,base64B);
        return normalReq(FACE_COMPARE_URL,map,FaceCompareReply.class);
    }

    @Override
    public FaceIdentifyReply identify(Resource res, String groupId, int topN) throws IOException {
        if(StringUtils.isEmpty(groupId)){
            throw new IllegalArgumentException("invalid param groupId");
        }

        if(topN < TOP_N_MIN || topN > TOP_N_MAX){
            throw new IllegalArgumentException("param topN out of range [1,10]");
        }
        final String base64 = parseSourceData(res);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        map.put(SIGN_FIELD_GROUP_ID,groupId);
        map.put(SIGN_FIELD_TOP_N,String.valueOf(topN));
        return normalReq(FACE_IDENTIFY_URL,map,FaceIdentifyReply.class);
    }
}
