package example.bootframe.entity.book;

public class BrowseRecordWithBLOBs extends BrowseRecord {
    private byte[] bookAuthor;

    private byte[] url;

    public byte[] getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(byte[] bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }
}