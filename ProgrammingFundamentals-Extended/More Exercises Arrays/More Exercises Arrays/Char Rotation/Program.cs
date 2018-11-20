using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Char_Rotation
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            int[] numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            string result = string.Empty;

            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] % 2 == 0)
                {
                    result += (char)(text[i] - numbers[i]);
                }
                else
                {
                    result += (char)(text[i] + numbers[i]);

                }
            }

            Console.WriteLine(result);
        }
    }
}
