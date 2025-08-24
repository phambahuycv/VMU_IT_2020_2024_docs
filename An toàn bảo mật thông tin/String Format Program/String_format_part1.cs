using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace String_Format_Program
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        private void Form1_Load(object sender, EventArgs e)
        {
            //btn_chang_substring.Size = new Size(134, 35);
            //txt_origin_substring.Size = new Size(106, 35);
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            DialogResult res = MessageBox.Show("Are you sure to quit?", "Question", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (res == DialogResult.No) e.Cancel = true;
        }

        private void btn_num_of_char_in_string_Click(object sender, EventArgs e)
        {
            if (txt_original_data.Text == string.Empty)
            {
                MessageBox.Show("Input original string please!!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_original_data.Focus();
                return;
            }

            txt_result.Text = txt_original_data.Text.Length + "";
        }

        private bool isOriginalTextEmpty()
        {
            if (txt_original_data.Text == string.Empty)
            {
                MessageBox.Show("Input original string please!!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_original_data.Focus();
                return true;
            }
            return false;
        }

        private void btn_capitally_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;

            txt_result.Text = txt_original_data.Text.ToUpper();
        }

        private void btn_lowercase_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;

            txt_result.Text = txt_original_data.Text.ToLower();
        }

        private void btn_count_uppers_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;

            int count = 0;
            foreach (char item in txt_original_data.Text)
            {
                if (char.IsUpper(item)) count++;
            }
            txt_result.Text = "String have " + count + " uppercase characters";
        }

        private void btn_count_lower_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;

            int count = 0;
            foreach (char item in txt_original_data.Text)
            {
                if (char.IsLower(item)) count++;
            }
            txt_result.Text = "String have " + count + " lowercase characters";
        }

        private void btn_count_digit_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;

            int count = 0;
            foreach (char item in txt_original_data.Text)
            {
                if (char.IsDigit(item)) count++;
            }
            txt_result.Text = "String have " + count + " digit characters";
        }

        private void btn_reverse_string_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;

            char[] charArray = txt_original_data.Text.ToCharArray();
            Array.Reverse(charArray);
            txt_result.Text = new string(charArray);
        }

        private void btn_string_optimization_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;

            string strOptimization = txt_original_data.Text.Trim();
            string[] arrStrOptimization = strOptimization.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

            txt_result.Text = "";
            foreach (var item in arrStrOptimization)
            {
                item.ToLower();
                char[] newStr = item.ToCharArray();
                newStr[0] = char.ToUpper(newStr[0]);
                txt_result.Text += new string(newStr) + " ";
            }
            txt_result.Text.ToString().TrimEnd();
        }

    }
}
