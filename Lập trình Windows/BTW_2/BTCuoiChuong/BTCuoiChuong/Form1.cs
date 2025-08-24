using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BTCuoiChuong
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            hd1.Hide();
            btnTroLai.Hide();
            btnXemHD.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            hd1.BringToFront();
            giaiPhuongTrinh1.Hide();
            btnTroLai.Show();
            btnXemHD.Hide();
            hd1.Show();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            giaiPhuongTrinh1.Hide();
            btnTroLai.Show();
            hd1.BringToFront();
            btnXemHD.Hide();
            hd1.Show();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            btnXemHD.Show();
            giaiPhuongTrinh1.BringToFront();
            giaiPhuongTrinh1.Show();
            btnTroLai.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            btnXemHD.Show();
            giaiPhuongTrinh1.BringToFront();
            btnTroLai.Hide();
            giaiPhuongTrinh1.Show();
        }
    }
}
