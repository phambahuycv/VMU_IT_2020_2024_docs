using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace De2
{
    // caau 4: cap nhat du lieu cho bang sach
    // cau 5 tìm kiếm theo tên sách năm xuất bản
    public partial class Form1 : Form
    {
        //public static string connectString = @"Data Source=LAPTOP-CVGKALCV\SQLEXPRESS;Initial Catalog=db_de2;Integrated Security=True";
        public Form1()
        {
            InitializeComponent();
        }
        SqlConnection con = new SqlConnection(@"Data Source=LAPTOP-CVGKALCV\SQLEXPRESS;Initial Catalog=db_de2;Integrated Security=True");
        public void HienThi()
        {
            con.Open();
            //string sql = "select Masach, Tensach, Theloai, NamXB, MaNXB, Trangthai from SACH";
            SqlDataAdapter da = new SqlDataAdapter("select Masach, Tensach, Theloai, NamXB, MaNXB, Trangthai from SACH", con);
            DataTable dt = new DataTable(); 
            da.Fill(dt);  
            dataGridView2.DataSource = dt;

            SqlCommand  cmd = new SqlCommand("Select MaNXB From NXB", con);
            SqlDataReader dr = cmd.ExecuteReader();
            while (dr.Read())
            {
                comboBox1.Items.Add(dr[0]).ToString();
            }

            con.Close();  // đóng kết nối
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            HienThi();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            con.Open();
            SqlCommand sql = new SqlCommand("insert into SACH values('"+ textBox3.Text + "', '"+ textBox1.Text + "', '"+ textBox5.Text + "', '"+ textBox2.Text + "', '"+ comboBox1.Text + "', '"+ textBox4.Text + "') ", con);
            sql.ExecuteNonQuery();
            con.Close();
            HienThi();

        }

        private void dataGridView2_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            int i;
            i = dataGridView2.CurrentRow.Index;
            textBox1.Text = dataGridView2.Rows[i].Cells[1].Value.ToString();
            textBox2.Text = dataGridView2.Rows[i].Cells[3].Value.ToString();
            textBox3.Text = dataGridView2.Rows[i].Cells[0].Value.ToString();
            textBox5.Text = dataGridView2.Rows[i].Cells[2].Value.ToString();
            textBox4.Text = dataGridView2.Rows[i].Cells[5].Value.ToString();
            comboBox1.Text = dataGridView2.Rows[i].Cells[4].Value.ToString();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            con.Open();
            int i;
            i = dataGridView2.CurrentRow.Index;
            string ma = dataGridView2.Rows[i].Cells[0].Value.ToString();
            SqlCommand sql = new SqlCommand("update SACH set MaNXB = '" + comboBox1.Text + "', Masach = '"+ textBox3 .Text+ "', Tensach = '"+textBox1.Text+"', Theloai = '"+textBox5.Text+"', NamXB = '"+textBox2.Text+"', Trangthai = '"+textBox4.Text+"'  where Masach = '"+ ma +"' ", con);
            sql.Parameters.AddWithValue("MaNXB", comboBox1.Text);
            sql.ExecuteNonQuery();
            con.Close();
            HienThi();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            con.Open();
            try
            {
                int i = dataGridView2.CurrentRow.Index;
                string ma = dataGridView2.Rows[i].Cells[0].Value.ToString();
                SqlCommand sql = new SqlCommand("delete from SACH where Masach = '" + ma + "'", con);
                sql.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                DialogResult dt;
                dt = MessageBox.Show("Không thể xóa", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (dt == DialogResult.Yes)
                {
                    this.Close();
                }

            }
            con.Close();
            //HienThi();
            Form1 form = new Form1();
            form.Show();
            this.Dispose(false);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            con.Open();
            SqlDataAdapter cmd = new SqlDataAdapter("select * from SACH where Tensach = '" + textBox1.Text + "'", con);
            DataTable dt = new DataTable();
            cmd.Fill(dt);
            dataGridView2.DataSource = dt;
            con.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            con.Open();
            SqlDataAdapter cmd = new SqlDataAdapter("select * from SACH where NamXB = '" + textBox2.Text + "'", con);
            DataTable dt = new DataTable();
            cmd.Fill(dt);
            dataGridView2.DataSource = dt;
            con.Close();

        }
    }
}
