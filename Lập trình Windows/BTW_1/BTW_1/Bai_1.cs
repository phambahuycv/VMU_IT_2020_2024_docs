using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BTW_1
{
    class Bai_1
    {
        static void Main(string[] args)
        {
            float a, b;
            Console.WriteLine("Chieu dai a:");
            a = Convert.ToSingle(Console.ReadLine());
            Console.WriteLine("Chieu rong b:");
            b = Convert.ToSingle(Console.ReadLine());
            if (a > 0 && b > 0)
            {
                float ChuVi = 2 * (a + b);
                float DienTich = a * b;
                Console.WriteLine(" Chu Vi = " + ChuVi);
                Console.WriteLine(" Dien Tich = " + DienTich);
            }
            else
            {
                Console.WriteLine(" Chieu dai va chieu rong phai >0");
            }
        }
    }
}
