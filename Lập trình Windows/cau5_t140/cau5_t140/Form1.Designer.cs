namespace cau5_t140
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
            this.components = new System.ComponentModel.Container();
            this.label1 = new System.Windows.Forms.Label();
            this.lblG = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.lblP = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.lblS = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.label1.Location = new System.Drawing.Point(103, 22);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(83, 24);
            this.label1.TabIndex = 0;
            this.label1.Text = "Đồng hồ";
            // 
            // lblG
            // 
            this.lblG.AutoSize = true;
            this.lblG.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lblG.Location = new System.Drawing.Point(30, 69);
            this.lblG.Name = "lblG";
            this.lblG.Size = new System.Drawing.Size(30, 31);
            this.lblG.TabIndex = 1;
            this.lblG.Text = "0";
            this.lblG.Click += new System.EventHandler(this.lblG_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 48F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.label3.Location = new System.Drawing.Point(78, 46);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(51, 73);
            this.label3.TabIndex = 2;
            this.label3.Text = ":";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // lblP
            // 
            this.lblP.AutoSize = true;
            this.lblP.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lblP.Location = new System.Drawing.Point(138, 69);
            this.lblP.Name = "lblP";
            this.lblP.Size = new System.Drawing.Size(30, 31);
            this.lblP.TabIndex = 3;
            this.lblP.Text = "0";
            this.lblP.Click += new System.EventHandler(this.lblP_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 48F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.label5.Location = new System.Drawing.Point(185, 46);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(51, 73);
            this.label5.TabIndex = 4;
            this.label5.Text = ":";
            this.label5.Click += new System.EventHandler(this.label5_Click);
            // 
            // lblS
            // 
            this.lblS.AutoSize = true;
            this.lblS.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.lblS.Location = new System.Drawing.Point(242, 69);
            this.lblS.Name = "lblS";
            this.lblS.Size = new System.Drawing.Size(30, 31);
            this.lblS.TabIndex = 5;
            this.lblS.Text = "0";
            this.lblS.Click += new System.EventHandler(this.lblS_Click);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(111, 193);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 6;
            this.button1.Text = "Thoát";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // timer1
            // 
            this.timer1.Interval = 1;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(301, 262);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.lblS);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.lblP);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lblG);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Bài tập";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblG;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label lblP;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label lblS;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Timer timer1;
    }
}

