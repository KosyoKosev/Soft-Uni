using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Distinct_List
{
    class DistinctList
    {
        static void Main(string[] args)
        {
            var numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var recurringNumbers = new HashSet<int>();

            for (int i = 0; i < numbers.Count; i++)
            {
                recurringNumbers.Add(numbers[i]);
            }
            
            Console.WriteLine(string.Join(" ", recurringNumbers));
            
        }
    }
}
