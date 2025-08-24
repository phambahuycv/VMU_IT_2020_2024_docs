namespace PTB2
{
    partial class UC_Giai
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.btnhoantat = new System.Windows.Forms.Button();
            this.btnxemhd = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.cbbchonno = new System.Windows.Forms.ComboBox();
            this.txtc = new System.Windows.Forms.TextBox();
            this.txtb = new System.Windows.Forms.TextBox();
            this.txta = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(72, 91);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(248, 17);
            this.label8.TabIndex = 29;
            this.label8.Text = "............................................................";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(51, 239);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(95, 17);
            this.label7.TabIndex = 28;
            this.label7.Text = "Chọn nghiệm:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(100, 198);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(60, 17);
            this.label6.TabIndex = 27;
            this.label6.Text = "Hệ số c:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(100, 165);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(61, 17);
            this.label5.TabIndex = 26;
            this.label5.Text = "Hệ số b:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(100, 126);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(61, 17);
            this.label4.TabIndex = 25;
            this.label4.Text = "Hệ số a:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(147, 76);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(83, 17);
            this.label3.TabIndex = 24;
            this.label3.Text = "ax2+bx+c=0";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(51, 59);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(143, 17);
            this.label2.TabIndex = 23;
            this.label2.Text = "Phương trình bậc hai:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(115, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(227, 25);
            this.label1.TabIndex = 22;
            this.label1.Text = "Giải phương trình bậc hai";
            // 
            // btnhoantat
            // 
            this.btnhoantat.Location = new System.Drawing.Point(245, 360);
            this.btnhoantat.Name = "btnhoantat";
            this.btnhoantat.Size = new System.Drawing.Size(75, 36);
            this.btnhoantat.TabIndex = 21;
            this.btnhoantat.Text = "Hoàn tất";
            this.btnhoantat.UseVisualStyleBackColor = true;
            // 
            // btnxemhd
            // 
            this.btnxemhd.Location = new System.Drawing.Point(86, 360);
            this.btnxemhd.Name = "btnxemhd";
            this.btnxemhd.Size = new System.Drawing.Size(144, 36);
            this.btnxemhd.TabIndex = 20;
            this.btnxemhd.Text = "Xem hướng dẫn";
            this.btnxemhd.UseVisualStyleBackColor = true;
            this.btnxemhd.Click += new System.EventHandler(this.btnxemhd_Click);
            // 
            // panel1
            // 
            this.panel1.Location = new System.Drawing.Point(54, 276);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(318, 64);
            this.panel1.TabIndex = 19;
            // 
            // cbbchonno
            // 
            this.cbbchonno.FormattingEnabled = true;
            this.cbbchonno.Items.AddRange(new object[] {
            "Phương trình vô nghiệm",
            "Phương trình một nghiệm",
            "Phương trình hai nghiệm"});
            this.cbbchonno.Location = new System.Drawing.Point(150, 236);
            this.cbbchonno.Name = "cbbchonno";
            this.cbbchonno.Size = new System.Drawing.Size(222, 24);
            this.cbbchonno.TabIndex = 18;
            this.cbbchonno.SelectedIndexChanged += new System.EventHandler(this.cbbchonno_SelectedIndexChanged);
            // 
            // txtc
            // 
            this.txtc.Location = new System.Drawing.Point(167, 198);
            this.txtc.Name = "txtc";
            this.txtc.Size = new System.Drawing.Size(125, 22);
            this.txtc.TabIndex = 17;
            // 
            // txtb
            // 
            this.txtb.Location = new System.Drawing.Point(167, 160);
            this.txtb.Name = "txtb";
            this.txtb.Size = new System.Drawing.Size(125, 22);
            this.txtb.TabIndex = 16;
            // 
            // txta
            // 
            this.txta.Location = new System.Drawing.Point(167, 121);
            this.txta.Name = "txta";
            this.txta.Size = new System.Drawing.Size(125, 22);
            this.txta.TabIndex = 15;
            // 
            // UC_Giai
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnhoantat);
            this.Controls.Add(this.btnxemhd);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.cbbchonno);
            this.Controls.Add(this.txtc);
            this.Controls.Add(this.txtb);
            this.Controls.Add(this.txta);
            this.Name = "UC_Giai";
            this.Size = new System.Drawing.Size(422, 410);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnhoantat;
        private System.Windows.Forms.Button btnxemhd;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.ComboBox cbbchonno;
        private System.Windows.Forms.TextBox txtc;
        private System.Windows.Forms.TextBox txtb;
        private System.Windows.Forms.TextBox txta;
    }
}
