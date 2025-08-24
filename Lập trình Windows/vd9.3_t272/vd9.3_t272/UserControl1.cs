using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace vd9._3_t272
{
    public partial class UserControl1 : UserControl
    {
        public UserControl1()
        {
            InitializeComponent();
        }

        private void txtNhapSo_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtNhapSo_KeyPress(object sender, KeyPressEventArgs e)
        {
            try
            {
                lblKetQua.Text = "---------------------------------";
                if (char.IsDigit(e.KeyChar)||e.KeyChar==8)
                {
                    e.Handled = false;
                }
                else
                {
                    e.Handled = true;
                }
            }
            catch { }
            
        }

        private void txtNhapSo_Click(object sender, EventArgs e)
        {
            
        }
    }
}
