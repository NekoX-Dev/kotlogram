
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputPeerChat extends TLAbsInputPeer {
    public static final int CLASS_ID = 0x179be863;

    public TLInputPeerChat() {

    }


    public TLInputPeerChat(        int _chatId) {
        this.chatId = _chatId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int chatId;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
    }



    @Override
    public String toString() {
        return "inputPeerChat#179be863";
    }

}