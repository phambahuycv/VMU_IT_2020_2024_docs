using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cau4_t139_t140
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void Init()
        {
            string[] drivers;
            TreeNode node;
            drivers = Directory.GetLogicalDrives();
            foreach(string item in drivers)
            {
                node = new TreeNode(item);
                treeView1.Nodes.Add(node);
                node.Nodes.Add("Tam");
            }
        }
        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult thoat = MessageBox.Show("Bạn muốn thoát không?", "Thông báo", MessageBoxButtons.YesNo,MessageBoxIcon.Question);
            if (thoat == DialogResult.Yes)
                this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            treeView1.Nodes.Clear();
            Init();
            
        }

        private void treeView1_BeforeExpand(object sender, TreeViewCancelEventArgs e)
        {
            TreeNode node;
            string[] thuMuccon;
            node = e.Node;
            thuMuccon = Directory.GetDirectories(node.FullPath);
            node.Nodes.Clear();
            foreach (var item in thuMuccon)
            {
                TreeNode n = node.Nodes.Add(Path.GetFileName(item));
                n.Nodes.Add("Tam");
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Graphics g = this.CreateGraphics();
            Double startingPoint = (this.Width / 2) - (g.MeasureString(this.Text.Trim(), this.Font).Width / 2);
            Double widthOfASpace = g.MeasureString(" ", this.Font).Width;
            String tmp = " ";
            Double tmpWidth = 0;

            while ((tmpWidth + widthOfASpace) < startingPoint)
            {
                tmp += " ";
                tmpWidth += widthOfASpace;
            }

            this.Text = tmp + this.Text.Trim();
        }
    }
}
