using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cipher_Program
{
    public partial class Cipher_program : Form
    {
        public Cipher_program()
        {
            InitializeComponent();
        }

        const int N = 26;

        private int mod_euclidean(int num, int mod_num)
        {
            int m = num % mod_num;
            if (m < 0) m = (mod_num < 0) ? m - mod_num : m + mod_num;
            return m;
        }


        // stackover flow code
        /// <summary>
        /// Function to get inverse of a
        /// </summary>
        /// <param name="a">num u want to get invert</param>
        /// <param name="n">mod num</param>
        /// <returns></returns>
        private int modInverse(int a, int n)
        {
            int i = n, v = 0, d = 1;
            while (a > 0)
            {
                int t = i / a, x = a;
                a = i % x;
                i = x;
                x = d;
                d = v - t * x;
                v = x;
            }
            v %= n;
            if (v < 0) v = (v + n) % n;
            return v;
        }

        private int gcd(int first_num, int second_num)
        {
            while (first_num * second_num > 0)
            {
                if (first_num > second_num) first_num = mod_euclidean(first_num, second_num);
                else second_num = mod_euclidean(second_num, first_num);
            }
            return first_num + second_num;
        }

        private bool isTextBoxEmpty(TextBox txt, string txt_name)
        {
            if (txt.Text == string.Empty)
            {
                MessageBox.Show($"{txt_name} is empty!!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt.Focus();
                return true;
            }
            return false;
        }

        private void txt_shift_encrypt_key_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsDigit(e.KeyChar) && !char.IsControl(e.KeyChar))
                e.Handled = true;
        }

        private void txt_affine_encrypt_key1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsDigit(e.KeyChar) && !char.IsControl(e.KeyChar))
                e.Handled = true;
        }

        private void getKeyMatrixInt(int[,] keyMatrix, GroupBox grb, int size)
        {
            int k = 0;
            for (int row = 0; row < size; row++)
                for (int col = 0; col < size; col++)
                    keyMatrix[row, col] = int.Parse(grb.Controls[k++].Text);
            //int row = 0, col = 0;
            //foreach (TextBox item in grb_hill_matrix_encrypt_key.Controls)
            //{
            //    keyMatrix[row, col] = item;
            //}
        }

        private void getTextMatrix(string PlainText, int[,] TextMatrix, int Rows)
        {
            int k = 0, UpOrLow;
            for (int row = 0; row < Rows; row++)
                for (int col = 0; col < 2; col++)
                {
                    UpOrLow = PlainText[k] >= 'a' ? 'a' : 'A';
                    TextMatrix[row, col] = PlainText[k++] % UpOrLow;
                }
        }

        private void swap(ref int firstNum, ref int secondNum)
        {
            int tmp = firstNum;
            firstNum = secondNum;
            secondNum = tmp;
        }

        private void getDecryptKey(int[,] keyMatrix, int Size)
        {
            swap(ref keyMatrix[0,0],ref keyMatrix[1,1]);
            keyMatrix[1,0] *= -1;
            keyMatrix[0,1] *= -1;
            int detInvert = modInverse(keyMatrix[0,0] * keyMatrix[1,1] - keyMatrix[1,0] * keyMatrix[0,1], N);
            for (int row = 0; row < Size; row++)
                for (int col = 0; col < Size; col++)
                    keyMatrix[row,col] = (detInvert * keyMatrix[row,col]) % 26;
        }

        private void txt_hill_encrypt_key00_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsDigit(e.KeyChar) && !char.IsControl(e.KeyChar))
                e.Handled = true;
        }

        private void reset(GroupBox grb)
        {
            foreach (Control item in grb.Controls)
            {
                if (item is TextBox) item.ResetText();
            }
        }

    }
}
