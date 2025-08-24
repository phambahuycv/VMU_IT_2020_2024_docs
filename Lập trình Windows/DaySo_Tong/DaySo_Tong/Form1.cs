using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DaySo_Tong
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            DialogResult th = MessageBox.Show("Bạn muốn thoát không?", "Thông Báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (th == DialogResult.Yes)
            {
                this.Close();
            }
        }
        int tong = 0;
        int chan = 0;
        int le = 0;
        string x = " ";
        private void button2_Click(object sender, EventArgs e)
        {
            txtHienThi.ResetText();
            txtTong.ResetText();
            txtChan.ResetText();
            txtLe.ResetText();
            tong = 0;
            chan = 0;
            le = 0;
            x = " ";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            DialogResult nhap = new DialogResult();
            do
            {
                x = "";
                try
                {
                    nhap = Nhap.NhapSo("Nhập số nguyên", "Nhập số nguyên bất kỳ", ref x);
                    if (x.Length != 0)
                    {
                        tong += Convert.ToInt32(x);
                        txtHienThi.Text += x + " ";
                        txtTong.Text = tong.ToString();
                        int a = Convert.ToInt32(x);
                        if (a % 2 == 0)
                        {
                            chan += Convert.ToInt32(x);
                            txtChan.Text = chan.ToString();
                        }
                        else
                        {
                            le += Convert.ToInt32(x);
                            txtLe.Text = le.ToString();
                        }
                    }
                }
                catch (Exception)
                {
                    MessageBox.Show("Nhập dữ liệu sai", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            } while (nhap == DialogResult.OK && x != "");
        }
    }
}
