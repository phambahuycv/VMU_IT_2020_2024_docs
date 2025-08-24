using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BTW_6
{
    class Bai_6
    {
        static void Main(string[] args)
        {
            int s = 0;
            for (int i = 1; i <= 1000; i++)
            {
                s = s + i;
                if (s > 1000)
                {
                    Console.Write(i);
                    break;
                }
            }
            Console.ReadLine();
        }
    }
}
