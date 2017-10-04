package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateNewChannelMessage#62ba04d9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateNewChannelMessage() : TLAbsUpdate() {
    var message: TLAbsMessage = TLMessageEmpty()

    var pts: Int = 0

    var ptsCount: Int = 0

    private val _constructor: String = "updateNewChannelMessage#62ba04d9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            message: TLAbsMessage,
            pts: Int,
            ptsCount: Int
    ) : this() {
        this.message = message
        this.pts = pts
        this.ptsCount = ptsCount
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(message)
        writeInt(pts)
        writeInt(ptsCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        message = readTLObject<TLAbsMessage>()
        pts = readInt()
        ptsCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += message.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateNewChannelMessage) return false
        if (other === this) return true

        return message == other.message
                && pts == other.pts
                && ptsCount == other.ptsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x62ba04d9.toInt()
    }
}