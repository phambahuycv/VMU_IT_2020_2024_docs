using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace bai5_t99_t100
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (txtNhap.Text.Trim() != "")
            {
                int a = int.Parse(txtNhap.Text);
                String x = "";
                for (int i = 2; i <= a; i++)
                {
                    int dem = 0;
                    while (a % i == 0)
                    {
                        dem++;
                        a /= i;
                    }
                    if (dem != 0)
                    {
                        x = x + i.ToString();
                        if (dem > 1)
                        {
                            x = x + "^" + dem;
                        }
                        if (a > 1)
                        {
                            x = x + "*";
                        }
                    }
                }
                txtXuat.Text = x;
            }
            else
            {
                MessageBox.Show("Bạn cần nhập dữ kiện", "Bạn chưa nhập gì cả", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }
    }
}
