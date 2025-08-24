namespace ThucDon
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
            this.label1 = new System.Windows.Forms.Label();
            this.txtTen = new System.Windows.Forms.TextBox();
            this.libA = new System.Windows.Forms.ListBox();
            this.button2 = new System.Windows.Forms.Button();
            this.libB = new System.Windows.Forms.ListBox();
            this.btnThem = new System.Windows.Forms.Button();
            this.btnAquaB = new System.Windows.Forms.Button();
            this.btnAllB = new System.Windows.Forms.Button();
            this.btnBquaA = new System.Windows.Forms.Button();
            this.btnAllA = new System.Windows.Forms.Button();
            this.btnXoa = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(43, 30);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(50, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Tên Món";
            // 
            // txtTen
            // 
            this.txtTen.Location = new System.Drawing.Point(111, 23);
            this.txtTen.Name = "txtTen";
            this.txtTen.Size = new System.Drawing.Size(179, 20);
            this.txtTen.TabIndex = 1;
            // 
            // libA
            // 
            this.libA.FormattingEnabled = true;
            this.libA.Location = new System.Drawing.Point(12, 75);
            this.libA.Name = "libA";
            this.libA.Size = new System.Drawing.Size(175, 264);
            this.libA.TabIndex = 2;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(361, 367);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 4;
            this.button2.Text = "Thoát";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // libB
            // 
            this.libB.FormattingEnabled = true;
            this.libB.Location = new System.Drawing.Point(261, 79);
            this.libB.Name = "libB";
            this.libB.Size = new System.Drawing.Size(175, 251);
            this.libB.TabIndex = 5;
            // 
            // btnThem
            // 
            this.btnThem.Location = new System.Drawing.Point(314, 23);
            this.btnThem.Name = "btnThem";
            this.btnThem.Size = new System.Drawing.Size(75, 23);
            this.btnThem.TabIndex = 6;
            this.btnThem.Text = "Thêm";
            this.btnThem.UseVisualStyleBackColor = true;
            this.btnThem.Click += new System.EventHandler(this.btnThem_Click);
            // 
            // btnAquaB
            // 
            this.btnAquaB.Location = new System.Drawing.Point(210, 104);
            this.btnAquaB.Name = "btnAquaB";
            this.btnAquaB.Size = new System.Drawing.Size(32, 23);
            this.btnAquaB.TabIndex = 7;
            this.btnAquaB.Text = ">";
            this.btnAquaB.UseVisualStyleBackColor = true;
            this.btnAquaB.Click += new System.EventHandler(this.btnAquaB_Click);
            // 
            // btnAllB
            // 
            this.btnAllB.Location = new System.Drawing.Point(210, 144);
            this.btnAllB.Name = "btnAllB";
            this.btnAllB.Size = new System.Drawing.Size(32, 23);
            this.btnAllB.TabIndex = 8;
            this.btnAllB.Text = ">>";
            this.btnAllB.UseVisualStyleBackColor = true;
            this.btnAllB.Click += new System.EventHandler(this.btnAllB_Click);
            // 
            // btnBquaA
            // 
            this.btnBquaA.Location = new System.Drawing.Point(210, 193);
            this.btnBquaA.Name = "btnBquaA";
            this.btnBquaA.Size = new System.Drawing.Size(32, 23);
            this.btnBquaA.TabIndex = 9;
            this.btnBquaA.Text = "<";
            this.btnBquaA.UseVisualStyleBackColor = true;
            this.btnBquaA.Click += new System.EventHandler(this.btnBquaA_Click);
            // 
            // btnAllA
            // 
            this.btnAllA.Location = new System.Drawing.Point(210, 232);
            this.btnAllA.Name = "btnAllA";
            this.btnAllA.Size = new System.Drawing.Size(32, 23);
            this.btnAllA.TabIndex = 10;
            this.btnAllA.Text = "<<";
            this.btnAllA.UseVisualStyleBackColor = true;
            this.btnAllA.Click += new System.EventHandler(this.btnAllA_Click);
            // 
            // btnXoa
            // 
            this.btnXoa.Location = new System.Drawing.Point(210, 278);
            this.btnXoa.Name = "btnXoa";
            this.btnXoa.Size = new System.Drawing.Size(32, 23);
            this.btnXoa.TabIndex = 11;
            this.btnXoa.Text = "X";
            this.btnXoa.UseVisualStyleBackColor = true;
            this.btnXoa.Click += new System.EventHandler(this.btnXoa_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(459, 402);
            this.Controls.Add(this.btnXoa);
            this.Controls.Add(this.btnAllA);
            this.Controls.Add(this.btnBquaA);
            this.Controls.Add(this.btnAllB);
            this.Controls.Add(this.btnAquaB);
            this.Controls.Add(this.btnThem);
            this.Controls.Add(this.libB);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.libA);
            this.Controls.Add(this.txtTen);
            this.Controls.Add(this.label1);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Thực Đơn";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtTen;
        private System.Windows.Forms.ListBox libA;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.ListBox libB;
        private System.Windows.Forms.Button btnThem;
        private System.Windows.Forms.Button btnAquaB;
        private System.Windows.Forms.Button btnAllB;
        private System.Windows.Forms.Button btnBquaA;
        private System.Windows.Forms.Button btnAllA;
        private System.Windows.Forms.Button btnXoa;
    }
}

