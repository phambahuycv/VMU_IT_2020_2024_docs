using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cau2_137_138
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (txtNhap.Text != "")
            {
                MessageBox.Show("Đã lưu thành công", "Thông báo");
                this.Close();
            }
            else
            {
                MessageBox.Show("Bạn cần nhập dữ kiện", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (txtNhap.Text.Trim() != "")
            {
                listWiew.Items.Clear();
                String str = txtNhap.Text;
                String[] n = str.Split();
                for (int i = 0; i < n.Length; i++)
                {
                    int dem1 = 0;
                    for (int j = 0; j < i; j++)
                    {

                        if (n[i].ToString() == n[j].ToString())
                        {
                            dem1 = 1;
                            break;
                        }
                    }
                    if (dem1 == 0)
                    {
                        int dem2 = 0;
                        for (int k = i; k < n.Length; k++)
                        {
                            if (n[i].ToString() == n[k].ToString())
                            {
                                dem2++;
                            }
                        }
                        ListViewItem tu = new ListViewItem(n[i].ToString());
                        ListViewItem.ListViewSubItem sl = new ListViewItem.ListViewSubItem(tu, dem2.ToString());
                        tu.SubItems.Add(sl);
                        listWiew.Items.Add(tu);

                    }
                }

            }
            else
            {
                MessageBox.Show("Bạn cần nhập dữ kiện", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void listWiew_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            listWiew.Columns.Add("Từ đơn",150);
            listWiew.Columns.Add("Số từ", 150);

            DialogResult hoi = MessageBox.Show("Bạn có muốn tiếp tục Load Form?", "Phạm Bá Huy_87726", MessageBoxButtons.YesNo);
            if (hoi == DialogResult.No)
            {
                this.Close();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string a = txtNhap.Text;
            a = a.Trim();
            while (a.Contains("  "))
            {
                a = a.Replace("  ", " ");
            }
            a = a.Replace(" ,", ",");
            a = a.Replace(" .", ".");
            a = a.Replace(" :", ":");
            a = a.Replace(" ;", ";");
            a = a.Replace(" !", "!");
            a = a.Replace(" ?", "?");
            txtNhap.Text = a;
        }
    }
}
