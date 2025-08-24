using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BTW_4
{
    class Bai_4
    {
        static void Main(string[] args)
        {
            int x, n;
            double sum = 0f;
            Console.WriteLine("***TINH TONG CHUOI SO***");
            Console.Write("Nhap x: ");
            x = Convert.ToInt32(Console.ReadLine());
            Console.Write("Nhap n: ");
            n = Convert.ToInt32(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
                sum = sum + (Math.Pow(x, i) / gt(i));
            }
            sum = Math.Round(sum, 3);
            Console.WriteLine($"S({x},{n}) ={sum}");
            Console.ReadLine();
        }
        static double gt(float a)
        {
            double sum = 1f;
            if (a > 0)
            {
                for (int i = 1; i <= a; i++)
                {
                    sum = sum * i;
                }
            }
            return sum;
        }
    }
}
