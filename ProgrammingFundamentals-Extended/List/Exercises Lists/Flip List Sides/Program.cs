using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Flip_List_Sides
{
    class Program
    {
        static void Main(string[] args)
        {
            var numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var halfNumbers = new List<int>();

            for (int i = 0; i < numbers.Count / 2; i++)
            {
                halfNumbers.Add(numbers[i]);
            }

            for (int i = 1; i < numbers.Count / 2; i++)
            {
                numbers[i] = numbers[(numbers.Count - 1) - i];
            }

            if (numbers.Count % 2 == 0)
            {
                for (int i = numbers.Count - 2; i >= numbers.Count / 2; i--)
                {
                    numbers[i] = halfNumbers[(numbers.Count - 1) - i];
                }
            }
            else
            {
                for (int i = numbers.Count - 2; i > numbers.Count / 2; i--)
                {
                    numbers[i] = halfNumbers[(numbers.Count - 1) - i];
                }
            }

            foreach (var number in numbers)
            {
                Console.Write(number + " ");
            }
        }
    }
}
