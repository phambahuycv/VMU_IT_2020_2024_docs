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

        private string Affine_encode(string PlainText, int key1, int key2, int Mod_number)
        {
            int UpOrLow = 0;
            string res = "";
            char tmpChar = '0';
            for (int i = 0; i < PlainText.Length; i++)
            {
                UpOrLow = (PlainText[i] >= 97) ? 97 : 65;
                tmpChar = Convert.ToChar(mod_euclidean((PlainText[i] - UpOrLow) * key1 + key2, Mod_number) + UpOrLow);
                res += tmpChar;
            }
            return res;
        }

        private string Affine_decode(string CipherText, int key1, int key2, int Mod_number)
        {
            int UpOrLow = 0;
            string res = "";
            char tmpChar = '0';
            for (int i = 0; i < CipherText.Length; i++)
            {
                UpOrLow = (CipherText[i] >= 97) ? 97 : 65;
                tmpChar = Convert.ToChar(mod_euclidean(key1 * (CipherText[i] - UpOrLow - key2), Mod_number) + UpOrLow);
                res += tmpChar;
                //res += mod_euclidean(key1 * (CipherText[i] - UpOrLow - key2), Mod_number) + UpOrLow + " ";
            }
            return res;
        }

        private void btn_affine_encrypt_Click(object sender, EventArgs e)
        {
            if (isTextBoxEmpty(txt_affine_plainText, "Plain Text")) return;
            if (isTextBoxEmpty(txt_affine_encrypt_key1, "Key 1")) return;
            if (isTextBoxEmpty(txt_affine_encrypt_key2, "Key 2")) return;
            while (gcd(int.Parse(txt_affine_encrypt_key1.Text), N) != 1)
            {
                MessageBox.Show("Key 1 is not valid, please input again!!");
                txt_affine_encrypt_key1.Focus();
                return;
            }

            int key1 = int.Parse(txt_affine_encrypt_key1.Text) % N;
            int key2 = int.Parse(txt_affine_encrypt_key2.Text) % N;

            txt_affine_cipherText.Text = Affine_encode(txt_affine_plainText.Text,
                                        key1, key2, N);
        }

        private void btn_affine_decrypt_Click(object sender, EventArgs e)
        {
            if (isTextBoxEmpty(txt_affine_cipherText, "Cipher Text")) return;
            if (isTextBoxEmpty(txt_affine_decrypt_key1, "Key 1")) return;
            if (isTextBoxEmpty(txt_affine_decrypt_key2, "Key 2")) return;

            int key1 = int.Parse(txt_affine_decrypt_key1.Text) % N;
            int key2 = int.Parse(txt_affine_decrypt_key2.Text) % N;

            while (gcd(key1, N) != 1)
            {
                MessageBox.Show("Key 1 is not valid, please input again!!");
                txt_affine_decrypt_key1.Focus();
                return;
            }

            int invertKey = modInverse(key1, N);

            txt_affine_plainText.Text = Affine_decode(txt_affine_cipherText.Text,
                                        invertKey, key2, N);
        }

        private void btn_affine_reset_Click(object sender, EventArgs e)
        {
            txt_affine_cipherText.ResetText();
            txt_affine_plainText.ResetText();
            txt_affine_decrypt_key1.ResetText();
            txt_affine_decrypt_key2.ResetText();
            txt_affine_encrypt_key1.ResetText();
            txt_affine_encrypt_key2.ResetText();
        }

        private void btn_affine_plain_copy_Click(object sender, EventArgs e)
        {
            try
            {
                Clipboard.SetText(txt_affine_plainText.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btn_affine_cipher_copy_Click(object sender, EventArgs e)
        {
            try
            {
                Clipboard.SetText(txt_affine_cipherText.Text);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btn_affine_plain_paste_Click(object sender, EventArgs e)
        {
            txt_affine_plainText.Text = Clipboard.GetText();
        }

        private void btn_affine_cipher_paste_Click(object sender, EventArgs e)
        {
            txt_affine_cipherText.Text = Clipboard.GetText();
        }
    }
}
