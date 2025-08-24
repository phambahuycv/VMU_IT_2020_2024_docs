using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cau3_t98_t99
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            double a, b, c, delta, x1, x2;
            double d;
            a = Convert.ToDouble(txtA.Text);
            b = Convert.ToDouble(txtB.Text);
            c = Convert.ToDouble(txtC.Text);
            if (a == 0)
            {
                if (b == 0)
                {
                    if (c == 0)
                    {
                        txtNghiem.Text = "Vô số nghiệm";
                    }
                    else
                    {
                        txtNghiem.Text = "Vô nghiệm";
                    }
                }
                else
                {
                    d = +((-c)/b);
                    txtNghiem.Text ="" +d;
                }
            }
            else
            {
                delta = (b * b) - (4 * a * c);
                if (delta < 0)
                {
                    txtNghiem.Text = "Vô nghiệm";
                }
                if (delta > 0)
                {
                    x1 = (-b + Math.Sqrt(delta)) / (2 * a);
                    x2 = (-b - Math.Sqrt(delta)) / (2 * a);
                    txtNghiem.Text = "" + x1+" "+x2;
                }
                if (delta == 0)
                {
                    txtNghiem.Text = "" + (-b / (2 * a));
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Bạn có muốn thoát không?", "Thông Báo", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                this.Close();
            }
        }
    }
}
