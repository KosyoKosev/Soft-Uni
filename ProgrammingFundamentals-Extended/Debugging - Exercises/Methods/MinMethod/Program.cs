using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MinMethod
{
    class Program
    {
        static void Main(string[] args)
        {
            var number1 = int.Parse(Console.ReadLine());
            var number2 = int.Parse(Console.ReadLine());
            var number3 = int.Parse(Console.ReadLine());

            var minNumber = GetMin(number1, number2);
            minNumber = GetMin(minNumber, number3);
            Console.WriteLine(minNumber);

        }

        private static int GetMin(int number1, int number2)
        {
            if (number1 <= number2)
            {
                return number1;
            }
            else
            {
                return number2;
            }
        }
    }
}
