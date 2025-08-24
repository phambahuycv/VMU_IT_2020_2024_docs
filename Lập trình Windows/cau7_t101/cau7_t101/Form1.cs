using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cau7_t101
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
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
            DialogResult Hienthi = MessageBox.Show("Họ tên: Phạm Bá Huy\nMã sinh viên: 87726", "Thông tin sinh viên",MessageBoxButtons.OKCancel,MessageBoxIcon.Information);
            if (Hienthi == DialogResult.Cancel)
            {
                this.Close();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult thoat = MessageBox.Show("Bạn có muốn thoát không?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (thoat == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void chkHien_CheckedChanged(object sender, EventArgs e)
        {
            if (chkHien.Checked)
            {
                txtMk.UseSystemPasswordChar=false;
                var checkBox = (CheckBox)sender;
                checkBox.Text = "Hiển thị mật khẩu";
            }
            else
            {
                txtMk.UseSystemPasswordChar = true;
                var checkBox = (CheckBox)sender;
                checkBox.Text = "Hiển thị mật khẩu";
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(txtTen.Text=="admin"&&txtMk.Text=="123456")
            {
                MessageBox.Show("Đăng nhập thành công");
            }
            else
            {
                MessageBox.Show("Không đăng nhập thành công","Thông báo",MessageBoxButtons.OK,MessageBoxIcon.Warning);
            }
        }
    }
}
