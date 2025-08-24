namespace _87726_Pham_Ba_Huy
{
    partial class Frm1
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
            this.grb1 = new System.Windows.Forms.GroupBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtnhap1 = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.txtnhap2 = new System.Windows.Forms.TextBox();
            this.txtnhap3 = new System.Windows.Forms.TextBox();
            this.btntim = new System.Windows.Forms.Button();
            this.grb2 = new System.Windows.Forms.GroupBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.txtxuat1 = new System.Windows.Forms.TextBox();
            this.txtxuat2 = new System.Windows.Forms.TextBox();
            this.grb1.SuspendLayout();
            this.grb2.SuspendLayout();
            this.SuspendLayout();
            // 
            // grb1
            // 
            this.grb1.Controls.Add(this.txtnhap3);
            this.grb1.Controls.Add(this.txtnhap2);
            this.grb1.Controls.Add(this.label3);
            this.grb1.Controls.Add(this.label2);
            this.grb1.Controls.Add(this.txtnhap1);
            this.grb1.Controls.Add(this.label1);
            this.grb1.ForeColor = System.Drawing.Color.Blue;
            this.grb1.Location = new System.Drawing.Point(29, 12);
            this.grb1.Name = "grb1";
            this.grb1.Size = new System.Drawing.Size(281, 82);
            this.grb1.TabIndex = 0;
            this.grb1.TabStop = false;
            this.grb1.Text = "Số nhập vào";
            this.grb1.Enter += new System.EventHandler(this.S_Enter);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.ForeColor = System.Drawing.Color.Black;
            this.label1.Location = new System.Drawing.Point(17, 46);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(14, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "A";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // txtnhap1
            // 
            this.txtnhap1.Location = new System.Drawing.Point(38, 39);
            this.txtnhap1.Name = "txtnhap1";
            this.txtnhap1.Size = new System.Drawing.Size(59, 20);
            this.txtnhap1.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.ForeColor = System.Drawing.Color.Black;
            this.label2.Location = new System.Drawing.Point(103, 42);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(14, 13);
            this.label2.TabIndex = 0;
            this.label2.Text = "B";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.ForeColor = System.Drawing.Color.Black;
            this.label3.Location = new System.Drawing.Point(188, 43);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(14, 13);
            this.label3.TabIndex = 0;
            this.label3.Text = "C";
            // 
            // txtnhap2
            // 
            this.txtnhap2.Location = new System.Drawing.Point(123, 39);
            this.txtnhap2.Name = "txtnhap2";
            this.txtnhap2.Size = new System.Drawing.Size(59, 20);
            this.txtnhap2.TabIndex = 2;
            // 
            // txtnhap3
            // 
            this.txtnhap3.Location = new System.Drawing.Point(208, 40);
            this.txtnhap3.Name = "txtnhap3";
            this.txtnhap3.Size = new System.Drawing.Size(59, 20);
            this.txtnhap3.TabIndex = 3;
            // 
            // btntim
            // 
            this.btntim.Location = new System.Drawing.Point(123, 133);
            this.btntim.Name = "btntim";
            this.btntim.Size = new System.Drawing.Size(50, 27);
            this.btntim.TabIndex = 4;
            this.btntim.Text = "Tìm";
            this.btntim.UseVisualStyleBackColor = true;
            this.btntim.Click += new System.EventHandler(this.btntim_Click);
            // 
            // grb2
            // 
            this.grb2.Controls.Add(this.txtxuat2);
            this.grb2.Controls.Add(this.txtxuat1);
            this.grb2.Controls.Add(this.label5);
            this.grb2.Controls.Add(this.label4);
            this.grb2.ForeColor = System.Drawing.Color.Blue;
            this.grb2.Location = new System.Drawing.Point(39, 191);
            this.grb2.Name = "grb2";
            this.grb2.Size = new System.Drawing.Size(270, 76);
            this.grb2.TabIndex = 0;
            this.grb2.TabStop = false;
            this.grb2.Text = "Kết quả";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.ForeColor = System.Drawing.Color.Red;
            this.label4.Location = new System.Drawing.Point(-3, 34);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(61, 13);
            this.label4.TabIndex = 0;
            this.label4.Text = "Số lớn nhất";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.ForeColor = System.Drawing.Color.Red;
            this.label5.Location = new System.Drawing.Point(127, 34);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(65, 13);
            this.label5.TabIndex = 0;
            this.label5.Text = "Số nhỏ nhất";
            // 
            // txtxuat1
            // 
            this.txtxuat1.Enabled = false;
            this.txtxuat1.Location = new System.Drawing.Point(62, 27);
            this.txtxuat1.Name = "txtxuat1";
            this.txtxuat1.Size = new System.Drawing.Size(59, 20);
            this.txtxuat1.TabIndex = 0;
            // 
            // txtxuat2
            // 
            this.txtxuat2.Enabled = false;
            this.txtxuat2.Location = new System.Drawing.Point(198, 31);
            this.txtxuat2.Name = "txtxuat2";
            this.txtxuat2.Size = new System.Drawing.Size(59, 20);
            this.txtxuat2.TabIndex = 0;
            // 
            // Frm1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(324, 328);
            this.Controls.Add(this.grb2);
            this.Controls.Add(this.btntim);
            this.Controls.Add(this.grb1);
            this.Name = "Frm1";
            this.Text = "Chương trình tìm số lớn nhất số nhỏ nhất của hai số";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.grb1.ResumeLayout(false);
            this.grb1.PerformLayout();
            this.grb2.ResumeLayout(false);
            this.grb2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox grb1;
        private System.Windows.Forms.TextBox txtnhap3;
        private System.Windows.Forms.TextBox txtnhap2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtnhap1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btntim;
        private System.Windows.Forms.GroupBox grb2;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtxuat2;
        private System.Windows.Forms.TextBox txtxuat1;
    }
}

