namespace Cau3_t234_237
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.button1 = new System.Windows.Forms.Button();
            this.btnTt = new System.Windows.Forms.Button();
            this.btnXem = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.radCo = new System.Windows.Forms.RadioButton();
            this.radKhong = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.txtS1 = new System.Windows.Forms.TextBox();
            this.txtSn = new System.Windows.Forms.TextBox();
            this.txtS2 = new System.Windows.Forms.TextBox();
            this.txtKq = new System.Windows.Forms.TextBox();
            this.btnBang = new System.Windows.Forms.Button();
            this.lblFn = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(12, 62);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 51);
            this.button1.TabIndex = 0;
            this.button1.Text = "Mở/Tắt";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // btnTt
            // 
            this.btnTt.Enabled = false;
            this.btnTt.Location = new System.Drawing.Point(12, 281);
            this.btnTt.Name = "btnTt";
            this.btnTt.Size = new System.Drawing.Size(75, 51);
            this.btnTt.TabIndex = 1;
            this.btnTt.Text = "Tiếp Tục";
            this.btnTt.UseVisualStyleBackColor = true;
            this.btnTt.Click += new System.EventHandler(this.btnTt_Click);
            // 
            // btnXem
            // 
            this.btnXem.Enabled = false;
            this.btnXem.Location = new System.Drawing.Point(16, 199);
            this.btnXem.Name = "btnXem";
            this.btnXem.Size = new System.Drawing.Size(75, 51);
            this.btnXem.TabIndex = 2;
            this.btnXem.Text = "Xem File";
            this.btnXem.UseVisualStyleBackColor = true;
            this.btnXem.Click += new System.EventHandler(this.btnXem_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.lblFn);
            this.groupBox1.Controls.Add(this.btnBang);
            this.groupBox1.Controls.Add(this.txtKq);
            this.groupBox1.Controls.Add(this.txtS2);
            this.groupBox1.Controls.Add(this.txtSn);
            this.groupBox1.Controls.Add(this.txtS1);
            this.groupBox1.Controls.Add(this.label11);
            this.groupBox1.Controls.Add(this.label10);
            this.groupBox1.Controls.Add(this.label9);
            this.groupBox1.Controls.Add(this.label8);
            this.groupBox1.Controls.Add(this.label7);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(115, 47);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(316, 285);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Các số hạng của dãy Fibo";
            this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.radKhong);
            this.groupBox2.Controls.Add(this.radCo);
            this.groupBox2.Controls.Add(this.btnXem);
            this.groupBox2.Location = new System.Drawing.Point(449, 47);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(119, 285);
            this.groupBox2.TabIndex = 4;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Ghi từng số hạng vào file văn bản";
            // 
            // radCo
            // 
            this.radCo.AutoSize = true;
            this.radCo.Enabled = false;
            this.radCo.Location = new System.Drawing.Point(16, 77);
            this.radCo.Name = "radCo";
            this.radCo.Size = new System.Drawing.Size(38, 17);
            this.radCo.TabIndex = 3;
            this.radCo.TabStop = true;
            this.radCo.Text = "Có";
            this.radCo.UseVisualStyleBackColor = true;
            this.radCo.CheckedChanged += new System.EventHandler(this.radCo_CheckedChanged);
            // 
            // radKhong
            // 
            this.radKhong.AutoSize = true;
            this.radKhong.Enabled = false;
            this.radKhong.Location = new System.Drawing.Point(16, 112);
            this.radKhong.Name = "radKhong";
            this.radKhong.Size = new System.Drawing.Size(56, 17);
            this.radKhong.TabIndex = 4;
            this.radKhong.TabStop = true;
            this.radKhong.Text = "Không";
            this.radKhong.UseVisualStyleBackColor = true;
            this.radKhong.CheckedChanged += new System.EventHandler(this.radKhong_CheckedChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(26, 53);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(65, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Số hạng thứ";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(103, 53);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(13, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "0";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(155, 53);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(25, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "F(0)";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(200, 53);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(13, 13);
            this.label4.TabIndex = 3;
            this.label4.Text = "=";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(26, 99);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(65, 13);
            this.label5.TabIndex = 4;
            this.label5.Text = "Số hạng thứ";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(26, 161);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(65, 13);
            this.label6.TabIndex = 5;
            this.label6.Text = "Số hạng thứ";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(200, 99);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(13, 13);
            this.label7.TabIndex = 6;
            this.label7.Text = "=";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(97, 99);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(0, 13);
            this.label8.TabIndex = 7;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(103, 99);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(13, 13);
            this.label9.TabIndex = 8;
            this.label9.Text = "1";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(155, 99);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(25, 13);
            this.label10.TabIndex = 9;
            this.label10.Text = "F(1)";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(68, 218);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(145, 13);
            this.label11.TabIndex = 10;
            this.label11.Text = "Biết rằng F(n)= F(n-1) + F(n-2)";
            // 
            // txtS1
            // 
            this.txtS1.Enabled = false;
            this.txtS1.Location = new System.Drawing.Point(239, 50);
            this.txtS1.Name = "txtS1";
            this.txtS1.ReadOnly = true;
            this.txtS1.Size = new System.Drawing.Size(32, 20);
            this.txtS1.TabIndex = 11;
            this.txtS1.TextChanged += new System.EventHandler(this.txtS1_TextChanged);
            this.txtS1.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtSn_KeyPress);
            // 
            // txtSn
            // 
            this.txtSn.Enabled = false;
            this.txtSn.Location = new System.Drawing.Point(97, 154);
            this.txtSn.Name = "txtSn";
            this.txtSn.Size = new System.Drawing.Size(32, 20);
            this.txtSn.TabIndex = 12;
            this.txtSn.TextChanged += new System.EventHandler(this.txtSn_TextChanged);
            this.txtSn.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtSn_KeyPress);
            // 
            // txtS2
            // 
            this.txtS2.Enabled = false;
            this.txtS2.Location = new System.Drawing.Point(239, 99);
            this.txtS2.Name = "txtS2";
            this.txtS2.ReadOnly = true;
            this.txtS2.Size = new System.Drawing.Size(32, 20);
            this.txtS2.TabIndex = 13;
            this.txtS2.TextChanged += new System.EventHandler(this.txtS2_TextChanged);
            this.txtS2.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtSn_KeyPress);
            // 
            // txtKq
            // 
            this.txtKq.Enabled = false;
            this.txtKq.Location = new System.Drawing.Point(239, 151);
            this.txtKq.Name = "txtKq";
            this.txtKq.ReadOnly = true;
            this.txtKq.Size = new System.Drawing.Size(32, 20);
            this.txtKq.TabIndex = 14;
            this.txtKq.TextChanged += new System.EventHandler(this.txtKq_TextChanged);
            this.txtKq.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtSn_KeyPress);
            // 
            // btnBang
            // 
            this.btnBang.Enabled = false;
            this.btnBang.Location = new System.Drawing.Point(189, 152);
            this.btnBang.Name = "btnBang";
            this.btnBang.Size = new System.Drawing.Size(24, 23);
            this.btnBang.TabIndex = 15;
            this.btnBang.Text = "=";
            this.btnBang.UseVisualStyleBackColor = true;
            this.btnBang.Click += new System.EventHandler(this.btnBang_Click);
            // 
            // lblFn
            // 
            this.lblFn.AutoSize = true;
            this.lblFn.Location = new System.Drawing.Point(155, 154);
            this.lblFn.Name = "lblFn";
            this.lblFn.Size = new System.Drawing.Size(22, 13);
            this.lblFn.TabIndex = 16;
            this.lblFn.Text = "F( )";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(616, 344);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnTt);
            this.Controls.Add(this.button1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button btnTt;
        private System.Windows.Forms.Button btnXem;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.RadioButton radKhong;
        private System.Windows.Forms.RadioButton radCo;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label lblFn;
        private System.Windows.Forms.Button btnBang;
        private System.Windows.Forms.TextBox txtKq;
        private System.Windows.Forms.TextBox txtS2;
        private System.Windows.Forms.TextBox txtSn;
        private System.Windows.Forms.TextBox txtS1;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
    }
}

