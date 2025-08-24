using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PhepToan_congtrunhanchia
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (txtSo1.Text == "" || txtSo2.Text == "")
            {
                MessageBox.Show("Bạn hãy nhập dữ liệu", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
            else
            {
                double n;
                double m;
                if(double.TryParse(txtSo1.Text,out n) )
                {
                    if( double.TryParse(txtSo2.Text, out m))
                    {
                        double Kq = 0;
                        if (radCong.Checked == true)
                            Kq = n + m;
                        if (radTru.Checked == true)
                            Kq = n - m;
                        if (radNhan.Checked == true)
                            Kq = n * m;
                        if (radChia.Checked == true)
                            if (m == 0)
                            {
                                MessageBox.Show("Không thể chia cho 0", "Hãy nhập lại số chia", MessageBoxButtons.OK, MessageBoxIcon.Error);
                            }
                            else
                            {
                                Kq = n / m;
                            }
                        txtKq.Text = Convert.ToString(Kq);
                    }
                    else
                    {
                        MessageBox.Show("Nhập lại số", "Phải nhập chữ số", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    }
                    
                }
                else
                {
                    MessageBox.Show("Nhập lại số", "Phải nhập chữ số", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }


            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Bạn muốn thoát không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (dr == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void button2_KeyPress(object sender, KeyPressEventArgs e)
        {
            
        }
    }
}
