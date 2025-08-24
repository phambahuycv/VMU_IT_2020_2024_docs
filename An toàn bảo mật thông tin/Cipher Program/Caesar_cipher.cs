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
        private string Caesar_encrypt(string PlainText, int Key, int Mod_num)
        {
            int UpOrLow = 0;
            string res = "";
            char tmpChar = '0';
            for (int index = 0; index < PlainText.Length; index++)
            {
                UpOrLow = PlainText[index] >= 97 ? 97 : 65;
                tmpChar = Convert.ToChar(mod_euclidean((PlainText[index] + Key - UpOrLow), Mod_num) + UpOrLow);
                res += tmpChar;
            }

            return res;
        }

        private string Caesar_decrypt(string CipherText, int Key, int Mod_num)
        {
            int UpOrLow = 0;
            string res = "";
            char tmpChar = '0';
            for (int index = 0; index < CipherText.Length; index++)
            {
                UpOrLow = CipherText[index] >= 'a' ? 'a' : 'A';
                tmpChar = Convert.ToChar(mod_euclidean((CipherText[index] - Key - UpOrLow), Mod_num) + UpOrLow);
                res += tmpChar;
            }

            return res;
        }

        private void btn_shift_encrypt_Click(object sender, EventArgs e)
        {
            if (isTextBoxEmpty(txt_shift_plainText, "Plain text")) return;
            if (isTextBoxEmpty(txt_shift_encrypt_key, "Encrypt key")) return;

            try
            {

                int key = int.Parse(txt_shift_encrypt_key.Text) % N;

                txt_shift_cipherText.Text = Caesar_encrypt(txt_shift_plainText.Text,
                                                   key, N);
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }


        private void btn_shift_decrypt_Click(object sender, EventArgs e)
        {
            if (isTextBoxEmpty(txt_shift_cipherText, "Cipher text")) return;
            if (isTextBoxEmpty(txt_shift_decrypt_key, "Decrypt key")) return;

            try
            {
                int key = int.Parse(txt_shift_decrypt_key.Text) % N;

                txt_shift_plainText.Text = Caesar_decrypt(txt_shift_cipherText.Text,
                                            key, N);

            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }
        private void btn_shift_reset_Click(object sender, EventArgs e)
        {
            txt_shift_cipherText.ResetText();
            txt_shift_decrypt_key.ResetText();
            txt_shift_encrypt_key.ResetText();
            txt_shift_plainText.ResetText();
        }

        private void btn_shift_copy_encrypt_Click(object sender, EventArgs e)
        {
            try
            {
                Clipboard.SetText(txt_shift_plainText.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btn_shift_copy_decrypt_Click(object sender, EventArgs e)
        {
            try
            {
                Clipboard.SetText(txt_shift_cipherText.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btn_shift_plain_paste_Click(object sender, EventArgs e)
        {
            txt_shift_cipherText.Text = Clipboard.GetText();
        }

        private void btn_shift_cipher_paste_Click(object sender, EventArgs e)
        {
            txt_shift_cipherText.Text = Clipboard.GetText();
        }
    }
}
