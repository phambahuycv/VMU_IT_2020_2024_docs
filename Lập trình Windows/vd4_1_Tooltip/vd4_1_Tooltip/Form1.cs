using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace vd4_1_Tooltip
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
            string s,k;
            s = txtDangNhap.Text;
            k = txtMatKhau.Text;
            if (s == "" || k == "")
            {
                MessageBox.Show("Hãy nhập thông tin đăng nhập", "Bạn chưa nhập gì cả",MessageBoxButtons.OK,MessageBoxIcon.Information);
            }
            else
            {  
                    MessageBox.Show("Bạn đăng nhập thành công");
            }

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            ttpDangNhap.SetToolTip(txtDangNhap,"Nhập chuỗi ký tự không dấu, Không khoảng trắng");
            ttpMatKhau.SetToolTip(txtMatKhau, "Nhập ít nhất 6 ký tự, nhiều nhất 10 ký tự");
        }
    }
}
