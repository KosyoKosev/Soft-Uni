using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Increasing_Sequence_of_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            var numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();

            int minValueNumbers = int.MinValue;

            int counter = 0;

            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] > minValueNumbers)
                {
                    counter++;

                    minValueNumbers = numbers[i];
                }
                
            }

            if (counter == numbers.Length)
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }

        }
    }
}
