using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace caculator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        string c;
        double x = 0;
        private void button16_Click(object sender, EventArgs e)
        {
            try
            {
                Button b = (Button)sender;
                c = b.Text;
                x = Convert.ToDouble(txtKq.Text);
                txtKq.Clear();
            }
            catch { }
        }

        private void button18_Click(object sender, EventArgs e)
        {
            try
            {
                switch (c)
                {
                    case "+":
                        {
                            double y = Convert.ToDouble(txtKq.Text);
                            txtKq.Text = (x + y).ToString();

                        }
                        break;

                    case "-":
                        {
                            double y = Convert.ToDouble(txtKq.Text);
                            txtKq.Text = (x - y).ToString();

                        }
                        break;
                    case "*":
                        {
                            double y = Convert.ToDouble(txtKq.Text);
                            txtKq.Text = (x * y).ToString();

                        }
                        break;
                    case "/":
                        {
                            double y = Convert.ToDouble(txtKq.Text);
                            txtKq.Text = (x / y).ToString();

                        }
                        break;
                    default:
                        break;
                }
            }
            catch
            {
                txtKq.Text = txtKq.Text + "";
            }
        }

        private void button17_Click(object sender, EventArgs e)
        {
            x = 0;
            txtKq.Clear();
        }

        private void button11_Click(object sender, EventArgs e)
        {
            if (txtKq.Text.Contains("-"))
            {
                txtKq.Text = txtKq.Text.Remove(0, 1);
            }
            else
            {
                txtKq.Text = "-" + txtKq.Text;
            }
        }

        private void button10_Click(object sender, EventArgs e)
        {
            Button b = (Button)sender;
            if (txtKq.Text == "0")
                txtKq.Text = "";
            //txtKq.Clear();
            
            if (b.Text == ".")
            {
                if (!txtKq.Text.Contains("."))
                {
                    txtKq.Text = txtKq.Text + b.Text;
                }
                
            }
            else
            {
                txtKq.Text = txtKq.Text + b.Text;
            }            
        }
    }
}
