using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaitapT14_b4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                string str1 ="";
                string str2 = "";
                str1 = Convert.ToString(txtSt1.Text);
                str2 = Convert.ToString(txtEn1.Text);                
                str1 = str1.Replace("/","");                               
                str2 = str2.Replace("/", "");
                double a = Convert.ToDouble(str1);
                double b = Convert.ToDouble(str2);
                double kq = (b - a)*1.4;
                txtKq1.Text = kq.ToString()+"Đồng";  
            }
            catch
            {
                
            }            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            txtEn1.Clear();
            DateTime tn = DateTime.Now;
            txtSt1.Text = tn.ToString("hh/mm/ss");
            btnEn1.Show();
            btnSt1.Hide();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            txtEn2.Clear();
            DateTime tn = DateTime.Now;
            txtSt2.Text = tn.ToString("hh/mm/ss");
            btnEn2.Show();
            btnSt2.Hide();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            btnT1.Show();
            DateTime tn = DateTime.Now;
            txtEn1.Text = tn.ToString("hh/mm/ss");
            btnEn1.Hide();
            btnSt1.Show();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            btnT2.Show();
            DateTime tn = DateTime.Now;
            txtEn2.Text = tn.ToString("hh/mm/ss");
            btnEn2.Hide();
            btnSt2.Show();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            btnT1.Hide();
            btnT2.Hide();
            btnEn1.Hide();
            btnEn2.Hide();
        }

        private void btnT2_Click(object sender, EventArgs e)
        {
            try
            {
                string str1 = "";
                string str2 = "";
                str1 = Convert.ToString(txtSt2.Text);
                str2 = Convert.ToString(txtEn2.Text);
                str1 = str1.Replace("/", "");
                str2 = str2.Replace("/", "");
                double a = Convert.ToDouble(str1);
                double b = Convert.ToDouble(str2);
                double kq = (b - a) * 1.4;
                txtKq2.Text = kq.ToString() + "Đồng";
            }
            catch
            {

            }
        }
    }
}
