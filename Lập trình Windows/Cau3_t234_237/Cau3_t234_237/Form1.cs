using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Cau3_t234_237
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private bool isStop;
        private string str = "";
        public string txtHienThi { get { return str; } }
        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            isStop = !isStop;
            if (isStop)
            {
                txtKq.Text = "";
                txtS1.Text = "";
                txtS2.Text = "";
                txtSn.Text = "";
                lblFn.Text = "F( )";
                txtS1.Enabled = true;
                txtS2.Enabled = true;
                txtSn.Enabled = true;                
                txtKq.Enabled = true;
                radCo.Checked = true;
                radCo.Enabled = true;
                radKhong.Enabled = true;
                btnBang.Enabled = true;
                btnTt.Enabled = true;                
                btnXem.Enabled = true;                
                return;

            }
            txtS1.Enabled = false;
            txtS2.Enabled = false;
            txtSn.Enabled = false;
            txtKq.Enabled = false;
            radCo.Checked = false;
            radKhong.Checked = false;
            radCo.Enabled = false;
            radKhong.Enabled = false;
            btnBang.Enabled = false;
            btnTt.Enabled = false;            
            btnXem.Enabled = false;                       
            txtKq.ResetText();
            txtS1.ResetText();
            txtS2.ResetText();
            txtSn.ResetText();
        }

        private void btnTt_Click(object sender, EventArgs e)
        {
            txtSn.ReadOnly = false;
            txtKq.ResetText();
            txtS1.ResetText();
            txtS2.ResetText();
            txtSn.ResetText();
            lblFn.Text = "F( )";
        }

        private void txtSn_TextChanged(object sender, EventArgs e)
        {
            lblFn.Text = "F(" + txtSn.Text + ")";
            txtS1.Text = "1";
            txtS2.Text = "1";
            if (txtSn.Text.Trim().Length == 0)
            {
                lblFn.Text = "F( )";
                txtS1.Text = "";
                txtS2.Text = "";
            }       
        }

        private void txtS1_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtS2_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtKq_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtSn_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (char.IsDigit(e.KeyChar)||e.KeyChar==8)
            {
                e.Handled = false;
            }
            else
            {
                e.Handled = true;
            }
        }

        private void btnBang_Click(object sender, EventArgs e)
        {
            try
            {
                if (txtSn.Text != "")
                {
                    txtSn.ReadOnly = true;
                }
                int n = int.Parse(txtSn.Text);
                int f0 = 1;
                int f1 = 1;
                int fn = 1;
                int i;
                txtS1.Text = f0.ToString();
                txtS2.Text = f1.ToString();
                str += "F(0) = " + f0 + "\r\n";
                str += "F(1) = " + f1 + "\r\n";
                if (n < 0)
                {
                    txtKq.Text = (-1).ToString();
                }
                else if (n == 0 || n == 1)
                {
                    txtKq.Text = 1.ToString();
                }
                else
                {
                    for (i = 2; i <= n; i++)
                    {
                        f0 = f1;
                        f1 = fn;
                        fn = f0 + f1;
                        str += "F(" + i + ")" + " = " + "F(" + (i - 1) + ")" + " + " + "F(" + (i - 2) + ")" + " = " + fn + "\r\n";

                    }
                }
                txtKq.Text = fn.ToString();
            }
            catch { } 
        }

        private void radCo_CheckedChanged(object sender, EventArgs e)
        {
            if (radCo.Checked == true)
            {
                btnXem.Enabled = true;
            }
        }

        private void radKhong_CheckedChanged(object sender, EventArgs e)
        {
            if (radKhong.Checked == true)
            {
                btnXem.Enabled = false;
                str = "";
            }
        }

        private void btnXem_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form2 form2 = new Form2();
            form2.textBox = txtHienThi;
            form2.ShowDialog();
            this.Show();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            OpenFileDialog o = new OpenFileDialog();
            if (o.ShowDialog() == DialogResult.OK)
            {
                string fileName;
                fileName = o.FileName;
                string b = File.ReadAllText(o.FileName);

            }
            Form2 frm = new Form2();
            frm.Show();
        }
    }
}
