using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace vd9._3_t272
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult th = MessageBox.Show("Bạn muốn thoát không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Information);
            if (DialogResult.Yes == th)
            {
                this.Close();
            }
        }
        bool ktrSNT(int x)
        {
            bool kt = true;
            for (int i = 2; i <= x / 2; i++)
                if (x % i == 0)
                    kt = false;
            return kt;
        }
        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                int gt = int.Parse(userControl11.Controls["txtNhapSo"].Text);
                if (ktrSNT(gt) == true)
                    userControl11.Controls["lblKetQua"].Text = "Là số nguyên tố";
                else
                    userControl11.Controls["lblKetQua"].Text = gt.ToString() + " Không là số nguyên tố";
                userControl11.Controls["txtNhapSo"].Text = "";
            }
            catch(Exception ex)
            {
                MessageBox.Show("Hãy nhập số nhỏ mà kiểu nguyên đếm được pls!", "Thông Báo",MessageBoxButtons.OK,MessageBoxIcon.Warning);
            }
        }
    }
}
