using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace XuLyBanHang
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            DialogResult dung = MessageBox.Show("Bạn có muốn thoát không?","Thông Báo",MessageBoxButtons.YesNo,MessageBoxIcon.Question);
            if(dung== DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void txtDonGia_KeyPress(object sender, KeyPressEventArgs e)
        {
            if(char.IsDigit(e.KeyChar) || e.KeyChar == 8)
            {
                e.Handled = false;
            }
            else
            {
                e.Handled = true;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            txtDonGia.ResetText();
            txtKq.ResetText();
            txtSl.ResetText();
            txtTen.ResetText();
            txtTen.Focus();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(txtTen.Text!="" || txtSl.Text != "" || txtDonGia.Text != "")
            {
                try
                {
                    int Sl;
                    Sl = Convert.ToInt32(txtSl.Text);
                    decimal dongia;
                    dongia = Convert.ToInt32(txtDonGia.Text);
                    string kq = "";
                    kq = (Sl * dongia).ToString();
                    txtKq.Text = kq;
                }
                catch
                {
                    MessageBox.Show("Nhập đúng định dạng với số bé hoi, pls", "Cảnh báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
            }
            else
            {
                MessageBox.Show("Bạn phải nhập đầy đủ thông tin mặt hàng", "Thông Báo", MessageBoxButtons.OK);
            }
        }
    }
}
