using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Câu_1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
        float diemvan, diemanh, diemtoan, diemcong;
        float diemtb()
        {
            return ((diemvan + diemanh + diemtoan) / 3)+diemcong;
        }
        private void btnDTB_Click(object sender, EventArgs e)
        {
            string ten = Convert.ToString(txtTen.Text);
            string ns = Convert.ToString(txtNs.Text);

            diemtoan = float.Parse(txtdT.Text);
            diemvan = float.Parse(txtvan.Text);
            diemanh = float.Parse(txtanh.Text);
            diemcong = float.Parse(txtcong.Text);

            if (String.IsNullOrEmpty(txtdT.Text) || String.IsNullOrEmpty(txtcong.Text) || String.IsNullOrEmpty(txtvan.Text) || ten == "" || ns == "" ) 
            {
                MessageBox.Show("Chưa điền đủ thông tin", "Thông báo", MessageBoxButtons.OK);
            }

            else
            {
                txtDTB.Text = diemtb().ToString();
            }
        }

        private void btnXL_Click(object sender, EventArgs e)
        {
           
            if (diemtb() >= 9.0 && diemtb() <= 10)
            {
                txtXL.Text = "Xuất sắc";
            }
            else if (diemtb() < 9.0 && diemtb() >= 8.0)
            {
                txtXL.Text = "Giỏi";
            }
            else if (diemtb() < 8.0 && diemtb() >= 6.5)
            {
                txtXL.Text = "Khá";
            }
            else if (diemtb() < 6.5 && diemtb() >= 5.0)
            {
                txtXL.Text = "TB";
            }
            else
            {
                txtXL.Text = "Yếu";
            }
        }

        private void btnThoat_Click(object sender, EventArgs e)
        {
            if(MessageBox.Show("Bạn muốn thoát ?","Thông báo",MessageBoxButtons.YesNo)==DialogResult.Yes)
            {
                this.Close();
            }

        }
    }
}
