using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BTW_5
{
    class Bai_5
    {
        static void Main(string[] args)
        {
            int n;
            Console.Write("Nhap vao n: ");
            n = Convert.ToInt32(Console.ReadLine());
            int dem = 0;
            for (int i = 1; i <= Math.Sqrt(n); i++)
            {
                if (n % i == 0)
                {
                    dem++;
                }
            }
            if (dem > 2)
            {
                Console.WriteLine($"{n} khong phai so nguyen to");
            }
            else
                Console.WriteLine($"{n} la so nguyen to");
            int s = 0;
            for (int i = 1; i <= n/2; i++)
            {
                if (n % i == 0)
                {
                    s += i;
                }
            }
            if (s == n)
            {
                Console.WriteLine($"{n} la so hoan hao");
            }
            else
                Console.WriteLine($"{n} khong la so hoan hao");
            int t = (int)Math.Sqrt(n);
            if (t * t == n)
            {
                Console.WriteLine($"{n} la so chinh phuong");
            }
            else
                Console.WriteLine($"{n} khong la so chinh phuong");
        }
   }
 }
