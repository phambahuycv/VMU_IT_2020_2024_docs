using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BTW_2
{
    class Bai_2
    {
        static void Main(string[] args)
        {
            int a, b, c, tam;
            Console.Write("So 1: ");     a = Convert.ToInt32(Console.ReadLine());
            Console.Write("So 2: ");     b = Convert.ToInt32(Console.ReadLine());
            Console.Write("So 3: ");     c = Convert.ToInt32(Console.ReadLine());
            if (a > b)
            {
                tam = a;
                a = b;
                b = tam;
            }
            if (a > c)
            {
                tam = a;
                a = c;
                c = tam;
            }
            if (b > c)
            {
                tam = b;
                b = c;
                c = tam;
            }
            Console.WriteLine("So nguyen nho nhat trong 3 so: " + a);    Console.ReadLine();
        }
    }
}
