namespace PTB2
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
            this.spcptb2 = new System.Windows.Forms.SplitContainer();
            this.btngiai = new System.Windows.Forms.Button();
            this.btnhuongdan = new System.Windows.Forms.Button();
            this.btntrove = new System.Windows.Forms.Button();
            this.uC_Huongdan1 = new PTB2.UC_Huongdan();
            this.uC_Giai1 = new PTB2.UC_Giai();
            ((System.ComponentModel.ISupportInitialize)(this.spcptb2)).BeginInit();
            this.spcptb2.Panel1.SuspendLayout();
            this.spcptb2.Panel2.SuspendLayout();
            this.spcptb2.SuspendLayout();
            this.SuspendLayout();
            // 
            // spcptb2
            // 
            this.spcptb2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.spcptb2.Location = new System.Drawing.Point(0, 0);
            this.spcptb2.Name = "spcptb2";
            // 
            // spcptb2.Panel1
            // 
            this.spcptb2.Panel1.Controls.Add(this.btngiai);
            this.spcptb2.Panel1.Controls.Add(this.btnhuongdan);
            // 
            // spcptb2.Panel2
            // 
            this.spcptb2.Panel2.Controls.Add(this.uC_Huongdan1);
            this.spcptb2.Panel2.Controls.Add(this.btntrove);
            this.spcptb2.Panel2.Controls.Add(this.uC_Giai1);
            this.spcptb2.Panel2.Paint += new System.Windows.Forms.PaintEventHandler(this.spcptb2_Panel2_Paint);
            this.spcptb2.Size = new System.Drawing.Size(634, 439);
            this.spcptb2.SplitterDistance = 151;
            this.spcptb2.TabIndex = 0;
            // 
            // btngiai
            // 
            this.btngiai.Location = new System.Drawing.Point(12, 107);
            this.btngiai.Name = "btngiai";
            this.btngiai.Size = new System.Drawing.Size(127, 53);
            this.btngiai.TabIndex = 0;
            this.btngiai.Text = "Giải phương trình bậc hai";
            this.btngiai.UseVisualStyleBackColor = true;
            this.btngiai.Click += new System.EventHandler(this.btngiai_Click);
            // 
            // btnhuongdan
            // 
            this.btnhuongdan.Location = new System.Drawing.Point(13, 225);
            this.btnhuongdan.Name = "btnhuongdan";
            this.btnhuongdan.Size = new System.Drawing.Size(118, 40);
            this.btnhuongdan.TabIndex = 1;
            this.btnhuongdan.Text = "Hướng dẫn";
            this.btnhuongdan.UseVisualStyleBackColor = true;
            this.btnhuongdan.Click += new System.EventHandler(this.btnhuongdan_Click);
            // 
            // btntrove
            // 
            this.btntrove.Location = new System.Drawing.Point(339, 364);
            this.btntrove.Name = "btntrove";
            this.btntrove.Size = new System.Drawing.Size(75, 45);
            this.btntrove.TabIndex = 0;
            this.btntrove.Text = "Trở về";
            this.btntrove.UseVisualStyleBackColor = true;
            this.btntrove.Click += new System.EventHandler(this.btntrove_Click);
            // 
            // uC_Huongdan1
            // 
            this.uC_Huongdan1.Location = new System.Drawing.Point(11, 12);
            this.uC_Huongdan1.Name = "uC_Huongdan1";
            this.uC_Huongdan1.Size = new System.Drawing.Size(429, 340);
            this.uC_Huongdan1.TabIndex = 2;
            // 
            // uC_Giai1
            // 
            this.uC_Giai1.Location = new System.Drawing.Point(18, 12);
            this.uC_Giai1.Name = "uC_Giai1";
            this.uC_Giai1.Size = new System.Drawing.Size(422, 410);
            this.uC_Giai1.TabIndex = 1;
            this.uC_Giai1.Load += new System.EventHandler(this.uC_Giai1_Load);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(634, 439);
            this.Controls.Add(this.spcptb2);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.spcptb2.Panel1.ResumeLayout(false);
            this.spcptb2.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.spcptb2)).EndInit();
            this.spcptb2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.SplitContainer spcptb2;
        private System.Windows.Forms.Button btngiai;
        private System.Windows.Forms.Button btnhuongdan;
        private System.Windows.Forms.Button btntrove;
        private UC_Huongdan uC_Huongdan1;
        private UC_Giai uC_Giai1;
    }
}

