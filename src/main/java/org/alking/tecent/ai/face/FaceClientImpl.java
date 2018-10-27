package org.alking.tecent.ai.face;

import org.alking.tecent.ai.HttpClient;
import org.alking.tecent.ai.domain.Image;
import org.alking.tecent.ai.face.identify.FaceIdentifyReply;
import org.alking.tecent.ai.face.identify.FacePersonNewReply;
import org.alking.tecent.ai.impl.BaseClient;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class FaceClientImpl extends BaseClient implements FaceClient {

    private static final String FACE_DETECT_URL = "https://api.ai.qq.com/fcgi-bin/face/face_detectface";

    private static final String MULTI_FACE_DETECT_URL = "https://api.ai.qq.com/fcgi-bin/face/face_detectmultiface";

    private static final String CROSS_AGE_DETECT_URL = "https://api.ai.qq.com/fcgi-bin/face/face_detectcrossageface";

    private static final String FACE_SHAPE_URL = "https://api.ai.qq.com/fcgi-bin/face/face_faceshape";

    private static final String FACE_COMPARE_URL = "https://api.ai.qq.com/fcgi-bin/face/face_facecompare";

    private static final String FACE_IDENTIFY_URL = "https://api.ai.qq.com/fcgi-bin/face/face_faceidentify";

    private static final String FACE_PERSON_NEW_URL = "https://api.ai.qq.com/fcgi-bin/face/face_newperson";

    private static final String FACE_VERIFY_URL = "https://api.ai.qq.com/fcgi-bin/face/face_faceverify";

    private static final String SIGN_FIELD_MODE = "mode";

    private static final String SIGN_FIELD_SOURCE_IMAGE = "source_image";

    private static final String SIGN_FIELD_TARGET_IMAGE = "target_image";

    private static final String SIGN_FIELD_IMAGE_A = "image_a";

    private static final String SIGN_FIELD_IMAGE_B = "image_b";

    private static final String SIGN_FIELD_GROUP_ID = "group_id";

    private static final String SIGN_FIELD_TOP_N = "topn";

    private static final String SIGN_FIELD_PERSON_ID = "person_id";

    private static final String SIGN_FIELD_GROUP_ID_LIST = "group_ids";

    private static final String SIGN_FIELD_PERSON_NAME = "person_name";

    private static final String SIGN_FIELD_TAG = "tag";

    private static final int TOP_N_MIN = 1;

    private static final int TOP_N_MAX = 10;

    public FaceClientImpl(String appId, String appKey, HttpClient httpClient) {
        super(appId, appKey, httpClient);
    }

    @Override
    public FaceDetectReply detect(Image image, int mode) throws IOException {
        if(mode != FACE_MODE_NORMAL && mode != FACE_MODE_BIG){
            throw new IllegalArgumentException("invalid param type ,should be 0 or 1");
        }
        final String base64 = this.parseSourceData(image);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_MODE,String.valueOf(mode));
        return normalReq(FACE_DETECT_URL,map,FaceDetectReply.class);
    }

    @Override
    public FaceMultiReply multiDetect(Image image) throws IOException {
        final String base64 = this.parseSourceData(image);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        return normalReq(MULTI_FACE_DETECT_URL,map,FaceMultiReply.class);
    }

    @Override
    public FaceCrossAgeReply crossAge(Image image, Image target) throws IOException {
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_SOURCE_IMAGE, this.parseSourceData(image));
        map.put(SIGN_FIELD_TARGET_IMAGE,this.parseSourceData(target));
        return normalReq(CROSS_AGE_DETECT_URL,map,FaceCrossAgeReply.class);
    }

    @Override
    public FaceShapeReply shape(Image image, int mode) throws IOException {
        if(mode != FACE_MODE_NORMAL && mode != FACE_MODE_BIG){
            throw new IllegalArgumentException("invalid param type ,should be 0 or 1");
        }
        final String base64 = this.parseSourceData(image);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_MODE,String.valueOf(mode));
        return normalReq(FACE_SHAPE_URL,map,FaceShapeReply.class);
    }

    @Override
    public FaceCompareReply compare(Image a, Image b) throws IOException {
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
    public FaceIdentifyReply identify(Image res, String groupId, int topN) throws IOException {
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

    @Override
    public FaceVerifyReply verify(Image res, String personId) throws IOException {
        if(StringUtils.isEmpty(personId)){
            throw new IllegalArgumentException("invalid param personId");
        }
        final String base64 = parseSourceData(res);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        map.put(SIGN_FIELD_PERSON_ID,personId);
        return normalReq(FACE_VERIFY_URL,map,FaceVerifyReply.class);
    }

    @Override
    public FacePersonNewReply personNew(Image image, List<String> groups, String personId, String personName, String tag) throws IOException {
        if(image == null){
            throw new IllegalArgumentException("invalid param image.");
        }
        if(groups == null || groups.isEmpty()){
            throw new IllegalArgumentException("invalid param groups.");
        }
        if(StringUtils.isEmpty(personId ) || StringUtils.isEmpty(personName)){
            throw new IllegalArgumentException("invalid param personId or personName.");
        }
        final String base64 = parseSourceData(image);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        map.put(SIGN_FIELD_GROUP_ID_LIST,String.join("|",groups));
        map.put(SIGN_FIELD_PERSON_ID,personId);
        map.put(SIGN_FIELD_PERSON_NAME,personName);
        if(!StringUtils.isEmpty(tag)){
            map.put(SIGN_FIELD_TAG,tag);
        }
        return normalReq(FACE_PERSON_NEW_URL,map,FacePersonNewReply.class);
    }
}
