package com.github.badoualy.telegram.tl.api

/**
 * topPeerCategoryCorrespondents#637b7ed
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTopPeerCategoryCorrespondents : TLAbsTopPeerCategory() {
    private val _constructor: String = "topPeerCategoryCorrespondents#637b7ed"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTopPeerCategoryCorrespondents) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x637b7ed.toInt()
    }
}