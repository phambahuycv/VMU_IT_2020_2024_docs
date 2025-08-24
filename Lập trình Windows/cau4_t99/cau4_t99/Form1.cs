using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cau4_t99
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void txtXuat_TextChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Bạn có muốn thoát không?", "Thông Báo", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void txtNhap_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(txtNhap.Text))
            {
                MessageBox.Show("Chưa nhập dãy số", "thông báo", MessageBoxButtons.OK, MessageBoxIcon.Error);
                txtNhap.Focus();
            }
            else
            {

                String s = txtNhap.Text.ToString();
                String[] arr = s.Split(' ');
                String ktr = "";
                int[] a = new int[arr.Length];
                for (int i = 0; i < arr.Length; i++)
                {
                    a[i] = int.Parse(arr[i]);
                    for (int j = 0; j < a[i]; j++)
                    {
                        if (a[i] == j * j)
                            ktr = ktr + a[i] + " ";
                    }
                }
                txtXuat.Text = ktr;
            } 
        }
    }
}
