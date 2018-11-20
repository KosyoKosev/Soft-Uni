using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Camel_s_Back
{
    class CamelsBack
    {
        static void Main(string[] args)
        {
            var numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var n = int.Parse(Console.ReadLine());

            var counter = 0;

            if (n == numbers.Count)
            {
                Console.WriteLine("already stable: " + string.Join(" ",numbers));
            }
            else
            {
                while (n < numbers.Count)
                {
                    numbers.RemoveAt(0);
                    numbers.RemoveAt(numbers.Count - 1);
                    counter++;
                }

                Console.WriteLine($"{counter} rounds");
                Console.WriteLine($"remaining: {string.Join(" ",numbers)}");
            }
        }
    }
}
