using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DangKy
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (txtLop.Text != "")
                {
                    cbbLop.Items.Add(txtLop.Text);
                    txtLop.Text = "";
                }
            else
            {
                MessageBox.Show("Bạn phải nhập tên lớp", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
         
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (cbbLop.SelectedIndex < 0) { }
            else
            {
                cbbLop.Items.Remove(cbbLop.SelectedItem);
            }            
        }

        private void button1_Click(object sender, EventArgs e)
        {            
            if (txtTen.Text != "")
            {
                if (cbbLop.SelectedIndex < 0)
                {
                    MessageBox.Show("Bạn phải nhập lớp", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
                else
                {
                    listBox1.Items.Add(txtTen.Text + " / " + dateTimePicker1.Text + " / " + cbbLop.SelectedItem);
                    txtTen.Text = "";
                }                
            }
            else
            {
                MessageBox.Show("Bạn phải nhập tên", "Thông báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex < 0) { }
            else
            {
                listBox1.Items.Remove(listBox1.SelectedItem);
            }
        }
    }
}
