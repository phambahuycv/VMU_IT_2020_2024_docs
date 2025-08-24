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
        private string Vigenere_encode(string PlainText, string key, int Mod_number)
        {
            int UpOrLow = 0;
            int KeyLen = key.Length;
            string res = "";
            char tmpChar = '0';
            for (int i = 0; i < PlainText.Length; i++)
            {
                UpOrLow = (PlainText[i] >= 97) ? 97 : 65;
                tmpChar = Convert.ToChar(mod_euclidean((PlainText[i] + key[i % KeyLen] - 2 * UpOrLow), Mod_number) + UpOrLow);
                res += tmpChar;
            }
            return res;
        }

        private string Vigenere_decode(string CipherText, string key, int Mod_number)
        {
            int UpOrLow = 0;
            int KeyLen = key.Length;
            string res = "";
            char tmpChar = '0';
            for (int i = 0; i < CipherText.Length; i++)
            {
                UpOrLow = (CipherText[i] >= 97) ? 97 : 65;
                tmpChar = Convert.ToChar(mod_euclidean((CipherText[i] - key[i % KeyLen]), Mod_number) + UpOrLow);
                res += tmpChar;
            }
            return res;
        }

        private void btn_vigenere_encrypt_Click(object sender, EventArgs e)
        {
            if (isTextBoxEmpty(txt_vigenere_plainText, "Plain text")) return;
            if (isTextBoxEmpty(txt_vigenere_encrypt_key, "Encrypt key")) return;

            string key = txt_vigenere_encrypt_key.Text;

            txt_vigenere_cipherText.Text = Vigenere_encode(txt_vigenere_plainText.Text,
                                            key, N);
        }

        private void btn_vigenere_decrypt_Click(object sender, EventArgs e)
        {
            if (isTextBoxEmpty(txt_vigenere_cipherText, "Cipher text")) return;
            if (isTextBoxEmpty(txt_vigenere_decrypt_key, "Decrypt key")) return;

            string key = txt_vigenere_decrypt_key.Text;

            txt_vigenere_plainText.Text = Vigenere_decode(txt_vigenere_cipherText.Text,
                                            key, N);
        }

        private void btn_vigenere_reset_Click(object sender, EventArgs e)
        {
            txt_vigenere_cipherText.ResetText();
            txt_vigenere_decrypt_key.ResetText();
            txt_vigenere_encrypt_key.ResetText();
            txt_vigenere_plainText.ResetText();
        }

        private void btn_vigenere_plain_copy_Click(object sender, EventArgs e)
        {
            try
            {
                Clipboard.SetText(txt_vigenere_plainText.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btn_vigenere_cipher_copy_Click(object sender, EventArgs e)
        {
            try
            {
                Clipboard.SetText(txt_vigenere_cipherText.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btn_vigenere_plain_paste_Click(object sender, EventArgs e)
        {
            txt_vigenere_plainText.Text = Clipboard.GetText();
        }

        private void btn_vigenere_cipher_paste_Click(object sender, EventArgs e)
        {
            txt_vigenere_cipherText.Text = Clipboard.GetText();
        }
    }
}
