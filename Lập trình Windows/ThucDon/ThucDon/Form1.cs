using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ThucDon
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult dung = MessageBox.Show("Bạn có muốn thoát không?", "Thông Báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (dung == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            if(txtTen.Text.Trim() != ""){
                libA.Items.Add(txtTen.Text);
                txtTen.Text = "";
            }
            else
            {
                MessageBox.Show("Phải nhập tên món ăn","Thông báo",MessageBoxButtons.OK,MessageBoxIcon.Warning);
            }
        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            if (libA.SelectedIndex < 0)
            {    
            }
            else
            {
                DialogResult dung = MessageBox.Show("Bạn có muốn xóa dòng hiện tại không?", "Thông Báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (dung == DialogResult.Yes)
                {
                    libA.Items.Remove(libA.SelectedItem);
                }              
            }
            if (libB.SelectedIndex < 0)
            {  
            }
            else
            {
                DialogResult dung = MessageBox.Show("Bạn có muốn xóa dòng hiện tại không?", "Thông Báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (dung == DialogResult.Yes)
                {
                    libB.Items.Remove(libB.SelectedItem);
                }                
            }
        }

        private void btnAquaB_Click(object sender, EventArgs e)
        {
            foreach (string item in libA.SelectedItems)
            {
                libB.Items.Add(item);
            }
        }

        private void btnBquaA_Click(object sender, EventArgs e)
        {
            foreach (string item in libB.SelectedItems)
            {
                libA.Items.Add(item);
            }            
        }

        private void btnAllB_Click(object sender, EventArgs e)
        {
            libB.Items.AddRange(libA.Items);
        }

        private void btnAllA_Click(object sender, EventArgs e)
        {
            libA.Items.AddRange(libB.Items);       
        }
    }
}
