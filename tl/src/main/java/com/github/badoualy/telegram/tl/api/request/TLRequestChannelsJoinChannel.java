package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestChannelsJoinChannel extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x24b524c5;

    protected TLAbsInputChannel channel;

    public TLRequestChannelsJoinChannel() {
    }

    public TLRequestChannelsJoinChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(channel, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channel = readTLObject(stream, context, TLAbsInputChannel.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += channel.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "channels.joinChannel#24b524c5";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestChannelsJoinChannel)) return false;
        if (object == this) return true;

        TLRequestChannelsJoinChannel o = (TLRequestChannelsJoinChannel) object;

        return (channel == o.channel || (channel != null && o.channel != null && channel.equals(o.channel)));
    }

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }
}