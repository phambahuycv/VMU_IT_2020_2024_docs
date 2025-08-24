using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PhamBaHuy_87726_vd6
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            ThietLapViTriComboBox();
        }
        private void ThietLapViTriComboBox()
        {
            cboViTri.Items.Clear();
            int chiso = Li_DSSanPham.Items.Count;
            for (int i = 0; i < chiso; i++)
                cboViTri.Items.Add(i.ToString());
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            if (txtThemSP.Text.Trim() != "")
            {
                Li_DSSanPham.Items.Add(txtThemSP.Text);
                txtThemSP.Text = "";
                ThietLapViTriComboBox();
            }
            else
                MessageBox.Show("Phải nhập tên sản phẩm");
        }

        private void btnThemVT_Click(object sender, EventArgs e)
        {
            if (txtThemSPViTri.Text.Trim() != "")
            {
                if (cboViTri.Text != "")
                {
                    Li_DSSanPham.Items.Insert(Convert.ToInt32(cboViTri.Text), txtThemSPViTri.Text);
                    txtThemSPViTri.Text = "";
                    ThietLapViTriComboBox();
                }
                else
                    MessageBox.Show("Phải chọn vị trí thêm hợp lệ");
            }
            else
                MessageBox.Show("Phải nhập tên sản phẩm");
        }

        private void btnXoaDS_Click(object sender, EventArgs e)
        {
            if (Li_DSSanPham.Items.Count > 0)
                Li_DSSanPham.Items.Clear();
            else
                MessageBox.Show("Danh sách sản phẩm chưa có gì");
        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            if (Li_DSSanPham.SelectedIndex < 0)
                MessageBox.Show("Chọn sản phẩm muốn xóa");
            else
                Li_DSSanPham.Items.Remove(Li_DSSanPham.SelectedItem);
                MessageBox.Show("Xóa sản phẩm thành công");
        }

        private void btnTimKiem_Click(object sender, EventArgs e)
        {
            if (txtTimSP.Text != "")
            {
                if(Li_DSSanPham.Items.Contains(txtTimSP.Text) == true)
                    MessageBox.Show("Tìm thấy sản phẩm");
                else
                    MessageBox.Show("Không tìm thấy sản phẩm");
            }
            else
                MessageBox.Show("Nhập tên sản phẩm cần tìm");
        }
    }
}
