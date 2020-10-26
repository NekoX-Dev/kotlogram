package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInlineMessageMediaGeo extends TLAbsBotInlineMessage {
    public static final int CONSTRUCTOR_ID = 0xb722de65;

    protected TLAbsGeoPoint geo;

    protected int period;

    private final String _constructor = "botInlineMessageMediaGeo#b722de65";

    public TLBotInlineMessageMediaGeo() {
    }

    public TLBotInlineMessageMediaGeo(TLAbsGeoPoint geo, int period, TLAbsReplyMarkup replyMarkup) {
        this.geo = geo;
        this.period = period;
        this.replyMarkup = replyMarkup;
    }

    private void computeFlags() {
        flags = 0;
        flags = replyMarkup != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(geo, stream);
        writeInt(period, stream);
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            writeTLObject(replyMarkup, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        geo = readTLObject(stream, context, TLAbsGeoPoint.class, -1);
        period = readInt(stream);
        replyMarkup = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += geo.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            size += replyMarkup.computeSerializedSize();
        }
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}