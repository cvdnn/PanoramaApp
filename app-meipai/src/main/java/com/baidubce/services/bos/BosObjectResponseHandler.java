package com.baidubce.services.bos;

import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.bos.model.BosObject;
import com.baidubce.services.bos.model.GetObjectResponse;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.util.BLog;
import com.baidubce.util.JoinerUtils;
import com.baidubce.util.LengthCheckInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Map.Entry;

public class BosObjectResponseHandler implements HttpResponseHandler {
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        if (!(abstractBceResponse instanceof GetObjectResponse)) {
            return false;
        }
        BosObject bosObject = new BosObject();
        ObjectMetadata objectMetadata = bosObject.getObjectMetadata();
        objectMetadata.setContentLength(bceHttpResponse.getHeaderAsLong("Content-Length"));
        objectMetadata.setContentType(bceHttpResponse.getHeader("Content-Type"));
        objectMetadata.setContentEncoding(bceHttpResponse.getHeader(Headers.CONTENT_ENCODING));
        objectMetadata.setContentMd5(bceHttpResponse.getHeader(Headers.CONTENT_MD5));
        objectMetadata.setExpires(bceHttpResponse.getHeader(Headers.EXPIRES));
        objectMetadata.setObjectType(bceHttpResponse.getHeader(Headers.BCE_OBJECT_TYPE));
        objectMetadata.setAppendOffset(bceHttpResponse.getHeaderAsLong(Headers.BCE_NEXT_APPEND_OFFSET));
        objectMetadata.setContentDisposition(bceHttpResponse.getHeader(Headers.CONTENT_DISPOSITION));
        objectMetadata.setCacheControl(bceHttpResponse.getHeader(Headers.CACHE_CONTROL));
        String header = bceHttpResponse.getHeader(Headers.BCE_STORAGE_CLASS);
        if (header == null) {
            header = BosClient.STORAGE_CLASS_STANDARD;
        }
        objectMetadata.setStorageClass(header);
        String header2 = bceHttpResponse.getHeader(Headers.ETAG);
        if (header2 != null) {
            objectMetadata.setETag(JoinerUtils.cut("\"", header2));
        }
        String header3 = bceHttpResponse.getHeader(Headers.BCE_CRC32);
        if (header3 != null) {
            try {
                objectMetadata.setCrc32(Long.valueOf(Long.parseLong(header3)));
            } catch (NumberFormatException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Fail to parse crcx-bce-content-crc32: ");
                sb.append(header3);
                BLog.error(sb.toString(), (Throwable) e2);
            }
        }
        objectMetadata.setContentLength(objectMetadata.getContentLength());
        String header4 = bceHttpResponse.getHeader(Headers.CONTENT_RANGE);
        objectMetadata.setContentRange(header4);
        if (header4 != null) {
            int lastIndexOf = header4.lastIndexOf(47);
            if (lastIndexOf >= 0) {
                try {
                    objectMetadata.setInstanceLength(Long.parseLong(header4.substring(lastIndexOf + 1)));
                } catch (NumberFormatException e3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Fail to parse length from Content-Range: ");
                    sb2.append(header4);
                    BLog.error(sb2.toString(), (Throwable) e3);
                }
            }
        }
        objectMetadata.setLastModified(bceHttpResponse.getHeaderAsRfc822Date(Headers.LAST_MODIFIED));
        objectMetadata.setBceContentSha256(bceHttpResponse.getHeader(Headers.BCE_CONTENT_SHA256));
        for (Entry entry : bceHttpResponse.getHeaders().entrySet()) {
            String str = (String) entry.getKey();
            if (str.startsWith(Headers.BCE_USER_METADATA_PREFIX)) {
                String str2 = "UTF-8";
                objectMetadata.addUserMetadata(URLDecoder.decode(str.substring(11), str2), URLDecoder.decode((String) entry.getValue(), str2));
            }
        }
        InputStream content = bceHttpResponse.getContent();
        if (content != null) {
            if (objectMetadata.getContentLength() >= 0) {
                content = new LengthCheckInputStream(content, objectMetadata.getContentLength(), true);
            }
            bosObject.setObjectContent(new BosObjectInputStream(content, bceHttpResponse.getHttpResponse()));
        }
        ((GetObjectResponse) abstractBceResponse).setObject(bosObject);
        return true;
    }
}
