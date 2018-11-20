using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Equal_Sequence_of_Elements_in_Array
{
    class Program
    {
        static void Main(string[] args)
        {
            var numbers = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();

            int oldValue = 0;

            var theSame = true;

            for (int i = 0; i < numbers.Length; i++)
            {
                oldValue = numbers[0];

                if (oldValue != numbers[i])
                {
                    theSame = false;
                    break;
                }
            }

            if (theSame == true)
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
