using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cau5_t140
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            DialogResult thoat = MessageBox.Show("Bạn muốn thoát không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (thoat == DialogResult.Yes)
                
                this.Close();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Graphics g = this.CreateGraphics();
            Double startingPoint = (this.Width / 2) - (g.MeasureString(this.Text.Trim(), this.Font).Width / 2);
            Double widthOfASpace = g.MeasureString(" ", this.Font).Width;
            String tmp = " ";
            Double tmpWidth = 0;

            while ((tmpWidth + widthOfASpace) < startingPoint)
            {
                tmp += " ";
                tmpWidth += widthOfASpace;
            }

            this.Text = tmp + this.Text.Trim();


            timer1.Start();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            int a = Int32.Parse(lblG.Text);
            int b = Int32.Parse(lblP.Text);
            int c = Int32.Parse(lblS.Text);
            c++;
            if (c > 59)
            {
                c = 0;
                b++;
            }
            if (b > 59)
            {
                b = 0;
                a++;
            }
            if (a > 23)
            {
                a = 0;
             
            }
            if (c < 10)
            {
                lblS.Text = "0" + c;
            }
            else
            {
                lblS.Text =c+"";
            }
            if (b < 10)
            {
                lblP.Text = "0" + b;
            }
            else
            {
                lblP.Text = b + "";
            }
            if (a < 10)
            {
                lblG.Text = "0" + a;
            }
            else
            {
                lblG.Text = a + "";
            }
           
            
        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void lblP_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void lblG_Click(object sender, EventArgs e)
        {

        }

        private void lblS_Click(object sender, EventArgs e)
        {

        }
    }
}
