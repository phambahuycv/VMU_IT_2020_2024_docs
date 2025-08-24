using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BTW_3
{
    class Bai_3
    {
        static void Main(string[] args)
        {
            Console.Write("Nhap so a: "); int a = int.Parse(Console.ReadLine());
            Console.Write("Nhap so b: "); int b = int.Parse(Console.ReadLine());
            Console.Write("Nhap so c: "); int c = int.Parse(Console.ReadLine());
            if (a > 0 && b > 0 && c > 0)
            {
                if (a + b >= c || a + c >= b || b + c >= a)
                {
                    if ((a == b && a != c) || (b == c && b != a) || (c == a && c != b))
                        Console.WriteLine("Tam giac can");
                    else if (a == b && a == c && c == b)
                        Console.WriteLine("Tam giac deu ");
                    else if (a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b)
                        Console.WriteLine("Tam giac vuong");
                    else if (a * a > b * b + c * c || b * b > a * a + c * c || c * c > a * a + b * b)
                        Console.WriteLine("Tam giac tu");
                    else
                        Console.WriteLine("Tam giac nhon");
                }else
                Console.WriteLine("Khong co tam giac");
                Console.ReadLine();
            }
        }
    }
}
