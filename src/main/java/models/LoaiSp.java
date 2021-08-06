package models;

public class LoaiSp {
    private int id;
    private String ten;
    private String nhanhieu;

    public LoaiSp() {
    }

    public LoaiSp(int id, String ten, String nhanhieu) {
        this.id = id;
        this.ten = ten;
        this.nhanhieu = nhanhieu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhanhieu() {
        return nhanhieu;
    }

    public void setNhanhieu(String nhanhieu) {
        this.nhanhieu = nhanhieu;
    }
}
