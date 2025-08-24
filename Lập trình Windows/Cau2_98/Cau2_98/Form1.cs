using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cau2_98
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            txtNoiDung.ResetText();
            lbXuat.Items.Clear();
        }


        private void button1_Click(object sender, EventArgs e)
        {

            if (txtNoiDung.Text.Trim() != "")
            {
                String str = txtNoiDung.Text;
                String ss = "";
                String[] n = str.Split(); 
                for(int i=0;i<n.Length;i++)
                {
                    int dem1 = 0;
                    for(int j=0;j< i;j++)
                    {
                        if (n[i].ToString() == n[j].ToString())
                        {
                            dem1=1;
                            break;
                        }
                    }
                    if (dem1 == 0)
                    {
                        int dem2 = 0;
                        for(int k= i;k< n.Length; k++)
                        {
                            if(n[i].ToString() == n[k].ToString())
                            {
                                dem2++;
                            }
                        }
                        ss = n[i].ToString() + ": " + dem2.ToString() + " lần";
                        lbXuat.Items.Add(ss);
                    }                 
                }
               
            }
            else
            {
                MessageBox.Show("Bạn cần nhập dữ kiện","Thông Báo",MessageBoxButtons.OK,MessageBoxIcon.Warning);
            }
        }
    }
}
