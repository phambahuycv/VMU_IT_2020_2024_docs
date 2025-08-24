using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cau8_t101_t102
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        string c;
        double x=0;
        private bool isStop;
        private void Form1_Load(object sender, EventArgs e)
        {
            DialogResult Hienthi = MessageBox.Show("Họ tên: Phạm Bá Huy\nMã sinh viên: 87726", "Thông tin sinh viên", MessageBoxButtons.OKCancel, MessageBoxIcon.Information);
            if (Hienthi == DialogResult.Cancel)
            {
                this.Close();
            }

        }

        

        private void button6_Click(object sender, EventArgs e)
        {
            if (isStop)
            {
                Button b = (Button)sender;
                if (txtHienThi.Text == "0")
                    txtHienThi.Clear();
                txtHienThi.Text = txtHienThi.Text + b.Text;
                if (txtHienThi.Text == "," && b.Text == ",")
                    txtHienThi.Text = "0,";
            }
            else
            {
                txtHienThi.Text = "";
            }
            
        }
        private void button1_Click(object sender, EventArgs e)
        {
            isStop = !isStop;
            if (isStop)
            {
                txtHienThi.Text="0";
                return;
                
            }
            txtHienThi.ResetText();
            
            
        }

        private void button12_Click(object sender, EventArgs e)
        {
            if (isStop)
            {
                if (txtHienThi.Text.Contains("-"))
                {
                    txtHienThi.Text = txtHienThi.Text.Remove(0, 1);
                }
                else
                {
                    txtHienThi.Text = "-" + txtHienThi.Text;
                }
            }
            else
            {
                txtHienThi.Text = "";
            }
            
        }

        private void button15_Click(object sender, EventArgs e)
        {
            if (isStop)
            {
                Button b = (Button)sender;
                c = b.Text;
                x = Convert.ToDouble(txtHienThi.Text);
                txtHienThi.Clear();
            }
            else
            {
                txtHienThi.Text = "";
            }
            
        }

        private void button11_Click(object sender, EventArgs e)
        {
            if (isStop)
            {
                switch (c)
                {
                    case "+":
                        {
                            double y = Convert.ToDouble(txtHienThi.Text);
                            txtHienThi.Text = (x + y).ToString();

                        }
                        break;

                    case "-":
                        {
                            double y = Convert.ToDouble(txtHienThi.Text);
                            txtHienThi.Text = (x - y).ToString();

                        }
                        break;
                    case "*":
                        {
                            double y = Convert.ToDouble(txtHienThi.Text);
                            txtHienThi.Text = (x * y).ToString();

                        }
                        break;
                    case "/":
                        {
                            double y = Convert.ToDouble(txtHienThi.Text);
                            txtHienThi.Text = (x / y).ToString();

                        }
                        break;
                    default:
                        break;
                }
            }
            else
            {
                txtHienThi.Text = "";
            }
        }

        private void button9_Click(object sender, EventArgs e)
        {
            if (isStop)
            {
                if (txtHienThi.Text.Length > 0)
                {
                    txtHienThi.Text = txtHienThi.Text.Remove(txtHienThi.Text.Length - 1, 1);
                }
                if (txtHienThi.Text == "")
                {
                    txtHienThi.Text = "0";
                }
            }
            else
            {
                txtHienThi.Text = "";
            }
            

        }

        private void button10_Click(object sender, EventArgs e)
        {
            x = 0;
            txtHienThi.Clear();
        }
    }
}
