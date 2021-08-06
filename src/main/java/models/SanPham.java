package models;

public class SanPham {
    private int id;
    private String ten;
    private double gia;
    private int idloai;
    private String img;

    public SanPham() {
    }

    public SanPham(int id, String ten, double gia, int idloai, String img) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.idloai = idloai;
        this.img = img;
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getIdloai() {
        return idloai;
    }

    public void setIdloai(int idloai) {
        this.idloai = idloai;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
