package example.bootframe.entity.book;

public class BookMarkWithBLOBs extends BookMark {
    private byte[] pointer;

    private byte[] url;

    public byte[] getPointer() {
        return pointer;
    }

    public void setPointer(byte[] pointer) {
        this.pointer = pointer;
    }

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }
}