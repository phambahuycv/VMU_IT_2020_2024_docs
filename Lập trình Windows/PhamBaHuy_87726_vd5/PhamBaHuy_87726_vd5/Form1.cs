using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PhamBaHuy_87726_vd5
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void btnDoiMau_Click(object sender, EventArgs e)
        {
            if (comboBox1.Text == "Vàng")
                lblHienThi.ForeColor = Color.Yellow;
            if (comboBox1.Text == "Đỏ")
                lblHienThi.ForeColor = Color.Red;
            if (comboBox1.Text == "Đen")
                lblHienThi.ForeColor = Color.Black;
            if (comboBox1.Text == "Xanh")
                lblHienThi.ForeColor = Color.Blue;
        }

        private void btnThoat_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Bạn có muốn thoát không?", "Thông Báo", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                this.Close();
            }
        }
    }
}
