package Services;

import dao.CrudSanPham;
import models.SanPham;

import java.util.ArrayList;

public class SanPhamService {
    CrudSanPham crudSanPham=new CrudSanPham();
   public ArrayList<SanPham>list=new ArrayList<>();
    public  void  showsp(){
        try {
            list = crudSanPham.showSp();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void savesp(SanPham sanPham){
        try {
            crudSanPham.saveSp(sanPham);
            list=crudSanPham.showSp();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void editsp(SanPham sanPham, int indexedit){
        try {
            crudSanPham.editSp(indexedit,sanPham);
            list=crudSanPham.showSp();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deletesp(int index){
        try {
            crudSanPham.deleteSp(list.get(index).getId());
            list=crudSanPham.showSp();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
