using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace vd4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Bạn muốn thoát không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (dr == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            
        }

        

        private void Form1_Load(object sender, EventArgs e)
        {
            txtTen.TabIndex = 0;
            txtMk.TabIndex = 1;
            btnDN.TabIndex = 2;
            btnThoat.TabIndex = 3;
            TroGiupMatKhau.SetShowHelp(txtTen, true);
            TroGiupMatKhau.HelpNamespace = "http://phunutoday.vn/kham-pha-cong-nghe/cac-nguyen-tac-tao-mat-khau-an-toan-33828.html";
        }
        private void txtTen_TextChanged(object sender, EventArgs e)
        {
            if (txtTen.Text.IndexOf(' ') != -1)
            {
                LoiTenDN.SetError(txtTen, "Nhập tên không được có khoảng trắng");
            }
            else
            {
                LoiTenDN.Clear();
            }
        }

        private void txtMk_TextChanged(object sender, EventArgs e)
        {
            long so = 0;
            try
            {
                so = Convert.ToInt64(txtMk.Text);
                LoiMatKhau.Clear();
            }
            catch (Exception ex)
            {
                LoiMatKhau.SetError(txtMk, "Phải nhập ký tự số và không được để trống");
            }
        }
    }
}
