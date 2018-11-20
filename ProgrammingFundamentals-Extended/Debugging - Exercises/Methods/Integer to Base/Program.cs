using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Integer_to_Base
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            int toBase = int.Parse(Console.ReadLine());

            Console.WriteLine(IntegerToBase(number,toBase));
        }

        private static string IntegerToBase(int number, int toBase)
        {
            string result = string.Empty;

            while(number > 0)
            {
                result = number % toBase + result;
                number /= toBase;
            }

            return result;
        }
    }
}
