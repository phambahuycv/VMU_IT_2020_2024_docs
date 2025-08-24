using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _87726_Pham_Ba_Huy
{
    public partial class Frm1 : Form
    {
        public Frm1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void S_Enter(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void btntim_Click(object sender, EventArgs e)
        {
            int a = Convert.ToInt32((txtnhap1.Text));
            int b = Convert.ToInt32((txtnhap2.Text));
            int c = Convert.ToInt32((txtnhap3.Text));
            int max = a;
            int min = 0;
            if (b > max) max = b;
            if (c > max) max = c;
            txtxuat1.Text = Convert.ToString(max);
            if (a < max) min = a;
            if (b < min) min = b;
            txtxuat2.Text = Convert.ToString(min);
        }
    }
}
