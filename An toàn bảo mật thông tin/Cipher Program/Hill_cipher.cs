using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cipher_Program
{
    public partial class Cipher_program
    {
        private string Hill_encode(string PlainText, int[,] keyMatrix, int Mod_number)
        {
            int UpOrLow = 0;

            //    int keyMatrix[10][10] {};
            //    getKeyMatrix(key, keyMatrix, 2);

            int numOfRows = PlainText.Length / 2;
            int[,] TextMatrix = new int[2, 10];
            getTextMatrix(PlainText, TextMatrix, numOfRows);

            int[,] CipherMatrix = new int[2, 2];

            int row, col, tmp, k = 0;
            for (row = 0; row < numOfRows; row++)
                for (col = 0; col < 2; col++)
                {
                    UpOrLow = PlainText[k++] >= 'a' ? 'a' : 'A';
                    for (tmp = 0; tmp < 2; tmp++)
                        CipherMatrix[row, col] += TextMatrix[row, tmp] * keyMatrix[tmp, col];
                    CipherMatrix[row, col] %= 26;
                    CipherMatrix[row, col] = mod_euclidean(CipherMatrix[row, col], Mod_number) + UpOrLow;
                }
            string cipherText = "";
            for (row = 0; row < numOfRows; row++)
                for (col = 0; col < 2; col++)
                    cipherText += Convert.ToChar(CipherMatrix[row, col]);
            return cipherText;
        }

        private string Hill_decode(string CipherText, int[,] keyMatrix, int Mod_number)
        {
            int UpOrLow = 0;

            //    int keyMatrix[10][10] {};
            //    getKeyMatrix(key, keyMatrix, 2);

            int numOfRows = CipherText.Length / 2;
            int[,] TextMatrix = new int[2, 10];
            getTextMatrix(CipherText, TextMatrix, numOfRows);

            int[,] CipherMatrix = new int[2, 2];

            int row, col, tmp, k = 0;
            for (row = 0; row < numOfRows; row++)
                for (col = 0; col < 2; col++)
                {
                    UpOrLow = CipherText[k++] >= 'a' ? 'a' : 'A';
                    for (tmp = 0; tmp < 2; tmp++)
                        CipherMatrix[row, col] += TextMatrix[row, tmp] * keyMatrix[tmp, col];
                    CipherMatrix[row, col] %= 26;
                    CipherMatrix[row, col] = mod_euclidean(CipherMatrix[row, col], Mod_number) + UpOrLow;
                }
            string cipherText = "";
            for (row = 0; row < numOfRows; row++)
                for (col = 0; col < 2; col++)
                    cipherText += Convert.ToChar(CipherMatrix[row, col]);
            return cipherText;
        }

        private void btn_hill_encrypt_Click(object sender, EventArgs e)
        {
            if (isTextBoxEmpty(txt_hill_plainText, "Plain Text")) return;
            foreach (TextBox item in grb_hill_matrix_encrypt_key.Controls)
            {
                if (isTextBoxEmpty(item, "Key")) return;
            }

            string PlainText = txt_hill_plainText.Text;
            int[,] keyMatrix = new int[5, 5];
            getKeyMatrixInt(keyMatrix, grb_hill_matrix_encrypt_key, 2);

            if (gcd(keyMatrix[0, 0] * keyMatrix[1, 1] - keyMatrix[1, 0] * keyMatrix[0, 1], N) != 1)
            {
                MessageBox.Show("Key is not valid, input again", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            txt_hill_cipherText.Text = Hill_encode(PlainText, keyMatrix, N);

        }

        private void btn_hill_decrypt_Click(object sender, EventArgs e)
        {
            if (isTextBoxEmpty(txt_hill_cipherText, "Cipher Text")) return;
            foreach (TextBox item in grb_hill_matrix_decrypt_key.Controls)
            {
                if (isTextBoxEmpty(item, "Key")) return;
            }

            string CipherText = txt_hill_cipherText.Text;
            int[,] keyMatrix = new int[5, 5];
            getKeyMatrixInt(keyMatrix, grb_hill_matrix_decrypt_key, 2);

            if (gcd(keyMatrix[0, 0] * keyMatrix[1, 1] - keyMatrix[1, 0] * keyMatrix[0, 1], N) != 1)
            {
                MessageBox.Show("Key is not valid, input again", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            getDecryptKey(keyMatrix, 2);

            txt_hill_plainText.Text = Hill_decode(CipherText, keyMatrix, N);
        }

        private void btn_hill_reset_Click(object sender, EventArgs e)
        {
            reset(grb_hill_cipher);
            reset(grb_hill_plain);
            reset(grb_hill_matrix_encrypt_key);
            reset(grb_hill_matrix_decrypt_key);
        }

        private void btn_hill_copy_plain_Click(object sender, EventArgs e)
        {
            try
            {
                Clipboard.SetText(txt_hill_plainText.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btn_hill_copy_cipher_Click(object sender, EventArgs e)
        {
            try
            {
                Clipboard.SetText(txt_hill_cipherText.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btn_hill_plain_paste_Click(object sender, EventArgs e)
        {
            txt_hill_plainText.Text = Clipboard.GetText();
        }

        private void btn_hill_cipher_paste_Click(object sender, EventArgs e)
        {
            txt_hill_cipherText.Text = Clipboard.GetText();
        }
    }
}
