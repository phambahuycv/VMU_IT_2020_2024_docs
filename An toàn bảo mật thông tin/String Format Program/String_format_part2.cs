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
        private bool isTextConditionEmpty(TextBox txt_check, String txt_name)
        {
            if (txt_check.Text == string.Empty)
            {
                MessageBox.Show($"{txt_name} empty !!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txt_check.Focus();
                return true;
            }
            return false;
        }

        private void btn_first_appears_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;
            if (isTextConditionEmpty(txt_first_appears,"Text")) return;

            int position = txt_original_data.Text.IndexOf(txt_first_appears.Text);
            txt_result.Text = (position == -1) ? "Not find" : "Find in position " + position;
        }

        private void btn_final_appears_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;
            if (isTextConditionEmpty(txt_final_appears, "Text")) return;

            int position = txt_original_data.Text.LastIndexOf(txt_final_appears.Text);
            txt_result.Text = (position == -1) ? "Not find" : "Find in position " + position;
        }

        private void btn_occurrences_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;
            if (isTextConditionEmpty(txt_occurrences, "Text")) return;

            int count = 0;
            int Pos = txt_original_data.Text.IndexOf(txt_occurrences.Text);

            if (Pos == -1) txt_result.Text = $"Not find [{txt_occurrences.Text}] in the string";
            else
            {
                String strTmp = txt_original_data.Text;
                while (Pos != -1)
                {
                    count++;
                    strTmp = strTmp.Substring(Pos + 1);
                    Pos = strTmp.IndexOf(txt_occurrences.Text);
                }

                txt_result.Text = $"Find [{txt_occurrences.Text}] {count} time in the string";
            }
        }

        private void btn_split_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;
            if (isTextConditionEmpty(txt_split, "Split condition")) return;

            char[] arrSplitWord = txt_split.Text.ToCharArray();
            string[] arrStringSplit = txt_original_data.Text.Split(arrSplitWord,StringSplitOptions.RemoveEmptyEntries);
            txt_result.Text = "";

            foreach (string item in arrStringSplit)
                txt_result.Text += item + "\r\n";

        }


        private void btn_chang_substring_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;
            if (isTextConditionEmpty(txt_origin_substring, "Original substring")) return;
            if (isTextConditionEmpty(txt_change_substring, "Change substring")) return;

            txt_result.Text = txt_original_data.Text.Replace(txt_origin_substring.Text, txt_change_substring.Text);
        }

        private void btn_delete_substring_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;
            if (isTextConditionEmpty(txt_del_substring, "Text")) return;

            string strTmp = txt_original_data.Text;
            int Pos = strTmp.IndexOf(txt_del_substring.Text);

            if (Pos == -1) txt_result.Text = strTmp;
            else
            {
                while (Pos != -1)
                {
                    strTmp = strTmp.Remove(Pos, txt_del_substring.Text.Length);
                    Pos = strTmp.IndexOf(txt_del_substring.Text);
                }

                txt_result.Text = strTmp;
            }

        }

        private void btn_insert_string_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;
            if (isTextConditionEmpty(txt_insert_string, "Text")) return;
            if (isTextConditionEmpty(txt_location_insert, "Location insert")) return;

            try
            {
                String strTmp = txt_original_data.Text;
                txt_result.Text = strTmp.Insert(int.Parse(txt_location_insert.Text), txt_insert_string.Text);
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }

        }

        private void btn_filter_extract_Click(object sender, EventArgs e)
        {
            if (isOriginalTextEmpty()) return;
            if (isTextConditionEmpty(txt_filter_extract_pos1, "Position 1")) return;
            if (isTextConditionEmpty(txt_filter_extract_pos2, "Position 2")) return;

            try
            {
                txt_result.Text = txt_original_data.Text.Substring(int.Parse(txt_filter_extract_pos1.Text)
                                    , int.Parse(txt_filter_extract_pos2.Text));
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }
    }
}
