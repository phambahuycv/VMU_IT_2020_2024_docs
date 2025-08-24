#include <iostream>
using namespace std;

template <class T> bool Doi_sanh(T &p, T &q)
{
    return ((p > q) ? true:false);
}

class Hocvien{
private:
        string hoten;
        int ma;
        float diem;
public:
        Hocvien(string ht, int masv, float d)
        {
            hoten = ht;
            ma = masv;
            diem = d;
        }
        void Nhap()
        {
            cin>>hoten>>ma>>diem;
        }
        void In()
        {
            cout<<hoten<<" "<<ma<<" "<<diem<<endl;
        }
        bool operator>(Hocvien &q)
        {
            if(diem > q.diem)
                return true;
            return false;
        }
        friend void Sosanh(Hocvien &a, Hocvien &b);
};

void Sosanh(Hocvien &a, Hocvien &b)
{
    bool check = Doi_sanh(a.diem, b.diem);
    if(check)
        cout<<"sinh vien: "<<a.hoten<<" co diem cao hon: "<<b.hoten<<endl;
    else
        cout<<"sinh vien: "<<b.hoten<<" co diem cao hon: "<<a.hoten<<endl;
}

int main() {
    Hocvien hv1("Nguyen Van A", 1, 5.5);
    Hocvien hv2("Nguyen Van B", 2, 6.5);
    Hocvien hv3("Nguyenn Van C", 3, 4.5);
    hv1.In();
    hv2.In();
    hv3.In();
	hv1>hv2;
    Sosanh(hv1, hv2);
}
