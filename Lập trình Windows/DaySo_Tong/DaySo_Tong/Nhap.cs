using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;
namespace DaySo_Tong
{
    class Nhap
    {
        public static DialogResult NhapSo(string title,string prompText, ref string value)
        {
            Form1 form = new Form1();
            Label label = new Label();
            TextBox textBox = new TextBox();
            Button buttonOK = new Button();
            Button buttonCancel = new Button();
            form.Text = title;
            label.Text = prompText;
            textBox.Text = value;
            buttonOK.Text = "OK";
            buttonCancel.Text = "Cancel";
            buttonOK.DialogResult= DialogResult.OK;
            buttonCancel.DialogResult = DialogResult.Cancel;
            label.SetBounds(9, 20, 372, 13);
            textBox.SetBounds(12, 36, 372, 20);
            buttonOK.SetBounds(228, 72, 75, 23);
            buttonCancel.SetBounds(309,72,75,23);
            label.AutoSize = true;
            textBox.Anchor = textBox.Anchor | AnchorStyles.Right;
            buttonOK.Anchor = AnchorStyles.Bottom| AnchorStyles.Right;
            buttonCancel.Anchor = AnchorStyles.Bottom | AnchorStyles.Right;
            form.ClientSize = new Size(396, 107);
            form.Controls.AddRange(new Control[] { label, textBox, buttonOK, buttonCancel });
            form.ClientSize = new Size(Math.Max(300, label.Right + 10), form.ClientSize.Height);
            form.FormBorderStyle = FormBorderStyle.FixedDialog;
            form.StartPosition = FormStartPosition.CenterScreen;
            form.MaximizeBox = false;
            form.MinimizeBox = false;
            form.AcceptButton = buttonOK;
            form.CancelButton = buttonCancel;
            DialogResult diagResult = form.ShowDialog();
            value = textBox.Text;
            return diagResult;
        }
    }
}
