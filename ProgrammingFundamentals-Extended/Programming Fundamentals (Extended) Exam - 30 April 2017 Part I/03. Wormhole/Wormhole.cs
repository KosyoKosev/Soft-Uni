using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.Wormhole
{
    class Wormhole
    {
        static void Main(string[] args)
        {
            var numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            var currentIndex = 0;
            var counter = 0;

            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] != 0)
                {
                    currentIndex = i;
                    i = numbers[i];
                    numbers[currentIndex] = 0;
                    i--;
                    counter--;
                }
                counter++;
            }

            Console.WriteLine(counter);
        }
    }
}
