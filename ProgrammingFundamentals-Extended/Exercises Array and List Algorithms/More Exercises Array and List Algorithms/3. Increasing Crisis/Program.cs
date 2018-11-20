using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3.Increasing_Crisis
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var result = new List<int>();

            for (int i = 0; i < n; i++)
            {
                var numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

                for (int j = 0; j < numbers.Count; j++)
                {
                    result = InsetElement(numbers[j]);
                    if (numbers[j] < numbers[j + 1])
                    {
                        break;
                    }
                }
            }
        }

        private static List<int> InsetElement(int i)
        {
            throw new NotImplementedException();
        }
    }
}
