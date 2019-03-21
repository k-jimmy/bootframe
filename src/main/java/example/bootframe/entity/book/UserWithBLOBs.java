package example.bootframe.entity.book;

public class UserWithBLOBs extends User {
    private byte[] nickName;

    private byte[] phoneCode;

    public byte[] getNickName() {
        return nickName;
    }

    public void setNickName(byte[] nickName) {
        this.nickName = nickName;
    }

    public byte[] getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(byte[] phoneCode) {
        this.phoneCode = phoneCode;
    }
}