package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLMethod;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLMethod;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestInitConnection<T extends TLObject> extends TLMethod<T> {
    public static final int CONSTRUCTOR_ID = 0x69796de9;

    protected int apiId;

    protected String deviceModel;

    protected String systemVersion;

    protected String appVersion;

    protected String langCode;

    protected TLMethod<T> query;

    public TLRequestInitConnection() {
    }

    public TLRequestInitConnection(int apiId, String deviceModel, String systemVersion, String appVersion, String langCode, TLMethod<T> query) {
        this.apiId = apiId;
        this.deviceModel = deviceModel;
        this.systemVersion = systemVersion;
        this.appVersion = appVersion;
        this.langCode = langCode;
        this.query = query;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return query.deserializeResponse(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(apiId, stream);
        writeString(deviceModel, stream);
        writeString(systemVersion, stream);
        writeString(appVersion, stream);
        writeString(langCode, stream);
        writeTLMethod(query, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        apiId = readInt(stream);
        deviceModel = readTLString(stream);
        systemVersion = readTLString(stream);
        appVersion = readTLString(stream);
        langCode = readTLString(stream);
        query = readTLMethod(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(deviceModel);
        size += computeTLStringSerializedSize(systemVersion);
        size += computeTLStringSerializedSize(appVersion);
        size += computeTLStringSerializedSize(langCode);
        size += query.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "initConnection#69796de9";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestInitConnection)) return false;
        if (object == this) return true;

        TLRequestInitConnection o = (TLRequestInitConnection) object;

        return apiId == o.apiId
                && (deviceModel == o.deviceModel || (deviceModel != null && o.deviceModel != null && deviceModel.equals(o.deviceModel)))
                && (systemVersion == o.systemVersion || (systemVersion != null && o.systemVersion != null && systemVersion.equals(o.systemVersion)))
                && (appVersion == o.appVersion || (appVersion != null && o.appVersion != null && appVersion.equals(o.appVersion)))
                && (langCode == o.langCode || (langCode != null && o.langCode != null && langCode.equals(o.langCode)))
                && (query == o.query || (query != null && o.query != null && query.equals(o.query)));
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> query) {
        this.query = query;
    }
}