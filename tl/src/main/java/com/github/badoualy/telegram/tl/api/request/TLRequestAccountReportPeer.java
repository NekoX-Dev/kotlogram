package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsReportReason;
import com.github.badoualy.telegram.tl.core.TLBool;
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
public class TLRequestAccountReportPeer extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0xae189d5f;

    protected TLAbsInputPeer peer;

    protected TLAbsReportReason reason;

    public TLRequestAccountReportPeer() {
    }

    public TLRequestAccountReportPeer(TLAbsInputPeer peer, TLAbsReportReason reason) {
        this.peer = peer;
        this.reason = reason;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLObject(reason, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        reason = readTLObject(stream, context, TLAbsReportReason.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += reason.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "account.reportPeer#ae189d5f";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestAccountReportPeer)) return false;
        if (object == this) return true;

        TLRequestAccountReportPeer o = (TLRequestAccountReportPeer) object;

        return (peer == o.peer || (peer != null && o.peer != null && peer.equals(o.peer)))
                && (reason == o.reason || (reason != null && o.reason != null && reason.equals(o.reason)));
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsReportReason getReason() {
        return reason;
    }

    public void setReason(TLAbsReportReason reason) {
        this.reason = reason;
    }
}