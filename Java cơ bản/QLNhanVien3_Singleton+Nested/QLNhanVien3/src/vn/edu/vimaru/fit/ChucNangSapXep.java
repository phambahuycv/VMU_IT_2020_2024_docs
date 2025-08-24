package vn.edu.vimaru.fit;

public class ChucNangSapXep implements ChucNang {
    DanhSachNhanVien ds;

    public ChucNangSapXep(DanhSachNhanVien ds) {
        this.ds = ds;
    }

    @Override
    public String moTa() {
        return "Sắp xếp theo tuổi";
    }

    @Override
    public void thuThi() {
        ds.sapXepTheoTuoi();
    }
}
