package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPrivacyValueAllowAll extends TLAbsInputPrivacyRule {
    public static final int CONSTRUCTOR_ID = 0x184b35ce;

    public TLInputPrivacyValueAllowAll() {
    }

    @Override
    public String toString() {
        return "inputPrivacyValueAllowAll#184b35ce";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputPrivacyValueAllowAll)) return false;
        if (object == this) return true;

        TLInputPrivacyValueAllowAll o = (TLInputPrivacyValueAllowAll) object;

        return true;
    }
}