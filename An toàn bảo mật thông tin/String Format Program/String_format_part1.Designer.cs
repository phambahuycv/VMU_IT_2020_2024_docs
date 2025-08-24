
namespace String_Format_Program
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.grb_original_data = new System.Windows.Forms.GroupBox();
            this.txt_original_data = new System.Windows.Forms.TextBox();
            this.grb_result = new System.Windows.Forms.GroupBox();
            this.txt_result = new System.Windows.Forms.TextBox();
            this.btn_num_of_char_in_string = new System.Windows.Forms.Button();
            this.btn_capitally = new System.Windows.Forms.Button();
            this.btn_lowercase = new System.Windows.Forms.Button();
            this.btn_count_uppers = new System.Windows.Forms.Button();
            this.btn_count_lower = new System.Windows.Forms.Button();
            this.btn_count_digit = new System.Windows.Forms.Button();
            this.btn_reverse_string = new System.Windows.Forms.Button();
            this.btn_string_optimization = new System.Windows.Forms.Button();
            this.btn_first_appears = new System.Windows.Forms.Button();
            this.btn_final_appears = new System.Windows.Forms.Button();
            this.btn_chang_substring = new System.Windows.Forms.Button();
            this.btn_occurrences = new System.Windows.Forms.Button();
            this.btn_delete_substring = new System.Windows.Forms.Button();
            this.btn_split = new System.Windows.Forms.Button();
            this.btn_insert_string = new System.Windows.Forms.Button();
            this.btn_filter_extract = new System.Windows.Forms.Button();
            this.txt_first_appears = new System.Windows.Forms.TextBox();
            this.txt_final_appears = new System.Windows.Forms.TextBox();
            this.txt_occurrences = new System.Windows.Forms.TextBox();
            this.txt_split = new System.Windows.Forms.TextBox();
            this.txt_change_substring = new System.Windows.Forms.TextBox();
            this.txt_location_insert = new System.Windows.Forms.TextBox();
            this.txt_del_substring = new System.Windows.Forms.TextBox();
            this.txt_filter_extract_pos2 = new System.Windows.Forms.TextBox();
            this.txt_insert_string = new System.Windows.Forms.TextBox();
            this.txt_filter_extract_pos1 = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txt_origin_substring = new System.Windows.Forms.TextBox();
            this.grb_original_data.SuspendLayout();
            this.grb_result.SuspendLayout();
            this.SuspendLayout();
            // 
            // grb_original_data
            // 
            this.grb_original_data.BackColor = System.Drawing.Color.DeepSkyBlue;
            this.grb_original_data.Controls.Add(this.txt_original_data);
            this.grb_original_data.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.grb_original_data.ForeColor = System.Drawing.Color.PaleGreen;
            this.grb_original_data.Location = new System.Drawing.Point(12, 14);
            this.grb_original_data.Name = "grb_original_data";
            this.grb_original_data.Size = new System.Drawing.Size(390, 195);
            this.grb_original_data.TabIndex = 0;
            this.grb_original_data.TabStop = false;
            this.grb_original_data.Text = "Original data";
            // 
            // txt_original_data
            // 
            this.txt_original_data.Dock = System.Windows.Forms.DockStyle.Fill;
            this.txt_original_data.Location = new System.Drawing.Point(3, 23);
            this.txt_original_data.Multiline = true;
            this.txt_original_data.Name = "txt_original_data";
            this.txt_original_data.Size = new System.Drawing.Size(384, 169);
            this.txt_original_data.TabIndex = 0;
            // 
            // grb_result
            // 
            this.grb_result.BackColor = System.Drawing.Color.DeepSkyBlue;
            this.grb_result.Controls.Add(this.txt_result);
            this.grb_result.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.grb_result.ForeColor = System.Drawing.Color.PaleGreen;
            this.grb_result.Location = new System.Drawing.Point(420, 14);
            this.grb_result.Name = "grb_result";
            this.grb_result.Size = new System.Drawing.Size(390, 195);
            this.grb_result.TabIndex = 1;
            this.grb_result.TabStop = false;
            this.grb_result.Text = "Result";
            // 
            // txt_result
            // 
            this.txt_result.BackColor = System.Drawing.Color.MediumSlateBlue;
            this.txt_result.Dock = System.Windows.Forms.DockStyle.Fill;
            this.txt_result.ForeColor = System.Drawing.Color.MintCream;
            this.txt_result.Location = new System.Drawing.Point(3, 23);
            this.txt_result.Multiline = true;
            this.txt_result.Name = "txt_result";
            this.txt_result.ReadOnly = true;
            this.txt_result.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.txt_result.Size = new System.Drawing.Size(384, 169);
            this.txt_result.TabIndex = 0;
            // 
            // btn_num_of_char_in_string
            // 
            this.btn_num_of_char_in_string.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_num_of_char_in_string.Location = new System.Drawing.Point(12, 227);
            this.btn_num_of_char_in_string.Name = "btn_num_of_char_in_string";
            this.btn_num_of_char_in_string.Size = new System.Drawing.Size(390, 35);
            this.btn_num_of_char_in_string.TabIndex = 2;
            this.btn_num_of_char_in_string.Text = "Number &of characters in string";
            this.btn_num_of_char_in_string.UseVisualStyleBackColor = true;
            this.btn_num_of_char_in_string.Click += new System.EventHandler(this.btn_num_of_char_in_string_Click);
            // 
            // btn_capitally
            // 
            this.btn_capitally.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_capitally.Location = new System.Drawing.Point(12, 269);
            this.btn_capitally.Name = "btn_capitally";
            this.btn_capitally.Size = new System.Drawing.Size(390, 35);
            this.btn_capitally.TabIndex = 3;
            this.btn_capitally.Text = "&Capitally";
            this.btn_capitally.UseVisualStyleBackColor = true;
            this.btn_capitally.Click += new System.EventHandler(this.btn_capitally_Click);
            // 
            // btn_lowercase
            // 
            this.btn_lowercase.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_lowercase.Location = new System.Drawing.Point(12, 311);
            this.btn_lowercase.Name = "btn_lowercase";
            this.btn_lowercase.Size = new System.Drawing.Size(390, 35);
            this.btn_lowercase.TabIndex = 4;
            this.btn_lowercase.Text = "Print &lowercase";
            this.btn_lowercase.UseVisualStyleBackColor = true;
            this.btn_lowercase.Click += new System.EventHandler(this.btn_lowercase_Click);
            // 
            // btn_count_uppers
            // 
            this.btn_count_uppers.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_count_uppers.Location = new System.Drawing.Point(12, 353);
            this.btn_count_uppers.Name = "btn_count_uppers";
            this.btn_count_uppers.Size = new System.Drawing.Size(390, 35);
            this.btn_count_uppers.TabIndex = 5;
            this.btn_count_uppers.Text = "Count number of &Uppercase";
            this.btn_count_uppers.UseVisualStyleBackColor = true;
            this.btn_count_uppers.Click += new System.EventHandler(this.btn_count_uppers_Click);
            // 
            // btn_count_lower
            // 
            this.btn_count_lower.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_count_lower.Location = new System.Drawing.Point(12, 395);
            this.btn_count_lower.Name = "btn_count_lower";
            this.btn_count_lower.Size = new System.Drawing.Size(390, 35);
            this.btn_count_lower.TabIndex = 6;
            this.btn_count_lower.Text = "Coun&t number of Lowercase";
            this.btn_count_lower.UseVisualStyleBackColor = true;
            this.btn_count_lower.Click += new System.EventHandler(this.btn_count_lower_Click);
            // 
            // btn_count_digit
            // 
            this.btn_count_digit.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_count_digit.Location = new System.Drawing.Point(12, 437);
            this.btn_count_digit.Name = "btn_count_digit";
            this.btn_count_digit.Size = new System.Drawing.Size(390, 35);
            this.btn_count_digit.TabIndex = 7;
            this.btn_count_digit.Text = "Count number of &Digit";
            this.btn_count_digit.UseVisualStyleBackColor = true;
            this.btn_count_digit.Click += new System.EventHandler(this.btn_count_digit_Click);
            // 
            // btn_reverse_string
            // 
            this.btn_reverse_string.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_reverse_string.Location = new System.Drawing.Point(12, 479);
            this.btn_reverse_string.Name = "btn_reverse_string";
            this.btn_reverse_string.Size = new System.Drawing.Size(390, 35);
            this.btn_reverse_string.TabIndex = 8;
            this.btn_reverse_string.Text = "&Reverse string";
            this.btn_reverse_string.UseVisualStyleBackColor = true;
            this.btn_reverse_string.Click += new System.EventHandler(this.btn_reverse_string_Click);
            // 
            // btn_string_optimization
            // 
            this.btn_string_optimization.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_string_optimization.Location = new System.Drawing.Point(12, 521);
            this.btn_string_optimization.Name = "btn_string_optimization";
            this.btn_string_optimization.Size = new System.Drawing.Size(390, 35);
            this.btn_string_optimization.TabIndex = 9;
            this.btn_string_optimization.Text = "String &Optimization";
            this.btn_string_optimization.UseVisualStyleBackColor = true;
            this.btn_string_optimization.Click += new System.EventHandler(this.btn_string_optimization_Click);
            // 
            // btn_first_appears
            // 
            this.btn_first_appears.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_first_appears.Location = new System.Drawing.Point(420, 227);
            this.btn_first_appears.Name = "btn_first_appears";
            this.btn_first_appears.Size = new System.Drawing.Size(246, 35);
            this.btn_first_appears.TabIndex = 10;
            this.btn_first_appears.Text = "Find the fir&st appears position";
            this.btn_first_appears.UseVisualStyleBackColor = true;
            this.btn_first_appears.Click += new System.EventHandler(this.btn_first_appears_Click);
            // 
            // btn_final_appears
            // 
            this.btn_final_appears.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_final_appears.Location = new System.Drawing.Point(420, 269);
            this.btn_final_appears.Name = "btn_final_appears";
            this.btn_final_appears.Size = new System.Drawing.Size(246, 35);
            this.btn_final_appears.TabIndex = 12;
            this.btn_final_appears.Text = "Find the fi&nal appears position\r\n";
            this.btn_final_appears.UseVisualStyleBackColor = true;
            this.btn_final_appears.Click += new System.EventHandler(this.btn_final_appears_Click);
            // 
            // btn_chang_substring
            // 
            this.btn_chang_substring.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_chang_substring.Location = new System.Drawing.Point(420, 395);
            this.btn_chang_substring.Name = "btn_chang_substring";
            this.btn_chang_substring.Size = new System.Drawing.Size(134, 35);
            this.btn_chang_substring.TabIndex = 18;
            this.btn_chang_substring.Text = "Change su&bstring";
            this.btn_chang_substring.UseVisualStyleBackColor = true;
            this.btn_chang_substring.Click += new System.EventHandler(this.btn_chang_substring_Click);
            // 
            // btn_occurrences
            // 
            this.btn_occurrences.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_occurrences.Location = new System.Drawing.Point(420, 311);
            this.btn_occurrences.Name = "btn_occurrences";
            this.btn_occurrences.Size = new System.Drawing.Size(246, 35);
            this.btn_occurrences.TabIndex = 14;
            this.btn_occurrences.Text = "Count the number of &occurrences\r\n";
            this.btn_occurrences.UseVisualStyleBackColor = true;
            this.btn_occurrences.Click += new System.EventHandler(this.btn_occurrences_Click);
            // 
            // btn_delete_substring
            // 
            this.btn_delete_substring.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_delete_substring.Location = new System.Drawing.Point(420, 437);
            this.btn_delete_substring.Name = "btn_delete_substring";
            this.btn_delete_substring.Size = new System.Drawing.Size(246, 35);
            this.btn_delete_substring.TabIndex = 21;
            this.btn_delete_substring.Text = "Del&ete substring";
            this.btn_delete_substring.UseVisualStyleBackColor = true;
            this.btn_delete_substring.Click += new System.EventHandler(this.btn_delete_substring_Click);
            // 
            // btn_split
            // 
            this.btn_split.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_split.Location = new System.Drawing.Point(420, 353);
            this.btn_split.Name = "btn_split";
            this.btn_split.Size = new System.Drawing.Size(246, 35);
            this.btn_split.TabIndex = 16;
            this.btn_split.Text = "Split &word";
            this.btn_split.UseVisualStyleBackColor = true;
            this.btn_split.Click += new System.EventHandler(this.btn_split_Click);
            // 
            // btn_insert_string
            // 
            this.btn_insert_string.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_insert_string.Location = new System.Drawing.Point(420, 479);
            this.btn_insert_string.Name = "btn_insert_string";
            this.btn_insert_string.Size = new System.Drawing.Size(119, 35);
            this.btn_insert_string.TabIndex = 23;
            this.btn_insert_string.Text = "In&sert String";
            this.btn_insert_string.UseVisualStyleBackColor = true;
            this.btn_insert_string.Click += new System.EventHandler(this.btn_insert_string_Click);
            // 
            // btn_filter_extract
            // 
            this.btn_filter_extract.ForeColor = System.Drawing.Color.DarkBlue;
            this.btn_filter_extract.Location = new System.Drawing.Point(420, 521);
            this.btn_filter_extract.Name = "btn_filter_extract";
            this.btn_filter_extract.Size = new System.Drawing.Size(99, 35);
            this.btn_filter_extract.TabIndex = 26;
            this.btn_filter_extract.Text = "Filte&r Extract";
            this.btn_filter_extract.UseVisualStyleBackColor = true;
            this.btn_filter_extract.Click += new System.EventHandler(this.btn_filter_extract_Click);
            // 
            // txt_first_appears
            // 
            this.txt_first_appears.Location = new System.Drawing.Point(672, 227);
            this.txt_first_appears.Multiline = true;
            this.txt_first_appears.Name = "txt_first_appears";
            this.txt_first_appears.Size = new System.Drawing.Size(138, 35);
            this.txt_first_appears.TabIndex = 11;
            // 
            // txt_final_appears
            // 
            this.txt_final_appears.Location = new System.Drawing.Point(672, 269);
            this.txt_final_appears.Multiline = true;
            this.txt_final_appears.Name = "txt_final_appears";
            this.txt_final_appears.Size = new System.Drawing.Size(138, 35);
            this.txt_final_appears.TabIndex = 13;
            // 
            // txt_occurrences
            // 
            this.txt_occurrences.Location = new System.Drawing.Point(672, 311);
            this.txt_occurrences.Multiline = true;
            this.txt_occurrences.Name = "txt_occurrences";
            this.txt_occurrences.Size = new System.Drawing.Size(138, 35);
            this.txt_occurrences.TabIndex = 15;
            // 
            // txt_split
            // 
            this.txt_split.Location = new System.Drawing.Point(672, 353);
            this.txt_split.Multiline = true;
            this.txt_split.Name = "txt_split";
            this.txt_split.Size = new System.Drawing.Size(138, 35);
            this.txt_split.TabIndex = 17;
            // 
            // txt_change_substring
            // 
            this.txt_change_substring.Location = new System.Drawing.Point(672, 395);
            this.txt_change_substring.Multiline = true;
            this.txt_change_substring.Name = "txt_change_substring";
            this.txt_change_substring.Size = new System.Drawing.Size(138, 35);
            this.txt_change_substring.TabIndex = 20;
            // 
            // txt_location_insert
            // 
            this.txt_location_insert.Location = new System.Drawing.Point(740, 479);
            this.txt_location_insert.Multiline = true;
            this.txt_location_insert.Name = "txt_location_insert";
            this.txt_location_insert.Size = new System.Drawing.Size(70, 35);
            this.txt_location_insert.TabIndex = 25;
            // 
            // txt_del_substring
            // 
            this.txt_del_substring.Location = new System.Drawing.Point(672, 437);
            this.txt_del_substring.Multiline = true;
            this.txt_del_substring.Name = "txt_del_substring";
            this.txt_del_substring.Size = new System.Drawing.Size(138, 35);
            this.txt_del_substring.TabIndex = 22;
            // 
            // txt_filter_extract_pos2
            // 
            this.txt_filter_extract_pos2.Location = new System.Drawing.Point(740, 521);
            this.txt_filter_extract_pos2.Multiline = true;
            this.txt_filter_extract_pos2.Name = "txt_filter_extract_pos2";
            this.txt_filter_extract_pos2.Size = new System.Drawing.Size(70, 35);
            this.txt_filter_extract_pos2.TabIndex = 28;
            // 
            // txt_insert_string
            // 
            this.txt_insert_string.Location = new System.Drawing.Point(545, 479);
            this.txt_insert_string.Multiline = true;
            this.txt_insert_string.Name = "txt_insert_string";
            this.txt_insert_string.Size = new System.Drawing.Size(121, 35);
            this.txt_insert_string.TabIndex = 24;
            // 
            // txt_filter_extract_pos1
            // 
            this.txt_filter_extract_pos1.Location = new System.Drawing.Point(596, 521);
            this.txt_filter_extract_pos1.Multiline = true;
            this.txt_filter_extract_pos1.Name = "txt_filter_extract_pos1";
            this.txt_filter_extract_pos1.Size = new System.Drawing.Size(70, 35);
            this.txt_filter_extract_pos1.TabIndex = 27;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.ForeColor = System.Drawing.Color.Yellow;
            this.label1.Location = new System.Drawing.Point(672, 488);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(62, 17);
            this.label1.TabIndex = 3;
            this.label1.Text = "Location";
            // 
            // label3
            // 
            this.label3.ForeColor = System.Drawing.Color.Yellow;
            this.label3.Location = new System.Drawing.Point(525, 521);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(65, 35);
            this.label3.TabIndex = 3;
            this.label3.Text = "Location 1";
            this.label3.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // label2
            // 
            this.label2.ForeColor = System.Drawing.Color.Yellow;
            this.label2.Location = new System.Drawing.Point(669, 521);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 35);
            this.label2.TabIndex = 3;
            this.label2.Text = "Location 2";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // txt_origin_substring
            // 
            this.txt_origin_substring.Location = new System.Drawing.Point(560, 395);
            this.txt_origin_substring.Multiline = true;
            this.txt_origin_substring.Name = "txt_origin_substring";
            this.txt_origin_substring.Size = new System.Drawing.Size(106, 35);
            this.txt_origin_substring.TabIndex = 19;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.DeepSkyBlue;
            this.ClientSize = new System.Drawing.Size(822, 570);
            this.Controls.Add(this.txt_origin_substring);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txt_filter_extract_pos2);
            this.Controls.Add(this.txt_split);
            this.Controls.Add(this.txt_del_substring);
            this.Controls.Add(this.txt_final_appears);
            this.Controls.Add(this.txt_filter_extract_pos1);
            this.Controls.Add(this.txt_insert_string);
            this.Controls.Add(this.txt_location_insert);
            this.Controls.Add(this.txt_occurrences);
            this.Controls.Add(this.txt_change_substring);
            this.Controls.Add(this.txt_first_appears);
            this.Controls.Add(this.btn_filter_extract);
            this.Controls.Add(this.btn_string_optimization);
            this.Controls.Add(this.btn_insert_string);
            this.Controls.Add(this.btn_reverse_string);
            this.Controls.Add(this.btn_split);
            this.Controls.Add(this.btn_count_uppers);
            this.Controls.Add(this.btn_delete_substring);
            this.Controls.Add(this.btn_count_digit);
            this.Controls.Add(this.btn_occurrences);
            this.Controls.Add(this.btn_lowercase);
            this.Controls.Add(this.btn_chang_substring);
            this.Controls.Add(this.btn_count_lower);
            this.Controls.Add(this.btn_final_appears);
            this.Controls.Add(this.btn_capitally);
            this.Controls.Add(this.btn_first_appears);
            this.Controls.Add(this.btn_num_of_char_in_string);
            this.Controls.Add(this.grb_result);
            this.Controls.Add(this.grb_original_data);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "String format program";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.Load += new System.EventHandler(this.Form1_Load);
            this.grb_original_data.ResumeLayout(false);
            this.grb_original_data.PerformLayout();
            this.grb_result.ResumeLayout(false);
            this.grb_result.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox grb_original_data;
        private System.Windows.Forms.TextBox txt_original_data;
        private System.Windows.Forms.GroupBox grb_result;
        private System.Windows.Forms.Button btn_num_of_char_in_string;
        private System.Windows.Forms.Button btn_capitally;
        private System.Windows.Forms.Button btn_lowercase;
        private System.Windows.Forms.Button btn_count_uppers;
        private System.Windows.Forms.Button btn_count_lower;
        private System.Windows.Forms.Button btn_count_digit;
        private System.Windows.Forms.Button btn_reverse_string;
        private System.Windows.Forms.Button btn_string_optimization;
        private System.Windows.Forms.Button btn_first_appears;
        private System.Windows.Forms.Button btn_final_appears;
        private System.Windows.Forms.Button btn_chang_substring;
        private System.Windows.Forms.Button btn_occurrences;
        private System.Windows.Forms.Button btn_delete_substring;
        private System.Windows.Forms.Button btn_split;
        private System.Windows.Forms.Button btn_insert_string;
        private System.Windows.Forms.Button btn_filter_extract;
        private System.Windows.Forms.TextBox txt_first_appears;
        private System.Windows.Forms.TextBox txt_final_appears;
        private System.Windows.Forms.TextBox txt_occurrences;
        private System.Windows.Forms.TextBox txt_split;
        private System.Windows.Forms.TextBox txt_change_substring;
        private System.Windows.Forms.TextBox txt_location_insert;
        private System.Windows.Forms.TextBox txt_del_substring;
        private System.Windows.Forms.TextBox txt_filter_extract_pos2;
        private System.Windows.Forms.TextBox txt_insert_string;
        private System.Windows.Forms.TextBox txt_filter_extract_pos1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txt_result;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txt_origin_substring;
    }
}

