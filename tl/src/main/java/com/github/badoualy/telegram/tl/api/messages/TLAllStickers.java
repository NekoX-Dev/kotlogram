package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLStickerSet;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAllStickers extends TLAbsAllStickers {
    public static final int CONSTRUCTOR_ID = 0xedfd405f;

    protected int hash;

    protected TLVector<? extends TLStickerSet> sets;

    public TLAllStickers() {
    }

    public TLAllStickers(int hash, TLVector<? extends TLStickerSet> sets) {
        this.hash = hash;
        this.sets = sets;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(hash, stream);
        writeTLVector(sets, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readInt(stream);
        sets = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += sets.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "messages.allStickers#edfd405f";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLAllStickers)) return false;
        if (object == this) return true;

        TLAllStickers o = (TLAllStickers) object;

        return hash == o.hash
                && (sets == o.sets || (sets != null && o.sets != null && sets.equals(o.sets)));
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public TLVector<? extends TLStickerSet> getSets() {
        return sets;
    }

    public void setSets(TLVector<? extends TLStickerSet> sets) {
        this.sets = sets;
    }
}