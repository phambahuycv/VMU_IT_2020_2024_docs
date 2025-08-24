using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BTCuoiChuong
{
    public partial class GiaiPhuongTrinh : UserControl
    {
        public GiaiPhuongTrinh()
        {
            InitializeComponent();
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void cbbChon_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cbbChon.Text == "Phương Trình Vô Nghiệm")
            {
                vsn1.Hide();
                vn1.Show();
                _1Nghiem1.Hide();
                _2Nghiem1.Hide();
            }
            if (cbbChon.Text == "Phương Trình Có Một Nghiệm")
            {
                vsn1.Hide();
                _1Nghiem1.Show();
                vn1.Hide();
                _2Nghiem1.Hide();
            }
            if (cbbChon.Text == "Phương Trình Có Hai Nghiệm")
            {
                vsn1.Hide();
                _2Nghiem1.Show();
                vn1.Hide();
                _1Nghiem1.Hide();
            }
            if (cbbChon.Text == "Phương Trình Có Vô Số Nghiệm")
            {
                vsn1.Show();
                vn1.Hide();
                _1Nghiem1.Hide();
                _2Nghiem1.Hide();
            }
        }

        private void GiaiPhuongTrinh_Load(object sender, EventArgs e)
        {
            vsn1.Hide();
            vn1.Hide();
            _1Nghiem1.Hide();
            _2Nghiem1.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                double a, b, c, delta, x1, x2;
                double d;
                a = Convert.ToDouble(txtA.Text);
                b = Convert.ToDouble(txtB.Text);
                c = Convert.ToDouble(txtC.Text);
                if (a == 0)
                {
                    if (b == 0)
                    {
                        if (c == 0)
                        {
                            if (cbbChon.Text == "Phương Trình Có Vô Số Nghiệm")
                            {
                                MessageBox.Show("Bạn Làm đúng!", "Kết Quả", MessageBoxButtons.OK);
                            }
                            if (cbbChon.Text == "Phương Trình Vô Nghiệm" || cbbChon.Text == "Phương Trình Có Một Nghiệm" || cbbChon.Text == "Phương Trình Có Hai Nghiệm")
                            {
                                MessageBox.Show("Bạn Làm sai rồi!", "Kết Quả", MessageBoxButtons.OK);
                            }
                        }
                        else
                        {
                            if (cbbChon.Text == "Phương Trình Vô Nghiệm")
                            {
                                MessageBox.Show("Bạn Làm đúng!", "Kết Quả", MessageBoxButtons.OK);
                            }
                            if (cbbChon.Text == "Phương Trình Có Một Nghiệm" || cbbChon.Text == "Phương Trình Có Hai Nghiệm")
                            {
                                MessageBox.Show("Bạn Làm sai rồi!", "Kết Quả", MessageBoxButtons.OK);
                            }
                        }
                    }
                    else
                    {
                        d = +((-c) / b);
                        if (cbbChon.Text == "Phương Trình Có Một Nghiệm")
                        {
                            MessageBox.Show("Kết quả là: " + d + "Bạn Làm đúng!", "Kết Quả", MessageBoxButtons.OK);
                        }
                        if (cbbChon.Text == "Phương Trình Vô Nghiệm" || cbbChon.Text == "Phương Trình Có Hai Nghiệm")
                        {
                            MessageBox.Show("Bạn Làm sai rồi!", "Kết Quả", MessageBoxButtons.OK);
                        }

                    }
                }
                else
                {
                    delta = (b * b) - (4 * a * c);
                    if (delta < 0)
                    {
                        if (cbbChon.Text == "Phương Trình Vô Nghiệm")
                        {
                            MessageBox.Show("Bạn Làm đúng!", "Kết Quả", MessageBoxButtons.OK);
                        }
                        if (cbbChon.Text == "Phương Trình Có Một Nghiệm" || cbbChon.Text == "Phương Trình Có Hai Nghiệm" || cbbChon.Text == "Phương Trình Có Vô Số Nghiệm")
                        {
                            MessageBox.Show("Bạn Làm sai rồi!", "Kết Quả", MessageBoxButtons.OK);
                        }
                    }
                    if (delta > 0)
                    {
                        x1 = (-b + Math.Sqrt(delta)) / (2 * a);
                        x2 = (-b - Math.Sqrt(delta)) / (2 * a);
                        if (cbbChon.Text == "Phương Trình Có Hai Nghiệm")
                        {
                            MessageBox.Show("Kết quả là: " + x1 + "\n" + x2 + "\n" + " Bạn Làm đúng!", "Kết Quả", MessageBoxButtons.OK);
                        }
                        if (cbbChon.Text == "Phương Trình Vô Nghiệm" || cbbChon.Text == "Phương Trình Có Một Nghiệm" || cbbChon.Text == "Phương Trình Có Vô Số Nghiệm")
                        {
                            MessageBox.Show("Bạn Làm sai rồi!", "Kết Quả", MessageBoxButtons.OK);
                        }

                    }
                    if (delta == 0)
                    {
                        if (cbbChon.Text == "Phương Trình Có Một Nghiệm")
                        {
                            MessageBox.Show("Kết quả là: " + (-b / (2 * a)) + "Bạn Làm đúng!", "Kết Quả", MessageBoxButtons.OK);
                        }
                        if (cbbChon.Text == "Phương Trình Vô Nghiệm" || cbbChon.Text == "Phương Trình Có Hai Nghiệm" || cbbChon.Text == "Phương Trình Có Vô Số Nghiệm")
                        {
                            MessageBox.Show("Bạn Làm sai rồi!", "Kết Quả", MessageBoxButtons.OK);
                        }

                    }
                }
            }

            catch
            {

            }

        }
    }

}
