using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.ComponentModel;

namespace vd9._2_t266
{
    class MyTextBox:TextBox
    {
        string strNewValue;
        [Description("Thuộc tính mới thêm")]
        public string NewValue
        {
            get
            {
                return strNewValue;
            }
            set
            {
                strNewValue = value;
            }
        }
    }
}
