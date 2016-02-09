package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateStickerSetsOrder extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0xf0dfb451;

    protected TLLongVector order;

    public TLUpdateStickerSetsOrder() {
    }

    public TLUpdateStickerSetsOrder(TLLongVector order) {
        this.order = order;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(order, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        order = readTLLongVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += order.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "updateStickerSetsOrder#f0dfb451";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUpdateStickerSetsOrder)) return false;
        if (object == this) return true;

        TLUpdateStickerSetsOrder o = (TLUpdateStickerSetsOrder) object;

        return (order == o.order || (order != null && o.order != null && order.equals(o.order)));
    }

    public TLLongVector getOrder() {
        return order;
    }

    public void setOrder(TLLongVector order) {
        this.order = order;
    }
}