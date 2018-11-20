using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Nth_Digit
{
    class Program
    {
        static void Main(string[] args)
        {
            long number = long.Parse(Console.ReadLine());
            int index = int.Parse(Console.ReadLine());

            Console.WriteLine(FindNthDigit(number,index));
        }

        private static int FindNthDigit(long number, int index)
        {
            int digit = 0;

            for (int i = 0; i < index; i++)
            {
                digit = (int)number % 10;
                number /= 10;
            }

            return digit;
        }
    }
}
