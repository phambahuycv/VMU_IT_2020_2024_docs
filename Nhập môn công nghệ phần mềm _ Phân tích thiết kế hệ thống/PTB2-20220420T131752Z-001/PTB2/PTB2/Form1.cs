using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PTB2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            
            InitializeComponent();
        }
       
        private void btngiai_Click(object sender, EventArgs e)
        {
            uC_Giai1.BringToFront();
            btntrove.Show();
        }

        private void btnhuongdan_Click(object sender, EventArgs e)
        {
            uC_Giai1.Hide();
            uC_Huongdan1.BringToFront();
            btntrove.Show();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            btntrove.Hide();
        }

        private void spcptb2_Panel2_Paint(object sender, PaintEventArgs e)
        {

        }

        private void uC_Huongdan1_Load(object sender, EventArgs e)
        {
            
            uC_Giai1.BringToFront();
        }

        private void btntrove_Click(object sender, EventArgs e)
        {
            uC_Giai1.Show();
            uC_Huongdan1.Hide();
        }

        private void uC_Giai1_Load(object sender, EventArgs e)
        {
            
        }
    }
}
